//
//  NewTrainingView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 9/5/25.
//

import SwiftUI

struct NewSessionView: View {
        
    @Binding var isPresented: Bool
    
    @ObservedObject var vm = SessionViewModel()
    
    @State private var name: String = ""
    @FocusState private var isNameFocused: Bool
    @State private var description: String = ""
    @FocusState private var isDescriptionFocused: Bool
    
    var body: some View {
        
        NavigationStack {
            VStack {
                nameForm
                    .padding()
                descriptionForm
                    .padding()
                
                Button("Create") {
                    Task {
                        await vm.createSession()
                        await vm.getAllSessions()
                        isPresented = false
                    }
                }
                .buttonBorderShape(.roundedRectangle)
                .tint(Color("AccentColor"))
                .alert(vm.alertMessage, isPresented: $vm.showAlert) {
                    Button("OK", role: .cancel) { }
                }
                .padding(.horizontal, 24)
            }
            .navigationTitle("New Session")
            .toolbar {
                ToolbarItem(placement: .topBarTrailing) {
                    Button {
                        isPresented = false
                    } label: {
                        Image(systemName: "xmark")
                            .imageScale(.large)
                    }
                    
                }
            }
        }
    }
    
    private var nameForm: some View {
        HStack {
            Image(systemName: "text.bubble")
                .foregroundStyle(isNameFocused ? Color("FocusColor") : Color("GrayColor"))
            TextField("", text: $name, prompt: Text("Name of the session").foregroundColor(Color("GrayColor")))
                .foregroundStyle(Color("BlackColor"))
                .focused($isNameFocused)
                .autocorrectionDisabled()
                .keyboardType(.emailAddress)
                .textContentType(.emailAddress)
                .autocapitalization(.none)
        }
        .padding(.vertical, 12)
        .padding(.horizontal)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(isNameFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
        )
        .background(Color("WhiteColor"))
        .cornerRadius(8)
    }
    
    private var descriptionForm: some View {
        HStack {
            Image(systemName: "text.page")
                .foregroundStyle(isDescriptionFocused ? Color("FocusColor") : Color("GrayColor"))
            TextField("", text: $description, prompt: Text("Description").foregroundColor(Color("GrayColor")))
                .foregroundStyle(Color("BlackColor"))
                .focused($isDescriptionFocused)
                .autocorrectionDisabled()
                .keyboardType(.emailAddress)
                .textContentType(.emailAddress)
                .autocapitalization(.none)
        }
        .padding(.vertical, 12)
        .padding(.horizontal)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(isDescriptionFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
        )
        .background(Color("WhiteColor"))
        .cornerRadius(8)
    }

}

#Preview {
    NewSessionView(isPresented: .constant(true))
}

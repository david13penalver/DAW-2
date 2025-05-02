//
//  RegisterView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct RegisterView: View {
    
    @Environment(\.dismiss) var dismiss
    
    @StateObject private var vm = LoginViewModel()
    
    @FocusState private var isNameFocused: Bool
    @FocusState private var isEmailFocused: Bool
    @FocusState private var isPasswordFocused: Bool
        
    var body: some View {
        ZStack {
            
            VStack {
                Spacer()
                name
                email
                password
                Spacer()
                
                Bs24Button(text: "Create user", type: .primary, maxWidth: .infinity) {
                    Task {
                        let success = await vm.createUser()
                        if success {
                            dismiss()
                        }
                    }
                }
                .alert(vm.alertMessage, isPresented: $vm.showAlert) {
                    Button("OK", role: .cancel) { }
                }
                .padding(.horizontal, 24)
                .padding(.horizontal, 24)
                
                Spacer()
            }
        }
        .background(Color("BackgroundColor"), ignoresSafeAreaEdges: .all)
        .onTapGesture {
            isNameFocused = false
            isEmailFocused = false
            isPasswordFocused = false
        }
        
    }
    
    private var name: some View {
        HStack {
            HStack {
                Image(systemName: "person.fill")
                    .foregroundStyle(isNameFocused ? Color("FocusColor") : Color("GrayColor"))
                TextField("", text: $vm.registerName, prompt: Text("User").foregroundColor(Color("GrayColor")))
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
        .withValidation(vm.$registerName)
        .backgroundStyle(Color.clear)
        .padding(.horizontal, 24)
    }
    
    private var email: some View {
        HStack {
            HStack {
                Image(systemName: "envelope.fill")
                    .foregroundStyle(isEmailFocused ? Color("FocusColor") : Color("GrayColor"))
                TextField("", text: $vm.registerEmail, prompt: Text("Email").foregroundColor(Color("GrayColor")))
                    .foregroundStyle(Color("BlackColor"))
                    .focused($isEmailFocused)
                    .autocorrectionDisabled()
                    .keyboardType(.emailAddress)
                    .textContentType(.emailAddress)
                    .autocapitalization(.none)
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isEmailFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .background(Color("WhiteColor"))
            .cornerRadius(8)
        }
        .withValidation(vm.$registerEmail)
        .backgroundStyle(Color.clear)
        .padding(.horizontal, 24)
    }
    
    private var password: some View {
        HStack {
            HStack {
                Image(systemName: "lock.fill")
                    .foregroundStyle(isPasswordFocused ? Color("FocusColor") : Color("GrayColor"))
                TextField("", text: $vm.registerPassword, prompt: Text("Password").foregroundColor(Color("GrayColor")))
                    .foregroundStyle(Color("BlackColor"))
                    .focused($isPasswordFocused)
                    .autocorrectionDisabled()
                    .keyboardType(.emailAddress)
                    .textContentType(.emailAddress)
                    .autocapitalization(.none)
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isPasswordFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .background(Color("WhiteColor"))
            .cornerRadius(8)
        }
        .withValidation(vm.$registerPassword)
        .backgroundStyle(Color.clear)
        .padding(.horizontal, 24)
    }
}

#Preview {
    RegisterView()
}

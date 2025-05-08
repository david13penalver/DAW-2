//
//  NewExerciseView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 8/5/25.
//

import SwiftUI

struct EditExerciseView: View {
        
    @Binding var isPresented: Bool
    
    @ObservedObject var vm: ExerciseViewModel
    
    @State private var showingEditExerciseView = false
    
    @State private var name: String = ""
    @FocusState private var isNameFocused: Bool
    @State private var imageURL: String = ""
    @FocusState private var isImageURLFocused: Bool
    @State private var videoURL: String = ""
    @FocusState private var isVideoURLFocused: Bool
    @State private var isGlobal: Bool?
    @FocusState private var isIsGlobalFocused: Bool
    @State private var description: String = ""
    @FocusState private var isDescriptionFocused: Bool
    @State private var typeName: String = ""
    @FocusState private var isTypeNameFocused: Bool
    @State private var subtypeName: String = ""
    @FocusState private var isSubtypeNameFocused: Bool
    
    var body: some View {
        
        NavigationStack {
            VStack {
                nameForm
                    .padding()
                imageURLForm
                    .padding()
                videoURLForm
                    .padding()
                isGlobalForm
                    .padding()
                descriptionForm
                    .padding()
                typeNameForm
                    .padding()
                subtypeNameForm
                    .padding()
                
                Button("Edit") {
                    Task {
                        await vm.updateExercise(name: name, imageURL: imageURL, videoURL: videoURL, isGlobal: isGlobal ?? false, description: description, typeName: typeName, subtypeName: subtypeName)
                        await vm.findExerciseById(id: vm.exercise!.id!)
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
            .navigationTitle("Edit Exercise")
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
        .onAppear {
            if let exercise = vm.exercise {
                name = exercise.name
                imageURL = exercise.imageURL ?? ""
                videoURL = exercise.videoURL ?? ""
                isGlobal = exercise.isGlobal
                description = exercise.description ?? ""
                typeName = exercise.typeName
                subtypeName = exercise.subtypeName
            }
        }
    }
    
    private var nameForm: some View {
        HStack {
            Image(systemName: "text.bubble")
                .foregroundStyle(isNameFocused ? Color("FocusColor") : Color("GrayColor"))
            TextField("", text: $name, prompt: Text("Name of the exercise").foregroundColor(Color("GrayColor")))
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
    
    private var imageURLForm: some View {
        HStack {
            Image(systemName: "photo")
                .foregroundStyle(isImageURLFocused ? Color("FocusColor") : Color("GrayColor"))
            TextField("", text: $imageURL, prompt: Text("Image URL").foregroundColor(Color("GrayColor")))
                .foregroundStyle(Color("BlackColor"))
                .focused($isImageURLFocused)
                .autocorrectionDisabled()
                .keyboardType(.emailAddress)
                .textContentType(.emailAddress)
                .autocapitalization(.none)
        }
        .padding(.vertical, 12)
        .padding(.horizontal)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(isImageURLFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
        )
        .background(Color("WhiteColor"))
        .cornerRadius(8)
    }
    
    private var videoURLForm: some View {
        HStack {
            Image(systemName: "person.crop.square.badge.video")
                .foregroundStyle(isVideoURLFocused ? Color("FocusColor") : Color("GrayColor"))
            TextField("", text: $videoURL, prompt: Text("Video URL").foregroundColor(Color("GrayColor")))
                .foregroundStyle(Color("BlackColor"))
                .focused($isVideoURLFocused)
                .autocorrectionDisabled()
                .keyboardType(.emailAddress)
                .textContentType(.emailAddress)
                .autocapitalization(.none)
        }
        .padding(.vertical, 12)
        .padding(.horizontal)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(isVideoURLFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
        )
        .background(Color("WhiteColor"))
        .cornerRadius(8)
    }
    
    private var isGlobalForm: some View {
        VStack {
            Text("Is a global exercise?")
                .foregroundStyle(isIsGlobalFocused ? Color("FocusColor") : Color("GrayColor"))
            HStack {
                Image(systemName: "globe")
                    .foregroundStyle(isIsGlobalFocused ? Color("FocusColor") : Color("GrayColor"))
                Picker("Is a global exercise?", selection: Binding($isGlobal, replacingNilWith: false)) {
                    Text("True").tag(true)
                    Text("False").tag(false)
                }
                .pickerStyle(.segmented)
                .foregroundColor(Color("BlackColor"))
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isNameFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .cornerRadius(8)
        }
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
    
    private var typeNameForm: some View {
        VStack {
            Text("What type of exercise is it?")
                .foregroundStyle(isTypeNameFocused ? Color("FocusColor") : Color("GrayColor"))
            HStack {
                Image(systemName: "figure.skiing.downhill")
                    .foregroundStyle(isTypeNameFocused ? Color("FocusColor") : Color("GrayColor"))
                Picker("Exercise type?", selection: $typeName) {
                    Text("Resistance").tag("Resistance")
                        .background(.blue)
                    Text("Cardio").tag("Cardio")
                    Text("Mobility").tag("Mobility")
                }
                .pickerStyle(.segmented)
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isSubtypeNameFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .cornerRadius(8)
        }
    }
    
    private var subtypeNameForm: some View {
        VStack {
            Text("Main musculature involved")
            HStack {
                Image(systemName: "figure")
                    .foregroundStyle(isSubtypeNameFocused ? Color("FocusColor") : Color("GrayColor"))
                Picker("Subtype", selection: $subtypeName) {
                    ForEach(exerciseSubtypeOptions) { option in
                        Text(option.name).tag(option.name)
                    }
                }
                .pickerStyle(.navigationLink)
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(.leading, 4)
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isSubtypeNameFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .cornerRadius(8)
        }
    }
    
    struct ExerciseSubtypeOption: Identifiable {
        let id = UUID()
        let name: String
    }

    let exerciseSubtypeOptions: [ExerciseSubtypeOption] = [
        .init(name: "Chest"),
        .init(name: "Back"),
        .init(name: "Shoulders"),
        .init(name: "HIIT"),
        .init(name: "SIT"),
        .init(name: "LISS"),
        .init(name: "Static Stretching"),
        .init(name: "Dynamic Stretching"),
        .init(name: "Balistic Stretching"),
        .init(name: "Passive Stretching"),
        .init(name: "Leg"),
        .init(name: "Core"),
        .init(name: "Biceps"),
        .init(name: "Glutes"),
        .init(name: "Calves"),
        .init(name: "Quadriceps"),
        .init(name: "Hamstrings"),
        .init(name: "Triceps")
    ]

}

#Preview {
    EditExerciseView(isPresented: .constant(true), vm: ExerciseViewModel())
}

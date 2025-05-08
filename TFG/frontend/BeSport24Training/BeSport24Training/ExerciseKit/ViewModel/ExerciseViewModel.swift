//
//  ExerciseViewModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

@MainActor
final class ExerciseViewModel: ObservableObject {
    
    @Published var exercise: ExerciseModel?
    @Published var exercises: [ExerciseModel] = []
    @Published var newExercise: ExerciseModel?
    
    @Published var showAlert: Bool = false
    @Published var alertMessage: String = ""
        
    private let interactor: ExerciseInteractorProtocol
    
    init(interactor: ExerciseInteractorProtocol = ExerciseInteractorImpl()) {
        self.interactor = interactor
    }
    
    func getAllExercises() async {
        do {
            let response = try await interactor.getAllExercises()
            exercises = response
        } catch {
            print("Error loading exercises: \(error.localizedDescription)")
        }
    }
    
    func findExerciseById(id: Int) async {
        do {
            let response = try await interactor.findExerciseById(id: id)
            exercise = response
        } catch {
            print("Error loading exercise: \(error.localizedDescription)")
        }
    }
    
    func createExercise(name: String, imageURL: String, videoURL: String, isGlobal: Bool, description: String, typeName: String, subtypeName: String) async {
        let trimmedName = name.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedImageURL = imageURL.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedVideoURL = videoURL.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedDescription = description.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedTypeName = typeName.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedSubtypeName = subtypeName.trimmingCharacters(in: .whitespacesAndNewlines)

        if trimmedName.isEmpty {
            alertMessage = "Name is required"
            showAlert = true
            return
        } else if trimmedImageURL.isEmpty {
            alertMessage = "Image URL is required"
            showAlert = true
            return
        } else if trimmedVideoURL.isEmpty {
            alertMessage = "Video URL is required"
            showAlert = true
            return
        } else if trimmedDescription.isEmpty {
            alertMessage = "Description is required"
            showAlert = true
            return
        } else if trimmedTypeName.isEmpty {
            alertMessage = "Type Name is required"
            showAlert = true
            return
        } else if trimmedSubtypeName.isEmpty {
            alertMessage = "Subtype Name is required"
            showAlert = true
            return
        }
        
        let newExercise = ExerciseModel(
            exerciseId: 0,
            name: trimmedName,
            imageURL: trimmedImageURL,
            videoURL: trimmedVideoURL,
            isGlobal: isGlobal,
            description: trimmedDescription,
            typeName: trimmedTypeName,
            subtypeName: trimmedSubtypeName
        )
        
        do {
            try await interactor.createExercise(exercise: newExercise)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func updateExercise(name: String, imageURL: String, videoURL: String, isGlobal: Bool, description: String, typeName: String, subtypeName: String) async {
        let trimmedName = name.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedImageURL = imageURL.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedVideoURL = videoURL.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedDescription = description.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedTypeName = typeName.trimmingCharacters(in: .whitespacesAndNewlines)
        let trimmedSubtypeName = subtypeName.trimmingCharacters(in: .whitespacesAndNewlines)

        if trimmedName.isEmpty {
            alertMessage = "Name is required"
            showAlert = true
            return
        } else if trimmedImageURL.isEmpty {
            alertMessage = "Image URL is required"
            showAlert = true
            return
        } else if trimmedVideoURL.isEmpty {
            alertMessage = "Video URL is required"
            showAlert = true
            return
        } else if trimmedDescription.isEmpty {
            alertMessage = "Description is required"
            showAlert = true
            return
        } else if trimmedTypeName.isEmpty {
            alertMessage = "Type Name is required"
            showAlert = true
            return
        } else if trimmedSubtypeName.isEmpty {
            alertMessage = "Subtype Name is required"
            showAlert = true
            return
        }
        
        let newExercise = ExerciseModel(
            exerciseId: exercise?.id ?? 0,
            name: trimmedName,
            imageURL: trimmedImageURL,
            videoURL: trimmedVideoURL,
            isGlobal: isGlobal,
            description: trimmedDescription,
            typeName: trimmedTypeName,
            subtypeName: trimmedSubtypeName
        )
        
        do {
            try await interactor.updateExercise(exercise: newExercise)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func deleteExercise(id: Int) async {
        do {
            try await interactor.deleteExercise(id: id)
        } catch {
            print(error.localizedDescription)
        }
    }
}

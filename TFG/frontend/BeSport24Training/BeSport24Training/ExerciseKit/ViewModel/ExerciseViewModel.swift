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
    
    func createExercise() async {
        do {
            try await interactor.createExercise(exercise: exercise!)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func updateExerciseById() async {
        do {
            try await interactor.updateExercise(exercise: exercise!)
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

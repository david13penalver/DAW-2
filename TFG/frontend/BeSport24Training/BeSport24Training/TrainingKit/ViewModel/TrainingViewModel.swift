//
//  TrainingViewModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

@MainActor
final class TrainingViewModel: ObservableObject {
    
    @Published var training: TrainingModel?
    @Published var trainings: [TrainingModel] = []
    @Published var exercises: [SessionExercisesModel] = []
    
    @Published var showAlert: Bool = false
    @Published var alertMessage: String = ""
    
    private let interactor: TrainingInteractorProtocol
    private let sessionInteractor: SessionInteractorProtocol
    
    init(interactor: TrainingInteractorProtocol = TrainingInteractorImpl(),
         sessionInteractor: SessionInteractorProtocol = SessionInteractorImpl()) {
        self.interactor = interactor
        self.sessionInteractor = sessionInteractor
    }
    
    func getAllTrainings() async {
        do {
            let response = try await interactor.getAllTrainings()
            trainings = response
        } catch {
            print("Error loading trainings: \(error.localizedDescription)")
        }
    }
    
    func findTrainingById(id: Int) async {
        do {
            let response = try await interactor.findTrainingById(id: id)
            training = response
        } catch {
            print("Error loading training: \(error.localizedDescription)")
        }
    }
    
    func findExercisesBySessionId(id: Int) async {
        do {
            let response = try await sessionInteractor.findExercisesBySessionId(id: id)
            exercises = response
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func deleteTraining(id: Int) async {
        do {
            try await interactor.deleteTraining(id: id)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func updateTraining(name: String, description: String) async {
        
        do {
            try await interactor.updateTraining(training: training!)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func createTraining() async {
        
        do {
            try await interactor.createTraining(training: training!)
        } catch {
            print(error.localizedDescription)
        }
    }
}

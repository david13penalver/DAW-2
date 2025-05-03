//
//  ExerciseInteractor.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

protocol ExerciseInteractorProtocol {
    func getAllExercises() async throws -> [ExerciseModel]
    func findExerciseById(id: Int) async throws -> ExerciseModel
    func createExercise(exercise: ExerciseModel) async throws
    func updateExercise(exercise: ExerciseModel) async throws
    func deleteExercise(id: Int) async throws
}

class ExerciseInteractorImpl: ExerciseInteractorProtocol {
    
    private let api: ExerciseAPIProtocol
    
    init(api: ExerciseAPIProtocol = ExerciseAPIImpl()) {
        self.api = api
    }
}

@APIActor
extension ExerciseInteractorImpl {
    
    func getAllExercises() async throws -> [ExerciseModel] {
        let dtos = try await api.getAllExercises()
        return dtos.map { ExerciseModel(from: $0) }
    }
    
    func findExerciseById(id: Int) async throws -> ExerciseModel {
        let dto = try await api.findExerciseById(id: id)
        return ExerciseModel(from: dto)
    }
    
    func createExercise(exercise: ExerciseModel) async throws {
        
    }
    
    func updateExercise(exercise: ExerciseModel) async throws {
        
    }
    
    func deleteExercise(id: Int) async throws {
        
    }
    
    
}

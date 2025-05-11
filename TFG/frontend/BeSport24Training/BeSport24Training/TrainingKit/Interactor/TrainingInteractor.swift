//
//  TrainingInteractor.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

protocol TrainingInteractorProtocol {
    func getAllTrainings() async throws -> [TrainingModel]
    func findTrainingById(id: Int) async throws -> TrainingModel
    func createTraining(training: TrainingModel) async throws
    func updateTraining(training: TrainingModel) async throws
    func deleteTraining(id: Int) async throws
}

class TrainingInteractorImpl: TrainingInteractorProtocol {
    
    private let api: TrainingAPIProtocol
    
    init(api: TrainingAPIProtocol = TrainingAPIImpl()) {
        self.api = api
    }
    
}

@APIActor
extension TrainingInteractorImpl {
    func getAllTrainings() async throws -> [TrainingModel] {
        let dtos = try await api.getAllTrainings()
        return dtos.map { TrainingModel(from: $0) }
    }
    
    func findTrainingById(id: Int) async throws -> TrainingModel {
        let dto: TrainingDTO = try await api.findTrainingById(id: id)
        return TrainingModel(from: dto)
    }
    
    func createTraining(training: TrainingModel) async throws {
        let dto = TrainingDTO(from: training)
        
        try await api.createTraining(dto: dto)
    }
    
    func updateTraining(training: TrainingModel) async throws {
        let dto = TrainingDTO(from: training)
        
        try await api.updateTraining(dto: dto)
    }
    
    func deleteTraining(id: Int) async throws {
        try await api.deleteTraining(id: id)
    }
}

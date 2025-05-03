//
//  TrainingAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol TrainingAPIProtocol {
    func getAllTrainings() -> [TrainingDTO]
    func getTrainingByIdTraining(id: Int) -> TrainingDTO
    func createTraining(training: TrainingModel)
    func updateTraining(training: TrainingModel)
    func deleteTraining(training: TrainingModel)
}

final class TrainingAPIImpl: TrainingAPIProtocol {
    func getAllTrainings() -> [TrainingDTO] {
        return []
    }
    
    func getTrainingByIdTraining(id: Int) -> TrainingDTO {
        return TrainingDTO(id: -1)
    }
    
    func createTraining(training: TrainingModel) {
        
    }
    
    func updateTraining(training: TrainingModel) {
        
    }
    
    func deleteTraining(training: TrainingModel) {
        
    }
    
}

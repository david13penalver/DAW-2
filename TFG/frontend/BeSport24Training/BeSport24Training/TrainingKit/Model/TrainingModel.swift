//
//  TrainingModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

struct TrainingModel: Sendable, Identifiable {
    
    let id: Int
    let trainingId: Int
    let name: String
    let trainingDurationSeconds: Int
    let dateCreation: Date?
    let session: SessionModel?
    
    init(id: Int, trainingId: Int, name: String, trainingDurationSeconds: Int, dateCreation: Date?, session: SessionModel?) {
        self.id = id
        self.trainingId = trainingId
        self.name = name
        self.trainingDurationSeconds = trainingDurationSeconds
        self.dateCreation = dateCreation
        self.session = session
    }
    
    init(from dto: TrainingDTO) {
        self.id = dto.id
        self.trainingId = dto.trainingId
        self.name = dto.name
        self.trainingDurationSeconds = dto.trainingDurationSeconds
        self.dateCreation = dto.dateCreation
        self.session = dto.session.map { SessionModel(dto: $0) }
    }
}

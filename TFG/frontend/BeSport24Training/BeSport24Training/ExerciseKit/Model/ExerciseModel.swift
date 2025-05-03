//
//  ExerciseModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

struct ExerciseModel: Encodable, Sendable, Identifiable {
    let exerciseId: Int
    let name: String
    let imageURL: String?
    let videoURL: String?
    let isGlobal: Bool?
    let description: String?
    let typeName: String
    let subtypeName: String
    
    var id: Int { exerciseId }
    
    init(from dto: ExerciseDTO) {
        self.exerciseId = dto.exerciseId
        self.name = dto.name
        self.imageURL = dto.imageURL
        self.videoURL = dto.videoURL
        self.isGlobal = dto.isGlobal
        self.description = dto.description
        self.typeName = dto.exerciseType.name
        self.subtypeName = dto.exerciseSubtype.name
    }
}

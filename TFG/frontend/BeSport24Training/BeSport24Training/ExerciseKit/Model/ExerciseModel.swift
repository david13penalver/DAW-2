//
//  ExerciseModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

struct ExerciseDescription: Codable {
    let what_is: String
    let muscles_involved: String
    let steps: [String]
}

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
    
    var parsedDescription: ExerciseDescription? {
        guard let description, let data = description.data(using: .utf8) else { return nil }
        return try? JSONDecoder().decode(ExerciseDescription.self, from: data)
    }
    
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
    
    init(exerciseId: Int, name: String, imageURL: String?, videoURL: String?, isGlobal: Bool?, description: String?, typeName: String, subtypeName: String) {
        self.exerciseId = exerciseId
        self.name = name
        self.imageURL = imageURL
        self.videoURL = videoURL
        self.isGlobal = isGlobal
        self.description = description
        self.typeName = typeName
        self.subtypeName = subtypeName
    }
}

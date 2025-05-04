//
//  ExerciseDTO.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

struct ExerciseDTO: Codable, Identifiable {
    var id: Int? { exerciseId }
    let exerciseId: Int
    let name: String
    let imageURL: String
    let videoURL: String?
    let isGlobal: Bool?
    let description: String?
    let exerciseType: ExerciseTypeDTO
    let exerciseSubtype: ExerciseSubtypeDTO
    
    init(exerciseId: Int, name: String, imageURL: String, videoURL: String?, isGlobal: Bool?, description: String?, exerciseType: ExerciseTypeDTO, exerciseSubtype: ExerciseSubtypeDTO) {
        self.exerciseId = exerciseId
        self.name = name
        self.imageURL = imageURL
        self.videoURL = videoURL
        self.isGlobal = isGlobal
        self.description = description
        self.exerciseType = exerciseType
        self.exerciseSubtype = exerciseSubtype
    }
}

struct ExerciseTypeDTO: Codable {
    let exerciseTypeId: Int
    let name: String
}

struct ExerciseSubtypeDTO: Codable {
    let exerciseTypeId: Int
    let name: String
}

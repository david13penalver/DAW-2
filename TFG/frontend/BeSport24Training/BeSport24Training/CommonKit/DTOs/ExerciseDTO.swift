//
//  ExerciseDTO.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

struct ExerciseDTO: Codable, Identifiable {
    var id: Int { exerciseId }
    let exerciseId: Int
    let name: String
    let imageURL: String
    let videoURL: String?
    let isGlobal: Bool?
    let description: String?
    let exerciseType: ExerciseTypeDTO
    let exerciseSubtype: ExerciseSubtypeDTO
}

struct ExerciseTypeDTO: Codable {
    let exerciseTypeId: Int
    let name: String
}

struct ExerciseSubtypeDTO: Codable {
    let exerciseTypeId: Int
    let name: String
}

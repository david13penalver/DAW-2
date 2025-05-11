//
//  SessionExercisesModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 11/5/25.
//

struct SessionExercisesModel: Codable, Identifiable, Sendable {
    var id: Int { sessionExercisesId }
    
    let sessionExercisesId: Int
    let numSets: Int
    let numReps: Int
    let restSeconds: Int
    let exercise: ExerciseDTO
    
    init(sessionExercisesId: Int, numSets: Int, numReps: Int, restSeconds: Int, exercise: ExerciseDTO) {
        self.sessionExercisesId = sessionExercisesId
        self.numSets = numSets
        self.numReps = numReps
        self.restSeconds = restSeconds
        self.exercise = exercise
    }
    
    init(from dto: SessionExercisesDTO) {
        self.sessionExercisesId = dto.sessionExercisesId
        self.numSets = dto.numSets
        self.numReps = dto.numReps
        self.restSeconds = dto.restSeconds
        self.exercise = dto.exercise
    }
}

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
        var exerciseTypeDTO: ExerciseTypeDTO!
        var exerciseSubtypeDTO: ExerciseSubtypeDTO!
        
        switch exercise.typeName {
        case "Resistance":
            exerciseTypeDTO = .init(exerciseTypeId: 1, name: "Resistance")
        case "Cardio":
            exerciseTypeDTO = .init(exerciseTypeId: 2, name: "Cardio")
        case "Mobility":
            exerciseTypeDTO = .init(exerciseTypeId: 3, name: "Mobility")
        default:
            fatalError("Unsupported exercise type")
        }
        
        switch exercise.subtypeName {
        case "Chest":
            exerciseSubtypeDTO = .init(exerciseTypeId: 1, name: "Chest")
        case "Back":
            exerciseSubtypeDTO = .init(exerciseTypeId: 2, name: "Back")
        case "Shoulders":
            exerciseSubtypeDTO = .init(exerciseTypeId: 3, name: "Shoulders")
        case "HIIT":
            exerciseSubtypeDTO = .init(exerciseTypeId: 4, name: "HIIT")
        case "SIT":
            exerciseSubtypeDTO = .init(exerciseTypeId: 5, name: "SIT")
        case "LISS":
            exerciseSubtypeDTO = .init(exerciseTypeId: 6, name: "LISS")
        case "Static Stretching":
            exerciseSubtypeDTO = .init(exerciseTypeId: 7, name: "Static Stretching")
        case "Dynamic Stretching":
            exerciseSubtypeDTO = .init(exerciseTypeId: 8, name: "Dynamic Stretching")
        case "Balistic Stretching":
            exerciseSubtypeDTO = .init(exerciseTypeId: 9, name: "Balistic Stretching")
        case "Passive Stretching":
            exerciseSubtypeDTO = .init(exerciseTypeId: 10, name: "Passive Stretching")
        case "Leg":
            exerciseSubtypeDTO = .init(exerciseTypeId: 11, name: "Leg")
        case "Core":
            exerciseSubtypeDTO = .init(exerciseTypeId: 12, name: "Core")
        case "Biceps":
            exerciseSubtypeDTO = .init(exerciseTypeId: 13, name: "Biceps")
        case "Glutes":
            exerciseSubtypeDTO = .init(exerciseTypeId: 14, name: "Glutes")
        case "Calves":
            exerciseSubtypeDTO = .init(exerciseTypeId: 15, name: "Calves")
        case "Quadriceps":
            exerciseSubtypeDTO = .init(exerciseTypeId: 16, name: "Quadriceps")
        case "Hamstrings":
            exerciseSubtypeDTO = .init(exerciseTypeId: 17, name: "Hamstrings")
        case "Triceps":
            exerciseSubtypeDTO = .init(exerciseTypeId: 18, name: "Triceps")
        default:
            fatalError("Unsupported exercise subtype")
        }
        
        print(exercise)
        
        let dto = ExerciseDTO(exerciseId: -1, name: exercise.name, imageURL: exercise.imageURL ?? "", videoURL: exercise.videoURL, isGlobal: exercise.isGlobal, description: exercise.description, exerciseType: exerciseTypeDTO, exerciseSubtype: exerciseSubtypeDTO)
        
        try await api.createExercise(dto: dto)
    }
    
    func updateExercise(exercise: ExerciseModel) async throws {
        
    }
    
    func deleteExercise(id: Int) async throws {
        
    }
    
    
}

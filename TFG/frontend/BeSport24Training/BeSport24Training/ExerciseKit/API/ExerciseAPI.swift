//
//  ExerciseAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol ExerciseAPIProtocol {
    func getAllExercises() async throws -> [ExerciseDTO]
    func findExerciseById(id: Int) async throws -> ExerciseDTO
    func createExercise(dto: ExerciseDTO) async throws
    func updateExercise(exercise: ExerciseDTO) async throws
    func deleteExercise(id: Int) async throws
}

struct ExerciseListResponse: Codable {
    let data: [ExerciseDTO]
}

final class ExerciseAPIImpl: ExerciseAPIProtocol {
    func getAllExercises() async throws -> [ExerciseDTO] {
        guard let url = URL(string: "\(BaseURL.baseURL)exercises") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        print(String(data: data, encoding: .utf8) ?? "Invalid JSON")
        
        let decodedResponse = try JSONDecoder().decode(ExerciseListResponse.self, from: data)
        return decodedResponse.data
    }
    
    func findExerciseById(id: Int) async throws -> ExerciseDTO {
        guard let url = URL(string: "\(BaseURL.baseURL)exercises/\(id)") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(ExerciseDTO.self, from: data)
        return decodedResponse
    }
    
    func createExercise(dto: ExerciseDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)exercises") else { throw URLError(.badURL) }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.setValue( "application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONEncoder().encode(dto)
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    func updateExercise(exercise: ExerciseDTO) async throws {
        
    }
    
    func deleteExercise(id: Int) async throws {
        
    }
    
    
}

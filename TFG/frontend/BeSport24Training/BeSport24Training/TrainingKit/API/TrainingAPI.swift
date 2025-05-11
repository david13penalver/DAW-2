//
//  TrainingAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol TrainingAPIProtocol {
    func getAllTrainings() async throws -> [TrainingDTO]
    func findTrainingById(id: Int) async throws -> TrainingDTO
    func createTraining(dto: TrainingDTO) async throws
    func updateTraining(dto: TrainingDTO) async throws
    func deleteTraining(id: Int) async throws
}

struct TrainingListResponse: Codable {
    let data: [TrainingDTO]
}

final class TrainingAPIImpl: TrainingAPIProtocol {
    func getAllTrainings() async throws -> [TrainingDTO] {
        guard let url = URL(string: "\(BaseURL.baseURL)trainings") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(TrainingListResponse.self, from: data)
        return decodedResponse.data
    }
    
    func findTrainingById(id: Int) async throws -> TrainingDTO {
        guard let url = URL(string: "\(BaseURL.baseURL)trainings/\(id)") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(TrainingDTO.self, from: data)
        return decodedResponse
    }
    
    func createTraining(dto: TrainingDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)trainings") else { throw URLError(.badURL) }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.setValue( "application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONEncoder().encode(dto)
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    func updateTraining(dto: TrainingDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)trainings/\(dto.id)") else {
            throw URLError(.badURL)
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "PUT"
        request.setValue( "application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONEncoder().encode(dto)
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    func deleteTraining(id: Int) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)trainings/\(id)") else {
            throw URLError(.badURL)
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "DELETE"
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    
    
}

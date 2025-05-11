//
//  SessionAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol SessionAPIProtocol {
    func getAllSessions() async throws -> [SessionDTO]
    func findSessionById(id: Int) async throws -> SessionDTO
    func findExercisesBySessionId(id: Int) async throws -> [SessionExercisesDTO]
    func createSession(dto: SessionDTO) async throws
    func updateSession(dto: SessionDTO) async throws
    func deleteSession(id: Int) async throws
}

struct SessionListResponse: Codable {
    let data: [SessionDTO]
}

struct SessionExerciseListResponse: Codable {
    let data: [SessionExercisesDTO]
}

final class SessionAPIImpl: SessionAPIProtocol {
    func getAllSessions() async throws -> [SessionDTO] {
        guard let url = URL(string: "\(BaseURL.baseURL)sessions") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(SessionListResponse.self, from: data)
        return decodedResponse.data
    }
    
    func findSessionById(id: Int) async throws -> SessionDTO {
        guard let url = URL(string: "\(BaseURL.baseURL)sessions/\(id)") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(SessionDTO.self, from: data)
        return decodedResponse
    }
    
    func findExercisesBySessionId(id: Int) async throws -> [SessionExercisesDTO] {
        guard let url = URL(string: "\(BaseURL.baseURL)sessionsexercises/session/\(id)") else { throw URLError(.badURL) }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        
        let decodedResponse = try JSONDecoder().decode(SessionExerciseListResponse.self, from: data)
        return decodedResponse.data
    }
    
    func createSession(dto: SessionDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)sessions") else { throw URLError(.badURL) }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.setValue( "application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONEncoder().encode(dto)
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    func updateSession(dto: SessionDTO) async throws {
        guard /*let id: Int = dto.id,*/
            let url = URL(string: "\(BaseURL.baseURL)sessions/\(dto.id)") else {
            throw URLError(.badURL)
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "PUT"
        request.setValue( "application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONEncoder().encode(dto)
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
    
    func deleteSession(id: Int) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)sessions/\(id)") else {
            throw URLError(.badURL)
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "DELETE"
        
        (_, _) = try await URLSession.shared.data(for: request)
    }
}

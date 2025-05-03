//
//  UserAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol UserAPIProtocol {
    func fetchUser(user: UserDTO) async throws -> Int
    func createUser(user: UserDTO) async throws
    func findUserById(id: Int) async throws -> UserDTO
}

final class UserAPIImpl: UserAPIProtocol {
    func findUserById(id: Int) async throws -> UserDTO {
        guard let url = URL(string: "\(BaseURL.baseURL)users/\(id)") else { throw URLError(.badURL) }
        
        var request = URLRequest(url: url)
        request.httpMethod = "GET"
        
        let (data, _) = try await URLSession.shared.data(for: request)
        
        let decoder = JSONDecoder()
        let user = try decoder.decode(UserDTO.self, from: data)
        
        return user
    }
    
    func fetchUser(user: UserDTO) async throws -> Int {
        guard let url = URL(string: "\(BaseURL.baseURL)users/1") else { return -1 }
                
        let (data, _) = try await URLSession.shared.data(from: url)
        
        return 1
    }
    
    func createUser(user: UserDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)users") else { return }
        
        var response = URLRequest(url: url)
        response.httpMethod = "POST"
        response.httpBody = try? JSONEncoder().encode(user)
        
        _ = try await URLSession.shared.data(for: response)
    }
    
}

//
//  UserAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol UserAPIProtocol {
    func fetchUser(user: UserDTO) async throws
    func createUser(user: UserDTO) async throws
}

final class UserAPIImpl: UserAPIProtocol {
    func fetchUser(user: UserDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)users/1") else { return }
                
        let response = try await URLSession.shared.data(from: url)
    }
    
    func createUser(user: UserDTO) async throws {
        guard let url = URL(string: "\(BaseURL.baseURL)users") else { return }
        
        var response = URLRequest(url: url)
        response.httpMethod = "POST"
        response.httpBody = try? JSONEncoder().encode(user)
        
        _ = try await URLSession.shared.data(for: response)
    }
    
}

//
//  UserAPI.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import Foundation

protocol UserAPIProtocol {
    func fetchUser(user: UserDTO) async throws
}

final class UserAPIImpl: UserAPIProtocol {
    func fetchUser(user: UserDTO) async throws {
        guard let url = URL(string: "http://localhost:3000/users/1") else { return }
        
        let response = try await URLSession.shared.data(from: url)
    }
    
    
}

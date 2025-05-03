//
//  UserInteractor.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

protocol UserInteractorProtocol {
    func fetchUser(user: UserModel) async throws -> Int
    func findUserById(id: Int) async throws -> UserModel
    func createUser(user: UserModel) async throws
    func updateUser(user: UserModel) async throws
    func deleteUser(user: UserModel) async throws
}


class UserInteractorImpl: UserInteractorProtocol {
    
    private let api: UserAPIProtocol
    
    init(api: UserAPIProtocol = UserAPIImpl()) {
        self.api = api
    }
}

@APIActor
extension UserInteractorImpl {
    func fetchUser(user: UserModel) async throws -> Int {
        let requestObject: UserDTO = UserDTO(email: user.email, password: user.password)
        
        let response: Int = try await api.fetchUser(user: requestObject)
        
        return response
    }
    
    func findUserById(id: Int) async throws -> UserModel {
        let response = try await api.findUserById(id: id)
        
        let user: UserModel = UserModel(dto: response)
        
        return user
    }
    
    func createUser(user: UserModel) async throws {
        let requestObject: UserDTO = UserDTO(name: user.name!, email: user.email, password: user.password)
        
        try await api.createUser(user: requestObject)
    }
    
    func updateUser(user: UserModel) async throws {
        
    }
    
    func deleteUser(user: UserModel) async throws {
        
    }
}

@globalActor
actor APIActor: Sendable {
    static let shared = APIActor()
}

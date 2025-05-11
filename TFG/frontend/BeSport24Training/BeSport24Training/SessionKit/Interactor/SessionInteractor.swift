//
//  SessionInteractor.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

protocol SessionInteractorProtocol {
    func getAllSessions() async throws -> [SessionModel]
    func findSessionById(id: Int) async throws -> SessionModel
    func createSession(session: SessionModel) async throws
    func updateSession(session: SessionModel) async throws
    func deleteSession(id: Int) async throws
}

class SessionInteractorImpl: SessionInteractorProtocol {
    
    private let api: SessionAPIProtocol
    
    init(api: SessionAPIProtocol = SessionAPIImpl()) {
        self.api = api
    }
}

@APIActor
extension SessionInteractorImpl {
    
    func getAllSessions() async throws -> [SessionModel] {
        let dtos = try await api.getAllSessions()
        return dtos.map { SessionModel(dto: $0) }
    }
    
    func findSessionById(id: Int) async throws -> SessionModel {
        let dto = try await api.findSessionById(id: id)
        return SessionModel(dto: dto)
    }
    
    func createSession(session: SessionModel) async throws {
        
    }
    
    func updateSession(session: SessionModel) async throws {
        
    }
    
    func deleteSession(id: Int) async throws {
        try await api.deleteSession(id: id)
    }
    
}

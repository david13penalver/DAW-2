//
//  SessionViewModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

@MainActor
final class SessionViewModel: ObservableObject {
    
    @Published var session: SessionModel?
    @Published var sessions: [SessionModel] = []
    @Published var exercises: [SessionExercisesModel] = []
    
    @Published var showAlert: Bool = false
    @Published var alertMessage: String = ""
        
    private let interactor: SessionInteractorProtocol
    
    init(interactor: SessionInteractorProtocol = SessionInteractorImpl()) {
        self.interactor = interactor
    }
    
    func getAllSessions() async {
        do {
            let response = try await interactor.getAllSessions()
            sessions = response
        } catch {
            print("Error loading sessions: \(error.localizedDescription)")
        }
    }
    
    func findSessionById(id: Int) async {
        do {
            let response = try await interactor.findSessionById(id: id)
            session = response
        } catch {
            print("Error loading session: \(error.localizedDescription)")
        }
    }
    
    func findExercisesBySessionId(id: Int) async {
        do {
            let response = try await interactor.findExercisesBySessionId(id: id)
            exercises = response
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func deleteSession(id: Int) async {
        do {
            try await interactor.deleteSession(id: id)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func updateSession(name: String, description: String) async {
        
        do {
            try await interactor.updateSession(session: session!)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func createSession() async {
        
        do {
            try await interactor.createSession(session: session!)
        } catch {
            print(error.localizedDescription)
        }
    }
    
}

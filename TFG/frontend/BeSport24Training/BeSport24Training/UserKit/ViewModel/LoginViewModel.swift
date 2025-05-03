//
//  LoginViewModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation
import SwiftUI

@MainActor
final class LoginViewModel: ObservableObject {
    
    // MARK: When logging
    @Validate(
        .required("This field is required")
        )
    var email: String = ""
    
    @Validate(
        .required("This field is required")
        )
    var password: String = ""
    
    // MARK: When registering
    @Validate(
        .required("This field is required")
        )
    var registerEmail: String = ""
    @Validate(
        .required("This field is required")
        )
    var registerPassword: String = ""
    @Validate(
        .required("This field is required")
        )
    var registerName: String = ""
    
    @Published var showAlert: Bool = false
    @Published var alertMessage: String = ""
    
    @AppStorage("isLoggedIn") var isLoggedIn = false
    @AppStorage("id") var id = -1
    
    // MARK: When logged
    @State var user: UserModel?

    private let interactor: UserInteractorProtocol
    
    init(interactor: UserInteractorProtocol = UserInteractorImpl()) {
        self.interactor = interactor
    }
    
    func login() async {
        guard !email.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty else {
            alertMessage = "Email is required"
            showAlert = true
            return
        }
        
        guard !password.isEmpty else {
            alertMessage = "Password is required"
            showAlert = true
            return
        }
        
        let login = UserModel(email: email, password: password)

        do {
            id = try await interactor.fetchUser(user: login)
            
            isLoggedIn = true
        } catch {
            self.password = ""
            showAlert = true
            alertMessage = "Email or password not correct"
            print(error.localizedDescription)
        }
    }
    
    func findUserById() async {
        do {
            let data = try await interactor.findUserById(id: self.id)
            user?.id = id
            user?.name = data.name
            user?.email = data.email
            user?.password = data.password
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func createUser() async -> Bool {
        guard !registerName.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty else {
            alertMessage = "Name is required"
            showAlert = true
            return false
        }
        
        guard !registerEmail.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty else {
            alertMessage = "Email is required"
            showAlert = true
            return false
        }
        
        guard !registerPassword.isEmpty else {
            alertMessage = "Password is required"
            showAlert = true
            return false
        }
        
        let user = UserModel(name: registerName, email: registerEmail, password: registerPassword)
        
        do {
            try await interactor.createUser(user: user)
            registerName = ""
            registerEmail = ""
            registerPassword = ""
            return true
        } catch {
            showAlert = true
            alertMessage = "Error creating the user. The email already exists"
            registerName = ""
            registerEmail = ""
            registerPassword = ""
            print(error.localizedDescription)
            return false
        }
    }
}

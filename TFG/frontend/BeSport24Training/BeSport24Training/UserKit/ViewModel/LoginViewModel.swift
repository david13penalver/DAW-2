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
    
    @Validate(
        .required("This field is required")
        )
    var email: String = ""
    
    @Validate(
        .required("This field is required")
        )
    var password: String = ""
    
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
            try await interactor.fetchUser(user: login)
            
            isLoggedIn = true
        } catch {
            self.password = ""
            showAlert = true
            alertMessage = "Email or password not correct"
            print(error.localizedDescription)
        }
    }
    
    func createUser() async {
        guard !registerName.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty else {
            alertMessage = "Name is required"
            showAlert = true
            return
        }
        
        guard !registerEmail.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty else {
            alertMessage = "Email is required"
            showAlert = true
            return
        }
        
        guard !registerPassword.isEmpty else {
            alertMessage = "Password is required"
            showAlert = true
            return
        }
        
        let user = UserModel(name: registerName, email: registerEmail, password: registerPassword)
        
        do {
            try await interactor.createUser(user: user)
        } catch {
            showAlert = true
            alertMessage = "Error creating the user. The email already exists"
            print(error.localizedDescription)
        }
    }
}

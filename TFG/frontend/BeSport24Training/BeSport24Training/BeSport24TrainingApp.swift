//
//  BeSport24TrainingApp.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 28/4/25.
//

import SwiftUI

@main
struct BeSport24TrainingApp: App {
    
    @AppStorage("isLoggedIn") var isLoggedIn = false
    
    var body: some Scene {
        WindowGroup {
            if isLoggedIn {
                ContentView()
            } else {
                LoginView()
            }
        }
    }
}

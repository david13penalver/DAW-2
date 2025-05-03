//
//  ApplicationView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 3/5/25.
//

import SwiftUI

struct ApplicationView: View {
    
    @StateObject var vm = LoginViewModel()
    
    var body: some View {
        List {
            Section("Application") {
                HStack {
                    Text("Version")
                    Spacer()
                    Text("1.0")
                        .foregroundStyle(Color("GrayColor"))
                }
                
            }
            Section("Legal") {
                Text("Terms & Conditions")
                Text("Privacy Policy")
            }
            Section("Support") {
                HStack {
                    Text("Contact")
                    Spacer()
                    Link("info@besport24.com", destination: URL(string: "mailto:info@besport24.com")!)
                }

                HStack {
                    Text("Feedback")
                    Spacer()
                    Link("support@besport24.com", destination: URL(string: "mailto:support@besport24.com")!)
                }
                
                Button("Reset app") {
                    vm.isLoggedIn = false
                    vm.id = -1
                }
                .foregroundColor(.red)
            }
        }
    }
}

#Preview {
    ApplicationView()
}

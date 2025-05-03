//
//  SettingsView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct SettingsView: View {
    var body: some View {
        NavigationStack {
            List {
                NavigationLink("Profile") {
                    ProfileView()
                }
                Section("BeSport24") {
                    NavigationLink("BeSport24Training") {
                        ApplicationView()
                    }
                    NavigationLink("External Links") {
                        ExternalLinksView()
                    }
                }
            }
            .navigationTitle("Settings")
            
        }
    }
}

#Preview {
    SettingsView()
}

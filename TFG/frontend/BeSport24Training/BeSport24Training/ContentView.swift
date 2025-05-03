//
//  ContentView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 28/4/25.
//

import SwiftUI

struct ContentView: View {
    
    enum Tab {
      case settings, exercises, sessions, trainings
     }

    @State private var selectedTab: Tab = .trainings
    
    var body: some View {
        
        TabView(selection: $selectedTab) {
            SettingsView()
                .tabItem {
                    Label("Settings", systemImage: "gear")
                }
                .tag(Tab.settings)
            
            TrainingListView()
                .tabItem {
                    Label("Training", systemImage: "sportscourt")
                }
                .tag(Tab.trainings)
            
            ExerciseListView()
                .tabItem {
                    Label("Exercises", systemImage: "list.bullet")
                }
                .tag(Tab.exercises)
            
            SessionListView()
                .tabItem {
                    Label("Sessions", systemImage: "calendar")
                }
                .tag(Tab.sessions)
        }
    }
}

#Preview {
    ContentView()
}

//
//  SessionListView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct SessionListView: View {
    
    @StateObject var vm: SessionViewModel
    
    @State private var searchText = ""
    @State private var showingNewSessionView = false
    
    var filteredSessions: [SessionModel] {
        if searchText.isEmpty {
            return vm.sessions
        } else {
            return vm.sessions.filter { $0.name.localizedCaseInsensitiveContains(searchText) }
        }
    }
    
    var body: some View {
        NavigationStack {
            
            List(filteredSessions) { session in
                NavigationLink(destination: SessionDetailView(session: session, vm: SessionViewModel())) {
                    Text(session.name)
                }
            }
            .task {
                await vm.getAllSessions()
            }
            .navigationTitle("Sessions")
            .searchable(text: $searchText, prompt: "Search for name...")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        showingNewSessionView = true
                    }) {
                        Image(systemName: "plus")
                    }
                }
            }
            .fullScreenCover(isPresented: $showingNewSessionView) {
                NewSessionView(isPresented: $showingNewSessionView, vm: vm)
            }
            .refreshable {
                await vm.getAllSessions()
            }
        }
    }
}

#Preview {
    SessionListView(vm: SessionViewModel())
}

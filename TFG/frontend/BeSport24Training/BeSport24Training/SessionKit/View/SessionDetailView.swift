//
//  SessionDetailView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct SessionDetailView: View {
    
    @Environment(\.dismiss) var dismiss
    
    let session: SessionModel
    
    @StateObject var vm: SessionViewModel
    @State private var showingEditSessionView = false
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            List {
                Section("Session") {
                    Text(vm.session?.name ?? "No name available")
                    Text(vm.session?.description ?? "No description available")
                }
                
                Section("Exercises") {
                    if vm.exercises.isEmpty {
                        Text("There are not exercises in this session yet")
                    } else {
                        ForEach(vm.exercises) { exercise in
                            VStack {
                                Text(exercise.exercise.name)
                                    .font(.headline)
                                    .foregroundColor(Color("AccentColor"))
                                    .padding(.bottom, 12)
                                
                                HStack {
                                    Label("\(exercise.numSets)", systemImage: "list.number")
                                    Spacer()
                                    Label("\(exercise.numReps)", systemImage: "repeat")
                                    Spacer()
                                    Label("\(exercise.restSeconds) sec", systemImage: "timer")
                                }
                                .font(.caption)
                                .foregroundColor(Color("GrayColor"))
                            }
                        }
                    }
                }
                
                Button("Edit") {
                    showingEditSessionView = true
                }
                Button("Delete") {
                    Task {
                        await vm.deleteSession(id: vm.session!.id)
                        await vm.getAllSessions()
                        dismiss()
                    }
                }
                .tint(Color("RedColor"))
            }
        }
        .fullScreenCover(isPresented: $showingEditSessionView) {
            EditSessionView(isPresented: $showingEditSessionView, vm: vm)
        }
        .task {
            await vm.findSessionById(id: session.id)
            await vm.findExercisesBySessionId(id: session.id)
        }
        .padding()
        .navigationTitle(vm.session?.name ?? "Session without name")
    }
}

#Preview {
    SessionDetailView(session: SessionModel(id: 1, name: "Session 1", description: "Description", dateCreation: Date.now), vm: SessionViewModel())
}

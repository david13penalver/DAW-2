//
//  TrainingDetailView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct TrainingDetailView: View {
    
    @Environment(\.dismiss) var dismiss
    
    let training: TrainingModel
    
    private var formattedDate: String {
        guard let date = vm.training?.dateCreation else { return "No date available" }
        let formatter = DateFormatter()
        formatter.dateStyle = .medium
        formatter.timeStyle = .none
        return formatter.string(from: date)
    }
    
    @StateObject var vm: TrainingViewModel
    @State private var showingEditTrainingView = false
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            List {
                Section("Training Details") {
                    Label(vm.training?.name ?? "No name available", systemImage: "text.page")
                    Label("\(training.trainingDurationSeconds / 60)'", systemImage: "clock")
                    Label("\(formattedDate)", systemImage: "calendar")
                }
                
                Section("Session Details") {
                    Text(vm.training?.session?.name ?? "Name not available")
                    Text(vm.training?.session?.description ?? "Description not available")
                }
                
                Section("Exercises Details") {
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
                    showingEditTrainingView = true
                }
                Button("Delete") {
                    Task {
                        await vm.deleteTraining(id: vm.training!.id)
                        await vm.getAllTrainings()
                        dismiss()
                    }
                }
                .tint(Color("RedColor"))
            }
        }
        .fullScreenCover(isPresented: $showingEditTrainingView) {
            EditTrainingView(isPresented: $showingEditTrainingView, vm: vm)
        }
        .task {
            await vm.findTrainingById(id: training.id)
            await vm.findExercisesBySessionId(id: vm.training?.session?.id ?? 0)
        }
        .padding()
        .navigationTitle(vm.training?.name ?? "Session without name")
    }
}

#Preview {
    TrainingDetailView(training: TrainingModel(id: 1, trainingId: 1, name: "Hola", trainingDurationSeconds: 3600, dateCreation: Date.now, session: SessionModel(id: 1, name: "Session 1")), vm: TrainingViewModel())
}


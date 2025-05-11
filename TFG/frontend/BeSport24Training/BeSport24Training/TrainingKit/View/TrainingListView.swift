//
//  TrainingListView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct TrainingListView: View {
    
    @StateObject var vm: TrainingViewModel
    
    @State private var searchText = ""
    @State private var showingNewTrainingView = false
    
    var filteredTrainings: [TrainingModel] {
        if searchText.isEmpty {
            return vm.trainings
        } else {
            return vm.trainings.filter { $0.name.localizedCaseInsensitiveContains(searchText) }
        }
    }
    
    var body: some View {
        NavigationStack {
            
            List(filteredTrainings) { training in
                NavigationLink(destination: TrainingDetailView(training: training, vm: TrainingViewModel())) {
                    VStack(alignment: .leading, spacing: 4) {
                        Text(training.name)
                            .font(.subheadline)
                            .foregroundColor(Color("AccentColor"))
                        Spacer()
                        HStack(spacing: 6) {
                            Image(systemName: "clock")
                                .foregroundColor(.gray)
                            Text("Duration: \(training.trainingDurationSeconds / 60)'")
                                .font(.subheadline)
                                .foregroundColor(Color("GrayColor"))
                        }
                    }
                    .padding(.vertical, 8)
                }
            }
            .task {
                await vm.getAllTrainings()
            }
            .navigationTitle("Trainings")
            .searchable(text: $searchText, prompt: "Search for name...")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        showingNewTrainingView = true
                    }) {
                        Image(systemName: "plus")
                    }
                }
            }
            .fullScreenCover(isPresented: $showingNewTrainingView) {
                NewTrainingView(isPresented: $showingNewTrainingView, vm: vm)
            }
            .refreshable {
                await vm.getAllTrainings()
            }
        }
    }
}

#Preview {
    TrainingListView(vm: TrainingViewModel())
}

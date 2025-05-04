//
//  ExerciseListView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct ExerciseListView: View {
    
    @StateObject var vm: ExerciseViewModel
    
    @State private var searchText = ""
    @State private var showingNewExerciseView = false
    
    var filteredExercises: [ExerciseModel] {
        if searchText.isEmpty {
            return vm.exercises
        } else {
            return vm.exercises.filter { $0.name.localizedCaseInsensitiveContains(searchText) }
        }
    }
    
    var body: some View {
        NavigationStack {
            
            List(filteredExercises) { exercise in
                NavigationLink(destination: ExerciseDetailView(exercise: exercise, vm: ExerciseViewModel())) {
                    Text(exercise.name)
                }
            }
            .task {
                await vm.getAllExercises()
            }
            .navigationTitle("Exercises")
            .searchable(text: $searchText, prompt: "Search for name...")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        showingNewExerciseView = true
                    }) {
                        Image(systemName: "plus")
                    }
                }
            }
            .fullScreenCover(isPresented: $showingNewExerciseView) {
                NewExerciseView(isPresented: $showingNewExerciseView, vm: vm)
            }
            .refreshable {
                await vm.getAllExercises()
            }
        }
    }
}

#Preview {
    ExerciseListView(vm: ExerciseViewModel())
}

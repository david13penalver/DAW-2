//
//  ExerciseListView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct ExerciseListView: View {
    
    @StateObject var vm: ExerciseViewModel
    
    var body: some View {
        List(vm.exercises) { exercise in
            Text(exercise.name)
        }
        .task {
            await vm.getAllExercises()
        }
    }
}

#Preview {
    ExerciseListView(vm: ExerciseViewModel())
}

//
//  ExerciseDetailView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct ExerciseDetailView: View {
    
    let exercise: ExerciseModel
    
    @StateObject var vm: ExerciseViewModel
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            List {
                
                if let videoURL = vm.exercise?.videoURL,
                   let videoID = videoURL.components(separatedBy: "v=").last {
                    YouTubeView(videoID: videoID)
                        .frame(height: 200)
                }
                
                Text("Exercise type: \(vm.exercise?.typeName.lowercased() ?? "resistance")")
                Text("Muscle group: \(vm.exercise?.subtypeName.lowercased() ?? "leg")")
                
                Group {
                    if let parsed = vm.exercise?.parsedDescription {
                        Section("Description") {
                            Text(parsed.what_is)
                        }
                        
                        Section("Muscles Involved") {
                            Text(parsed.muscles_involved)
                        }
                        
                        Section("Steps") {
                            ForEach(parsed.steps, id: \.self) { step in
                                Text("• \(step)")
                            }
                        }
                    } else {
                        Section("Description") {
                            Text(vm.exercise?.description ?? "No description available")
                        }
                    }
                }
            }
        }
        .task {
            await vm.findExerciseById(id: exercise.exerciseId)
        }
        .padding()
        .navigationTitle(exercise.name)
    }
}

#Preview {
    ExerciseDetailView(
        exercise: ExerciseModel(
            exerciseId: 1,
            name: "Squat",
            imageURL: "https://example.com/image.jpg",
            videoURL: "https://www.youtube.com/watch?v=3uEbkUmS29A",
            isGlobal: true,
            description: "Description",
            typeName: "Resistance",
            subtypeName: "Leg"
        ), vm: ExerciseViewModel()
    )
}

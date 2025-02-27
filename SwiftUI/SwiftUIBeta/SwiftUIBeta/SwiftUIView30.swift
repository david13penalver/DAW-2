//
//  SwiftUIView30.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView30: View { // SwiftUI 30 - @ObservedObject Vs @StateObject
    
    @State private var counter: Int = 0 // Con @State, cada vez que damos al botón, se redibuja la vista, por lo que carga el ListVideos() original con solo 3 ítems (no se ejecuta el método de añadir). Para evitarlo, el @Published que pusimos tiene que ser un @StateObject
    
    var body: some View {
        
        VStack{
            Text("Contador: \(counter)")
                .bold()
                .font(.largeTitle)
                .padding()
            Button("Incrementar contador") {
                counter += 1
            }
            ListVideos()
            Spacer()
        }
    }
}

struct ListVideos: View {
    
    @StateObject private var videoViewModel = VideoViewModel() // Para la propiedad que tiene @Published
    // @ObservedObject: si lo pasamos a una subvista o a otra subvista de la app (dentro de esa vista)
    // @StateObject: para la primera vez utilizamos el @Published
    
    var body: some View {
        
        NavigationView{
            List(videoViewModel.videosModel, id: \.self) { video in
                Text(video)
            }
            .navigationBarTitle("Videos")
            .navigationBarItems(leading:
                                    Button("Añadir") {videoViewModel.addMoreTopics()})
        }
    }
    
    
}

final class VideoViewModel: ObservableObject {
    @Published var videosModel: [String] = [] // @Published es como @State, solo que en vez de en un Struct se usa en una clase y cualquier cambio que se produzca en esta propiedad se podrá controlar en las vistas en las que tengamos una instancia de VideoViewModel.
    
    init() {
        videosModel = ["Video 1", "Video 2", "Video 3"]
    }
    
    func addMoreTopics() {
        videosModel.append("Video 4")
        videosModel.append("Video 5")
    }
    
    
    
}

#Preview {
    SwiftUIView30()
}

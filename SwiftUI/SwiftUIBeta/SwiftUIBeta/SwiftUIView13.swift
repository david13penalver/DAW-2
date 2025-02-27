//
//  SwiftUIView13.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView13: View { // SwiftUI 13 - Progressview
    
    @State var isLoading: Bool = false
    @State var progress: Float = 0.0
    
    var body: some View {
        
        VStack {
            if isLoading {
                ProgressView("Cargando")
                    .scaleEffect(2)
            }
            Button("Cargar") {
                isLoading = !isLoading
            }.padding(.top, 40)
        }
        
        VStack {
            ProgressView(value: progress)
                .padding()
            Button("Avanzar") {
                progress += 0.1
            }
        }
    }
}

#Preview {
    SwiftUIView13()
}

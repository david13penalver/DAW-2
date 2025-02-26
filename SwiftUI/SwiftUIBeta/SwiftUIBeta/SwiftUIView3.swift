//
//  SwiftUIView3.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView3: View { // SwiftUI 3: Imágenes
    var body: some View {
        Image("youtube")
            .renderingMode(.template)
            .resizable()
            .scaledToFit() // Ponemos este y el anterior antes de .frame para que ocupe el .frame
            .border(Color.black)
            .frame(width: 96, height: 68) // Modifica el contenedor, no la imagen
            .border(Color.blue)
            .foregroundColor(.green)
        
        Image("youtube") // Para tener un patrón de la imagen
            .resizable(resizingMode: .tile)
    }
}

#Preview {
    SwiftUIView3()
}

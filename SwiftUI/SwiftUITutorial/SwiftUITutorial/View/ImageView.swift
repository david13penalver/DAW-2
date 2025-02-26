//
//  ImageSwiftUIView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI

struct ImageView: View {
    var body: some View {
        VStack {
            Image("deivision")
                .resizable() // Si no, ocupa el original de la imagen y se puede salir
            // escalable a lo alto .scaledToFill()
            // escalable a lo ancho .scaledToFit()
                .padding(50)
                .frame(width: 284, height: 380, alignment: .center) // escalado personalizado
                .background(Color.gray) // si queremos que se aplique solo al círculo que se pone después
                .clipShape(Circle())
            // .background(Color.gray) // se aplica a toda la imagn, no a la que queda del círculo
                .overlay(Circle().stroke(Color.blue, lineWidth: 4)) // Aplica un borde que sea circular, azul y con un ancho de 4
                .shadow(color: Color.gray, radius: 5) // añade sombreado
            
            Image(systemName: "pencil.slash")
                .resizable()
                .foregroundColor(Color.blue)
                .frame(width: 100, height: 100)
                .clipShape(Circle())
                .overlay(Circle().stroke(Color.blue, lineWidth: 10))
                .shadow(color: Color.red, radius: 5)
        }
    }
}

#Preview {
    ImageView()
}

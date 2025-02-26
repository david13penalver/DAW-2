//
//  StateView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

// Tipo por valor

// Se usa en la vista propietaria de la variable

// Las vistas de Swift UI, al ser estructuras, son inmutables. Por eso, para cambiar valores, no podemos hacer que al clicar el botón haga un value += 1. Tenemos que jugar con los Property Wrappers

struct StateView: View {
    
    @State private var value = 0 // Nos permite que el botón pueda cambiar su valor. Si no lo ponemos, da error por lo de ser una estructura. Repinta todo para que se vea el nuevo valor
    
    // Lo usamos cuando tengamos una propiedad que vaya a modificar su valor
    
    // Será de tipo @State en la vista que se va a encargar de definirlo/instanciarlo/inicializarllo
    
    var body: some View {
        VStack{
            Text("El valor actual es \(value)")
            Button("Suma 1") {
                value += 1
            }
        }
    }
}

#Preview {
    StateView()
}

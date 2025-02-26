//
//  BindingView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

// Tipo por valor

// Se usa en la vista que RECIBE el envío de la variable

struct BindingView: View {
    
    @Binding var valueBinding: Int // Decimos @Binding para referirnos a que viene de otra vista. No hay que inicializarla porque se inicializa en otra vista. Solo tenemos que darle el tipo de dato. Le quitamos "private" para que sea accesible
    
    var body: some View {
        VStack{
            // Text("El valor actual es \(value)") Lo eliminamos porque en esta vista solo queremos modificar el valor que nos viene de la anterior
            Text("El valor actual es \(valueBinding)")
            Button("Suma 2") {
                valueBinding += 2
            }
            Button("Reiniciar") {
                valueBinding = 0
            }
        }
    }
}

#Preview {
    BindingView(valueBinding: .constant(5)) // Si no ponemos el constant, da error porque necesita que le pasemos un valor. Le ponemos el 5 por ejemplo
}

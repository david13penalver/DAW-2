//
//  StateView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

// Tipo por referencia

// Se usa en la vista propietaria de la variable compleja

// Almacena y propaga la referencia de un objeto

class UserData:ObservableObject {
    
    @Published var name = "David"
    @Published var age = 28
}

struct StateViewParaStateObject: View {
    
    @State private var value = 0
    @State private var selection: Int?
    @StateObject private var user = UserData()
        
    var body: some View {
        
        NavigationView() {
            
            VStack{
                Text("El valor actual es \(value)")
                Button("Suma 1") {
                    value += 1
                }
                NavigationLink(destination: BindingViewParaStateObject(valueBinding: $value, user: user), tag: 1, selection: $selection) {
                    Button("Ir a Binding View") {
                        selection = 1
                    }
                }
                Text("Mi nombre es \(user.name) y mi edad es \(user.age)")
                Button("Actualizar datos") {
                    user.name = "David Peñalver"
                    user.age = 29
                }
                // Está deprecated, aunque todavía funciona desde iOS 16.
                Button("Reiniciar") {
                    value = 0
                }
            }.navigationTitle("StateView")
        }
        
    }
}

#Preview {
    StateViewParaStateObject()
}

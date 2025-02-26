//
//  StateView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

struct StateViewParaBinding: View {
    
    @State private var value = 0
    @State private var selection: Int?
    
    var body: some View {
        
        NavigationView() {
            
            VStack{
                Text("El valor actual es \(value)")
                Button("Suma 1") {
                    value += 1
                }
                NavigationLink(destination: BindingView(valueBinding: $value), tag: 1, selection: $selection) {
                    Button("Ir a Binding View") {
                        selection = 1
                    }
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
    StateViewParaBinding()
}

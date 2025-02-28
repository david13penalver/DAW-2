//
//  SwiftUIView37.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct NewButtonModifier: ViewModifier { // Es un struct que permite crear nuestro propio modificador (como una CSS class)
    func body(content: Content) -> some View {
        Button(action: {
            print("Hello, World!")
        }) {
            content
                .font(.body)
                .foregroundColor(.white)
                .padding()
                .background(Color.blue)
                .cornerRadius(20)
        }
    }
}

extension View { // Permite ahorrarnos el .modifier(NewButtonModifier())
    func NewButtonModifier() -> some View {
        self.modifier(NewButtonModifier())
    }
}

struct SwiftUIView37: View { // SwiftUI 37 - ViewModifier
    
    var body: some View {
        
        VStack{
            Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            
            Button("Botón bonito") {
                print("Hola")
            }
            //.modifier(.newButtonModifier()) // Hay que usarlo si no usamos la Extension View
            .NewButtonModifier()
        }
        
    }
}

#Preview {
    SwiftUIView37()
}

//
//  ContentView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("¡Hola, mundo!")
                .font(.largeTitle)
                .foregroundColor(Color.blue)
        }
        .padding()
        VStack(alignment: .leading, spacing: 20) {
            Text("¡Hola, para Stack!")
                .font(.largeTitle)
                .foregroundColor(Color.blue)
                .padding()
            Spacer()
            
            HStack {
                Text("Segundo texto")
                    .padding()
                    .background(Color.yellow)
                Spacer()
                Text("Tercer texto")
            }
            
            ZStack {
                Text("Texto que está detrás")
                    .padding()
                    .background(Color.yellow)
                Spacer()
                Text("Delante")
            }
            
            ZStack{
                Text("")
                    .frame(
                        maxWidth: .infinity,
                        maxHeight: .infinity
                    )
                    .background(Color.gray)
                    .padding()
                
                Text("")
                    .frame(
                        maxWidth: .infinity,
                        maxHeight: .infinity
                    )
                    .background(Color.green)
                    .padding(40)
                
                Text("")
                    .frame(
                        maxWidth: .infinity,
                        maxHeight: .infinity
                    )
                    .background(Color.orange)
                    .padding(60)
                
                Text("")
                    .frame(
                        maxWidth: .infinity,
                        maxHeight: .infinity
                    )
                    .background(Color.red)
                    .padding(80)
            }
            
            // Máximo 10 elementos por Stack
            // Se puede meter un Stack como décimo elemento que contenga más elementos dentro para tener más de 10 elementos (y así sucesivamente)
            
        }
    }
}

#Preview {
    ContentView()
}

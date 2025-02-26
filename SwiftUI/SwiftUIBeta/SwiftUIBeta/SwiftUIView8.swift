//
//  SwiftUIView8.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView8: View { // SwiftUI 8: Button
    var body: some View {
        
        Button("Suscríbete") {
            print("Hola")
        }
        .font(.largeTitle)
        .textCase(.uppercase)
        .bold()
        .foregroundColor(.white)
        .padding()
        .background(Color.red)
        .cornerRadius(10)
        .shadow(color: .gray, radius: 10, x: 1, y: 1)
        
        Spacer()
        
        Button(action: {
            print("Hola")
        }, label: {
            Text("Suscríbete a BeSport24")
                .font(.largeTitle)
                .textCase(.uppercase)
                .bold()
                .foregroundColor(.white)
                .padding()
                .background(Color.red)
                .cornerRadius(10)
                .shadow(color: .gray, radius: 10, x: 1, y: 1)
        })
        
        Spacer()
        
        Button(action: {
            print("Hola")
        }, label: {
            Circle()
                .fill(Color.green)
                .frame(width: 200, height: 100)
                .shadow(radius: 10)
                .overlay(
                    Image(systemName: "hand.thumbsup.fill")
                        .foregroundColor(.white)
                        .font(.system(size: 70, weight: .bold)) // Otra forma para cambiarle el tamaño
                )
        })
    }
}

#Preview {
    SwiftUIView8()
}

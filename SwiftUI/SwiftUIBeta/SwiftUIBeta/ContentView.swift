//
//  ContentView.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        
        ZStack {
            VStack(alignment: .leading, spacing: 8) {
                Text("Siguiendo")
                    .font(.largeTitle)
                    .bold()
                    .multilineTextAlignment(.leading)
                Text("CANALES RECOMENDADOS")
                    .font(.subheadline)
                    .foregroundColor(Color.gray)
                    .multilineTextAlignment(.leading)
                HStack{
                    Rectangle()
                        .foregroundColor(Color.blue)
                        .frame(width: 118, height: 68)
                    
                    VStack(alignment: .leading) {
                        HStack {
                            Circle()
                                .foregroundColor(Color.blue)
                                .frame(width: 20)
                            Text("username")
                                .bold()
                        }
                        Text("Streaming de programación...")
                            .foregroundColor(Color.gray)
                        Text("Solo Hablando")
                            .foregroundColor(Color.gray)
                    }
                }
            }
            Text("¡Suscribíos a BeSport24!")
                .font(.largeTitle)
                .bold()
                .foregroundColor(.red)
                .underline()
                .background(.black)
                .rotationEffect(.degrees(-20))
        }
    }
}

#Preview {
    ContentView()
}

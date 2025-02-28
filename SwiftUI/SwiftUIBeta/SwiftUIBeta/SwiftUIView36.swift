//
//  SwiftUIView36.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

let arrayOfNames = [
    "Suscríbete a BeSport24",
    "Aprende Fuerza",
    "Aprende Resistencia",
    "Aprende Salud",
    "Suscríbete al canal de YouTube",
    "Fuerza",
    "Resistencia",
    "Salud"
]

struct SwiftUIView36: View { // SwiftUI 36 - GeometryReader & GeometryProxy
    
    // GeometryReader: contenedor de vistas como el VStack, List, Form..., pero nos permite acceder al GeometryProxy
    
    // GeometryProxy: proporciona posición y tamaño para posicionar las subvistas con un layout customizado y para crear nuestras propias animaciones
    
    var body: some View {
        
        // El segundo GeometryReader es para entenderlo. El primero es X y el segundo es la vista customizada
        
        // ScrollView{
        
            ScrollView(showsIndicators: false) {
                VStack {
                    ForEach(arrayOfNames, id: \.self) {name in
                        GeometryReader{ proxy in
                            VStack {
                                Text("\(proxy.frame(in: .global).minY)")
                                Spacer()
                                Text(name)
                                    .frame(width: 370, height: 200)
                                    .background(Color.green)
                                    .cornerRadius(20)
                                Spacer()
                            }
                            .shadow(color: .gray, radius: 10, x: 0, y: 0)
                            .rotation3DEffect(Angle(degrees: Double(proxy.frame(in: .global).minY)),
                                              axis: (x: 0, y: 10, z: 0))
                        }
                        .frame(width: 370, height: 300)
                    }
                    .padding(.trailing)
                }
                .padding(.horizontal)
            }
        
            GeometryReader{ proxy in
                VStack(spacing: 0){
                    HStack(spacing: 0){
                        Rectangle()
                            .foregroundColor(.green)
                            .overlay(Text("1"))
                            .frame(width: proxy.size.width / 2, height: proxy.size.height / 2)
                        Rectangle()
                            .foregroundColor(.orange)
                            .overlay(Text("2"))
                            .frame(width: proxy.size.width / 2, height: proxy.size.height / 2)
                    }
                    Rectangle()
                        .foregroundColor(.purple)
                        .overlay(Text("3"))
                        .frame(width: proxy.size.width, height: proxy.size.height)
                }
            }
            
            GeometryReader { proxy in
                VStack{
                    Text("Width: \(proxy.size.width)")
                        .background(Color.orange)
                        .padding()
                    Text("Height: \(proxy.size.height)")
                        .background(Color.orange)
                        .padding()
                    Text("Coordinate Local: \(proxy.frame(in: .local).debugDescription)")
                        .background(Color.orange)
                        .padding()
                    Text("Coordinate Global: \(proxy.frame(in: .global).debugDescription)")
                        .background(Color.orange)
                        .padding()
                }
            }
            .background(Color.red)
            .frame(width: 300, height: 300)
        // }
    }
}

#Preview {
    SwiftUIView36()
}

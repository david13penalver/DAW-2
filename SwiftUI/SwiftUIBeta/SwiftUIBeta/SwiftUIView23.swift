//
//  SwiftUIView23.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView23: View { // SwiftUI 23 - FullScreen Cover & Sheet
    
    @State var isPresented: Bool = false
    @State var isPresented2: Bool = false
    
    var body: some View {
        
        VStack{
            Text("View 1")
                .padding()
            Button("Ok") {
                isPresented = true
            }
        }
        .fullScreenCover(isPresented: $isPresented, onDismiss: { // Ocupa toda la pantalla
            isPresented = false
        }, content: {
            ZStack{
                Color.red.ignoresSafeArea()
                Button("Bienvenido a BeSport24") {
                    isPresented = false
                }
            }
        })
        
        VStack{
            Text("View 2")
                .padding()
            Button("Ok") {
                isPresented2 = true
            }
        }
        .sheet(isPresented: $isPresented2, onDismiss: { // No ocupa toda la pantalla y se puede deslizar
            isPresented2 = false
        }, content: {
            ZStack{
                Color.red.ignoresSafeArea()
                Button("Bienvenido a BeSport24") {
                    isPresented2 = false
                }
            }
        })
    }
}

#Preview {
    SwiftUIView23()
}

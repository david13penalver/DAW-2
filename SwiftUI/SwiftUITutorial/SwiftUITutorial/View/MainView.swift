//
//  MainView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        
        ScrollView{ // Para poder hacer scroll porque la suma del VStack ocupa más del 100% de la pantalla. Es como si fuera un VStack por así decirlo
            VStack{
                MapView()
                    .frame(height: 400)
                ImageView()
                    .offset(y: -150)
                Divider()
                    .padding()
                ContentView()
            }
        }
    }
}

#Preview {
    MainView()
}

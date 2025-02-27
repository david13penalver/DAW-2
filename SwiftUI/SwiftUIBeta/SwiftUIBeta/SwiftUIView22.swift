//
//  SwiftUIView22.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView22: View { // SwiftUI 22 - Tabview
    
    var body: some View {
        
        TabView{ // Útil para un tutorial
            RoundedRectangle(cornerRadius: 20)
                .padding()
                .foregroundColor(.blue)
            RoundedRectangle(cornerRadius: 20)
                .padding()
                .foregroundColor(.red)
        }
        .frame(height: 400)
        .tabViewStyle(PageTabViewStyle())
        
        TabView{ // Menú inferior estándar
            HomeView()
                .tabItem{
                    Image(systemName: "house")
                    Text("Home")
                }
            SwiftUIView4()
                .tabItem{
                    Image(systemName: "house.fill")
                    Text("Home")
                }
            SwiftUIView6()
                .tabItem{
                    Image(systemName: "person.crop.circle.fill")
                    Text("Profile")
                }
        }
        .accentColor(.red)
        
        
        
    }
    
    
}

#Preview {
    SwiftUIView22()
}

struct HomeView: View {
    var body: some View {
        Text("Hello World")
            .bold()
            .font(.largeTitle)
            
    }
}

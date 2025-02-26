//
//  ContentView.swift
//  SwiftUIWebView
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct ContentView: View {
    
    @State private var showWebView = false // Esto es para WKWebView. showWebView es un estado (@State) que controla si se debe mostrar la WebView
    @State private var showSafariWebView = false
    
    private let url = "https://github.com/david13penalver"
    
    var body: some View {
        
        VStack(spacing: 16) {
            Link(destination: URL(string: url)!) {
                Text("Visita mi web")
            } // Esta es la forma para entrar en una web externa mediante un Link. Para abrir un archivo local, se cambia el string de URL por filePath
            
            Button("Abrir WKWebKit") {
                showWebView = true
            }.sheet(isPresented: $showWebView) {
                WebView(url: url)
            }
            // El usuario toca Abrir VKWebKit, lo que cambia el estado de la variable a True
            // Se activa el .sheet
            // Dentro del .sheet, se crea WebView(url: url), cargando la URL dentro de la app
            
            Button("Abrir SFSafariViewController") {
                showSafariWebView = true
            }.sheet(isPresented: $showSafariWebView) {
                SafariWebView(url: url)
            }
        }
    }
}

#Preview {
    ContentView()
}

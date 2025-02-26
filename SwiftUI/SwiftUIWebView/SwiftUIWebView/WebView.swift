//
//  WebView.swift
//  SwiftUIWebView
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI
import WebKit // Si importo Foundation, puede ocasionar conflictos. Quitarlo si ocurre y no uso Foundation o, al usarlo, especificar cada uno (como el URL que sea WebKit.URL)

struct WebView: UIViewRepresentable { // WebView es una estructura que cumple con el protocolo UIViewRepresentable, lo que permite usar vistas de UIKit (WKWebView) dentro de SwiftUI
    
    let url: String
    
    func makeUIView(context: Context) -> WKWebView { // Este método crea y devuelve una instancia de WKWebView, que es la vista que renderiza páginas web
        return WKWebView()
    }
    
    func updateUIView(_ uiView: WKWebView, context: Context) {
        if let validURL = URL(string: url) { // Se verifica si la URL es válida
            let request = URLRequest(url: validURL) // Si la URL es válida, se crea una solicitud HTTP (URLRequest) y se carga en WKWebView
            uiView.load(request) // Este método se ejecuta cada vez que SwiftUI necesita actualizar la vista
        }
    }
}

//
//  SafariWebView.swift
//  SwiftUIWebView
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI
import SafariServices

struct SafariWebView: UIViewControllerRepresentable {
    let url: String  // Corregido: "url" en minúscula
    
    func makeUIViewController(context: Context) -> SFSafariViewController {
        guard let validURL = URL(string: url) else {
            fatalError("URL inválida: \(url)")
        }
        return SFSafariViewController(url: validURL) // Corregido: Se crea correctamente el URL
    }
    
    func updateUIViewController(_ uiViewController: SFSafariViewController, context: Context) {
        // No es necesario actualizar nada aquí
    }
}

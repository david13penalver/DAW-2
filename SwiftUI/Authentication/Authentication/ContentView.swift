//
//  ContentView.swift
//  Authentication
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI
import LocalAuthentication

struct ContentView: View {
    
    @State private var auth = false // La variable que comprobará que estamos o no autentificados. Inicializada en False porque el usuario no está identificado por defecto (lógicamente)
    
    var body: some View {
        
        VStack {
            Text(auth ? "Autenticado" : "Necesitas autenticarte")
                .font(.title)
                .bold()
            
            Button(auth ? "Cerrar" : "Autenticar") { // Nos desautentifica si lo estamos y, si no, lanza el método para autentificarnos
                
                if auth {
                    auth = false
                } else {
                    authentication()
                }
                
            }.buttonStyle(.borderedProminent)
                .buttonBorderShape(.roundedRectangle)
                .accentColor(.black)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(auth ? Color.green : Color.red)
    }
    
    private func authentication() {
        
        var error: NSError? // Necesario porque usa Objective-C. No está migrado a SwiftUI. Las funciones de LocalAuthentication vienen de Objective-C y requieren manejar errores de esta manera
        
        if auth == false {
            let laContext = LAContext() // Se crea una instancia de LAContext, que maneja la autenticación biométrica en iOS
            if laContext.canEvaluatePolicy(.deviceOwnerAuthenticationWithBiometrics , error: &error) { // Comprueba si el dispositivo admite Face ID o Touch ID. Si no es compatible, no pedirá autenticación.
                
                laContext.evaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, localizedReason: "Autentícate usando un sensor biométrico") {autenticated, error in // Muestra el diálogo de Face ID o Touch ID con el mensaje "Autentícate usando un sensor biométrico"
                    
                    if autenticated {
                        auth = true
                    }
                }
            } else {
                auth = true
            }
        }
    }
}

#Preview {
    ContentView()
}

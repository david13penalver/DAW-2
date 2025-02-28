//
//  SwiftUIView32.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct SwiftUIView32: View { // SwiftUI 32 - AppStorage
    
    // Usa por debajo UserDefaults para almacenar información en una base de datos
    
    @State var name: String = ""
    @AppStorage("appStorageName") var appStorageName: String = "" // Hay que darle un nombre (lo del paréntesis) para poder identificar este valor de cara a poder acceder desde otra parte de la aplicación
    
    var body: some View {
        
        Form {
            TextField("Username", text: $name)
            Button("Guardar") {
                appStorageName = name
            }
            .onAppear(){ // Para cargar la información previamente guardada
                name = appStorageName
            }
            
            
            Spacer()
            Button("Imprimir valor") {
                print(UserDefaults.standard.string(forKey: "appStorageName")) // Accediendo al valor
            }
        }
    }
}

#Preview {
    SwiftUIView32()
}

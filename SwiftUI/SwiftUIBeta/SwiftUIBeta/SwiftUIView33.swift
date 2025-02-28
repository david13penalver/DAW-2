//
//  SwiftUIView33.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct SwiftUIView33: View { // SwiftUI 33  SceneStorage
    
    // Guarda el estado de nuestras pantallas. Por debajo usa otro sistema al que nosotros no podemos acceder, por lo que no podemos acceder a otras escenas
    
    // Para comprobar que funciona, en el simulador hay que ir a Home, parar el simulador y volver a lanzarlo.
    
    @SceneStorage("tuit") private var tuit:String = ""
    @SceneStorage("toggle") private var togglePubblishBestHour: Bool = false
    
    var body: some View {
        
        Form{
            TextField("Tuit", text: $tuit)
                .frame(height: 300)
            Toggle("Publicar a la mejor hora", isOn: $togglePubblishBestHour)
            HStack{
                Spacer()
                Button(togglePubblishBestHour ? "Publicar a la mejor hora" : "Publicar ya") {
                    print("Publicando...")
                }
                Spacer()
            }
        }
    }
}

#Preview {
    SwiftUIView33()
}

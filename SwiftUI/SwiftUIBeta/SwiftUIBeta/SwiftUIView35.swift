//
//  SwiftUIView35.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct Device2 {
    let name: String
    let systemImage: String
}

let arrayOfDevices = [
    Device2(name: "iPhone", systemImage: "iphone"),
    Device2(name: "iPad", systemImage: "ipad"),
    Device2(name: "PC", systemImage: "pc"),
    Device2(name: "4K", systemImage: "4k.tv"),
    Device2(name: "iPod", systemImage: "ipod"),
    Device2(name: "Laptop", systemImage: "laptopcomputer"),
]

struct SwiftUIView35: View { // SwiftUI 35 - SwipeActions y Refreshable
    
    // SwipeActions nos permite hacer acciones en una List deslizando a derecha o izquierda
    // Refreshable es cuando deslizamos hacia abajo para refrescar la página
    
    var body: some View {
        
        NavigationView{
            List{
                ForEach(arrayOfDevices, id: \.name) { device in
                    Label(device.name, systemImage: device.systemImage)
                        .swipeActions(content: {
                            Button{
                                print("Favorite")
                            } label: {
                                Label("Favorite", systemImage: "star.fill")
                            }
                            .tint(.yellow)
                            Button{
                                print("Compartir")
                            } label: {
                                Label("Compartir", systemImage: "square.and.arrow.up")
                            }
                            .tint(.blue)
                        })
                    
                        .swipeActions(edge: .leading, content: {
                            Button{
                                print("Borrar")
                            } label: {
                                Label("Borrar", systemImage: "trash.fill")
                            }
                            .tint(.red)
                        })
                }
            }
        }
        .navigationTitle("Device List")
        .refreshable(action: {
            print("Recargar información")
        })
    }
}

#Preview {
    SwiftUIView35()
}

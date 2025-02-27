//
//  SwiftUIView26.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView26: View { // SwiftUI 26 - ContextMenu
    
    var body: some View {
        
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            .padding()
            .contextMenu(menuItems: { // Es el que se abre al hacer pulsación larga (antiguo Force Touch)
                Button("1") {
                    print("Botón 1")}
                Button("2") {
                    print("Botón 1")}
                Button(action: {print("Botón 3")},
                       label: {
                    Label("Botón 3", systemImage: "iphone")
                }
            )})
    }
}

#Preview {
    SwiftUIView26()
}

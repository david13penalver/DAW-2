//
//  SwiftUIView24.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView24: View { // SwiftUI 24 - Alert
    
    @State var isPresented:Bool = false
    
    var body: some View {
        
        VStack {
            Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            Button("Aceptar") {
                isPresented = true
            }
        }
        .alert(isPresented: $isPresented, content: {
            Alert(title: Text("Texto jaja"),
                  message: Text("Texto con más información"),
                  primaryButton: Alert.Button.default(Text("Aceptar"), action: {
                        print("Aceptado")
                    }),
                  secondaryButton: Alert.Button.destructive(Text("Cancelar")))
        })
        
    }
}

#Preview {
    SwiftUIView24()
}

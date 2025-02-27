//
//  SwiftUIView25.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView25: View { // SwiftUI 25 - ActionSheet
    
    @State var isPresented:Bool = false
    
    var body: some View {
        
        VStack {
            Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
                .padding()
            Button("Aceptar") {
                isPresented = true
            }
        }
        .actionSheet(isPresented: $isPresented, content: {
            ActionSheet(title: Text("Aprendiendo SwiftUI"),
                        message: Text("Elige opción"),
                        buttons: [ActionSheet.Button.default(Text("Hola"), action: {
                                                                                print("Acción")
                                                                            }),
                                  ActionSheet.Button.default(Text("Hola2"), action: {
                                                                                          print("Acción2")
                                                                                      }),
                                  ActionSheet.Button.destructive(Text("Adiós")),
                                  ActionSheet.Button.cancel(Text("Cancel"))])
        })
    }
}

#Preview {
    SwiftUIView25()
}

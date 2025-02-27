//
//  SwiftUIView29.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView29: View { // SwiftUI 29 - @State Vs @Binding
    
    @State var counterState: Int = 0 // Cuando es una variable de la propia vista
    
    var body: some View {
        
        SwiftUIView29Binding(counter: $counterState)
    }
}

struct SwiftUIView29Binding: View {
    
    @Binding var counter: Int // Cuando es una variable de otra vista. Aunque ponga Binding en los diferentes métodos, la diferencia entre poner un @State o @Binding es solamente esa
    
    var body: some View {
        
        VStack {
            Text("\(counter)")
            Button("Incrementar") {
                counter += 1
            }
        }
    }
    
}

#Preview {
    SwiftUIView29()
}

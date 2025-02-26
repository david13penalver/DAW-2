//
//  SwiftUIView5.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView5: View { // SwiftUI 5: State
    
    @State private var counter = 0
    
    var body: some View {
        Text("Valor del contador: \(counter)")
        Button("Sumar 1") {
            counter += 1
        }
        Button("Reiniciar") {
            counter = 0
        }
    }
}

#Preview {
    SwiftUIView5()
}

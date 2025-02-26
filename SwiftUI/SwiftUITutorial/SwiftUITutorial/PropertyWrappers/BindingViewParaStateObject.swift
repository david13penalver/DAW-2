//
//  BindingView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

// @ObservedObject: tipo por referencia
// Se usa en la vista que recibe el envío de la variable

struct BindingViewParaStateObject: View {
    
    @Binding var valueBinding: Int
    @ObservedObject var user: UserData
    
    var body: some View {
        VStack{
            Text("El valor actual es \(valueBinding)")
            Button("Actualizar datos") {
                user.name = "David"
                user.age = 28
            }
        }
    }
}

#Preview {
    struct PreviewWrapper: View {
        @State private var previewValue = 0
        @StateObject private var previewUser = UserData()
        
        var body: some View {
            BindingViewParaStateObject(valueBinding: $previewValue, user: previewUser)
        }
    }
    return PreviewWrapper()
}

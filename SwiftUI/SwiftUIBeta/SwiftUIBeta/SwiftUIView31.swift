//
//  SwiftUIView31.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

final class ViewModel: ObservableObject {
    @Published var counter: Int = 0
}

struct SwiftUIView31: View { // SwiftUI 31 - EnvironmentObject
    
    // Lo usamos para proporcionar desde una vista padre una clase que podrá ser usada en toda su jerarquía de vistas
    
    // Está en la carpeta SwfitUIView31. No hacer caso a lo de abajo. Lo útil es la class ViewModel que coge View1 y se va propagando
    
    @StateObject var viewModel = ViewModel()
    
    var body: some View {
        
        VStack{
            Text("Counter: \(viewModel.counter)")
                .bold()
                .font(.largeTitle)
            Text("View 1")
                .padding()
        }
    }
}

#Preview {
    SwiftUIView31()
}

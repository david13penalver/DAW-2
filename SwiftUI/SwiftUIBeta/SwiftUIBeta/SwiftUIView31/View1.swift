//
//  View1.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct View1: View {
    @StateObject var viewModel = ViewModel()
    
    var body: some View {
        
        VStack{
            Text("Counter: \(viewModel.counter)")
                .bold()
                .font(.largeTitle)
            Text("View 1")
                .padding()
            View2()
        }
        .environmentObject(viewModel) // Si no lo inyectamos, crashea la aplicación
    }
}

#Preview {
    View1()
}

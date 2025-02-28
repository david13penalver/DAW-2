//
//  View3.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct View3: View {
    
    @EnvironmentObject var viewModel: ViewModel
    
    var body: some View {
        
        Text("View 3")
            .padding()
        Button("Incrementar") {
            viewModel.counter += 1
        }
    }
}

#Preview {
    View3()
}

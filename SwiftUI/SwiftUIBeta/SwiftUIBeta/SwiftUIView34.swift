//
//  SwiftUIView34.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI

struct SwiftUIView34: View { // SwiftUI 34 - AsyncImage
    
    // Para poner imágenes con la URL. A partir de iOS 15
    
    private let url = URL(string: "https://placebear.com/1000/1000")
    
    var body: some View {
        
        AsyncImage(url: url!, content: { image in
            image
                .resizable()
                .scaledToFit()
                .cornerRadius(20)
                .padding()
        }, placeholder: {
            ProgressView()
        })
    }
}

#Preview {
    SwiftUIView34()
}

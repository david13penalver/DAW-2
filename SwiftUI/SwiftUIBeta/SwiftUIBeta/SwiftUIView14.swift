//
//  SwiftUIView14.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView14: View { // SwiftUI 14 - Link
    
    private let title = "Hola"
    
    var body: some View {
        Link(title, destination: URL(string: "https://twitter.com")!)
        
        Link(destination: URL(string: UIApplication.openSettingsURLString)!, label: {
            Label("Settings", systemImage: "gear")
                .font(.headline)
        })
    }
}

#Preview {
    SwiftUIView14()
}

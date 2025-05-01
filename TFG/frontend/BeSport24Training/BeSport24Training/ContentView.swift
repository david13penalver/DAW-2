//
//  ContentView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 28/4/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
                .fontWeight(.bold)
        }
        .padding()
        
//        #if DESA
//        Text("DESA")
//        #if PROD
//        Text("PROD")
//        #endif
    }
}

#Preview {
    ContentView()
}

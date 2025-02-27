//
//  SwiftUIView10.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView10: View { // SwiftUI 10 - Text Editor
    
    @State var text: String = "Escribe algo..."
    @State var counter = 0
    
    var body: some View {
        
        VStack {
            TextEditor(text: $text)
                .font(.title)
                .autocapitalization(.none)
                .autocorrectionDisabled()
                .foregroundColor(.blue)
                .padding()
                .onChange(of: text, perform: {value in
                    counter = value.count
                })
            
            Text("\(counter)")
                .foregroundColor(counter <= 280 ? .green : .red)
                .font(.largeTitle)
        }
    }
}

#Preview {
    SwiftUIView10()
}

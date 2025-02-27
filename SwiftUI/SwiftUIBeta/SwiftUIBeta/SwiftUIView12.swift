//
//  SwiftUIView12.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView12: View { // SwiftUI 12 - Colorpicker
    
    @State var color: Color = .blue
    
    var body: some View {
        
        VStack {
            ColorPicker("Selecciona un color", selection: $color)
            
            Spacer()
            
            Rectangle().foregroundColor(color)
                .frame(width: 300, height: 300)
        }.padding(60)
    
    }
}

#Preview {
    SwiftUIView12()
}

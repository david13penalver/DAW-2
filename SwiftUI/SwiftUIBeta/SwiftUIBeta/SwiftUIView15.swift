//
//  SwiftUIView15.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView15: View { // SwiftUI 15 - Toggle
    
    @State var toggle: Bool = false
    
    var body: some View {
        
        Form{
            Toggle("Tócale", isOn: $toggle)
            Text(toggle.description)
        }
    }
}

#Preview {
    SwiftUIView15()
}

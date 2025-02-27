//
//  SwiftUIView17.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView17: View { // SwiftUI 17 - Slider
    
    @State var iPhoneCounter: Float = 0.0
    @State var isEditing: Bool = false
    
    var body: some View {
        
        Form {
            Slider(value: $iPhoneCounter,
                   in: 0...10,
                   step: 1,
                   onEditingChanged: { editing in
                        isEditing = editing
                    },
                   minimumValueLabel: Text("Min"),
                   maximumValueLabel: Text("Max"),
                   label: {Text("Label")})
            Text("\(iPhoneCounter)")
        }
    }
}

#Preview {
    SwiftUIView17()
}

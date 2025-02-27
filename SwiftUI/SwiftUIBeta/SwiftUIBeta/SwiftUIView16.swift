//
//  SwiftUIView16.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView16: View { // SwfitUI 16 - Stepper
    
    @State var iPhoneCount: Int = 1
    var body: some View {
        
        Form {
            Stepper("iPhone: \(iPhoneCount)",
                    value: $iPhoneCount,
                    in: 1...5,
                    step: 2)
            Stepper("iPhone: \(iPhoneCount)", onIncrement: {
                iPhoneCount += 1
                print(iPhoneCount)
            }, onDecrement: {
                iPhoneCount -= 1
                print(iPhoneCount)
            })
        }
    }
}

#Preview {
    SwiftUIView16()
}

//
//  SwiftUIView4.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView4: View { // SwiftUI 4: Iconos
    var body: some View {
        Image(systemName: "moon.circle.fill")
            .renderingMode(.original)
            .resizable()
            .scaledToFit()
            .frame(width: 200)
    }
}

#Preview {
    SwiftUIView4()
}

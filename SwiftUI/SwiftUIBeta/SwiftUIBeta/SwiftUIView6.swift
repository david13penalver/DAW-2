//
//  SwiftUIView6.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView6: View { // SwiftUI 6: Label
    var body: some View {
        
        Label("Suscríbete", systemImage: "person.2.badge.plus.fill")
            .font(.largeTitle)
            .labelStyle(IconOnlyLabelStyle()) // Para ver solo el icono o el texto (IconOnluLabelStytle())
    }
}

#Preview {
    SwiftUIView6()
}

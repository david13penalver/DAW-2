//
//  SwiftUIView27.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView27: View { // SwiftUI 27 - TapGesgure
    
    @State private var count: Int = 0
    
    var body: some View {
        
        VStack {
            RoundedRectangle(cornerRadius: 20)
                .frame(width: 100, height: 100)
            //.gesture(TapGesture(count: 2) // Número de taps para que se haga la acción
            //    .onEnded({
            //        count += 1
            //    }))
                .onTapGesture(count: 2) { // También se puede poner el count en el paréntesis
                    count += 1
                }
            Text("\(count)")
        }
        
        
    }
}

#Preview {
    SwiftUIView27()
}

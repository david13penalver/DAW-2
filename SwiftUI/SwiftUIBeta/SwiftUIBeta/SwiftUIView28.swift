//
//  SwiftUIView28.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView28: View { // SwiftUI 28 - DragGesture
    
    @State private var dragOffset: CGSize = .zero
    
    var body: some View {
        
        RoundedRectangle(cornerRadius: 20)
            .frame(width: 100, height: 100)
            .offset(x: dragOffset.width , y: dragOffset.height)
            .gesture(
                DragGesture()
                .onChanged({ value in
                    dragOffset = value.translation
                })
                .onEnded({ value in
                    withAnimation(.spring()) {
                        dragOffset = .zero
                    }
                }))
    }
}

#Preview {
    SwiftUIView28()
}

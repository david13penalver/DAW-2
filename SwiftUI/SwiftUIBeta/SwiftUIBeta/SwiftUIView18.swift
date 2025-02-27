//
//  SwiftUIView18.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView18: View { // SwiftUI 18 - LazyGrid (LazyVGrid y LazyHGrid)
    
    let elements = 1...500
    let gridElements = [GridItem(.fixed(100)), GridItem(.adaptive(minimum: 20)), GridItem(.fixed(100))]
    
    var body: some View {
        
        ScrollView(.horizontal){
            LazyHGrid(rows: gridElements, content: {
                ForEach(elements, id: \.self) { element in
                    VStack {
                        Circle()
                            .frame(width: 40)
                        Text("\(element)")
                    }
                }
            })
        }
        
        ScrollView{
            LazyVGrid(columns: gridElements, content: {
                ForEach(elements, id: \.self) { element in
                    VStack {
                        Circle()
                            .frame(width: 40)
                        Text("\(element)")
                    }
                }
            })
        }
    }
}

#Preview {
    SwiftUIView18()
}

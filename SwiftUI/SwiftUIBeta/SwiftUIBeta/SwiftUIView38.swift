//
//  SwiftUIView38.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 28/2/25.
//

import SwiftUI // ESTA NO ME FUNCIONA. Hecho hasta el 7:30

struct CustomTitleKey: PreferenceKey {
    static var defaultValue: String = ""
    
    static func reduce(value: inout String, nextValue: () -> String) {
        value = nextValue()
    }
}

struct CustomNavigationView<Content: View>: View {
    @State private var title: String = "Navigation View"
    let content: Content
    
    init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }
    
    var body: some View {
        VStack(alignment: .leading, content: {
            Text(title)
                .font(.largeTitle)
                .bold()
            GeometryReader{ proxy in
                ScrollView{
                    content
                }
            }
        })
    }
}

struct SwiftUIView38: View { // SwiftUI 38 - PreferenceKey
    
    // Sirve para pasar información a través de la jerarquía de vistas
    
    // EnvironmentObject permite que viaje a las siguientes vistas (de la 1 a la 3 por ejemplo).
    
    // Esta permite el sentido opuesto (de la 3 a la 1 por ejemplo)
    
    var body: some View {
        
        CustomNavigationView {
            VStack {
                Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
                    .navigationTitle("Text1")
                Text("Hello, World2!")
                    .navigationTitle("Text2")
            }
        }
        .navigationTitle("NavigationView")
    }
}

#Preview {
    SwiftUIView38()
}

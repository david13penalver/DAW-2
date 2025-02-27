//
//  SwiftUIView21.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView21: View {
    

    var body: some View {
        
        NavigationView{
            List{
                NavigationLink("Select 1", destination: {
                    Text("Option 1")
                })
                NavigationLink("Select 2", destination: {
                    SwiftUIView3()
                })
            }
            .navigationBarItems(trailing: Button("Done", action: {
                print("Navigation Button")
            }))
            .navigationTitle("Menu")
            .navigationBarTitleDisplayMode(.large)
            .navigationBarHidden(false)
        }
    }
}

#Preview {
    SwiftUIView21()
}

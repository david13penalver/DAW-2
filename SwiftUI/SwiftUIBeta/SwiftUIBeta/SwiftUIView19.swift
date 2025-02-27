//
//  SwiftUIView19.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView19: View { // SwiftUI 19 - Form
    @State var textField: String = "iPhone 11 Pro"
    @State var isNetworkOn: Bool = true
    @State var date: Date = Date()
    @State var color: Color = .blue
    
    var body: some View {
        
        Form {
            Section("Setting"){
                TextField("Device Name: ", text: $textField)
                Toggle(isOn: $isNetworkOn, label: {Text("Wi-Fi")})
            }
            Section(header: Text("Others"),
                    footer:
                        HStack{
                            Spacer()
                            Label("version 1.0", systemImage: "iphone")
                            Spacer()
                        }
            ){
                DatePicker("Date", selection: $date)
                ColorPicker("Color", selection: $color)
            }
        }
    }
}

#Preview {
    SwiftUIView19()
}

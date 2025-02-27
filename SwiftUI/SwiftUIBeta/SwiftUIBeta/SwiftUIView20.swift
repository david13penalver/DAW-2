//
//  SwiftUIView20.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct Device {
    let title: String
    let imageName: String
}

let house = [
    Device(title: "Macbook Air", imageName: "laptopcomputer"),
    Device(title: "Mac Mini", imageName: "macmini"),
    Device(title: "Mac Pro", imageName: "macpro.gen3"),
    Device(title: "Displays", imageName: "display.2"),
    Device(title: "Apple TV", imageName: "appletv")
]

let work = [
    Device(title: "iPhone", imageName: "iphone"),
    Device(title: "iPad", imageName: "ipad"),
    Device(title: "AirPods", imageName: "airpods"),
    Device(title: "Apple Watch Series 10", imageName: "applewatch")
]

struct SwiftUIView20: View { // SwiftUI 20 - List
    
    var body: some View {
        
        List{
            Section(header: Text("Home")) {
                ForEach(house, id: \.title) { device in
                    Label(device.title, systemImage: device.imageName)
                }
            }
            Section(header: Text("Work")) {
                ForEach(work, id: \.title) { device in
                    Label(device.title, systemImage: device.imageName)
                }
            }
        }
        .listStyle(SidebarListStyle())
    }
}

#Preview {
    SwiftUIView20()
}

//
//  ExternalLinksView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 3/5/25.
//

import SwiftUI

struct ExternalLinksView: View {
    var body: some View {
        List {
            Section("Social Networks") {
                Link(destination: URL(string: "https://www.youtube.com/@BeSport24")!) {
                    Label("YouTube", systemImage: "play.rectangle.fill")
                        .foregroundColor(.red)
                }

                Link(destination: URL(string: "http://instagram.com/besport24/")!) {
                    Label("Instagram", systemImage: "camera.fill")
                        .foregroundColor(.purple)
                }

                Link(destination: URL(string: "http://github.com/david13penalver")!) {
                    Label("GitHub", systemImage: "chevron.left.slash.chevron.right")
                        .foregroundColor(.primary)
                }
            }
        }
    }
}

#Preview {
    NavigationStack {
        ExternalLinksView()
    }
}

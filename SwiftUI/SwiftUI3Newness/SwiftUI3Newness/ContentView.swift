//
//  ContentView.swift
//  SwiftUI3Newness
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct ContentView: View {
    
    private let data = ["David", "Cami", "Iván", "Sheng", "Salva"]
    @State private var searchText = ""
    
    var body: some View {
        NavigationView {
            List {
                ForEach(data, id: \.self) { name in
                    HStack{
                        AsyncImage(url: URL(string: "https://images.wikidexcdn.net/mwuploads/wikidex/a/a8/latest/20211203212131/EP1178_Piplup_de_Dawn.png")).frame(width: 10, height: 10)
                        Text(name).bold()
                            .font(.largeTitle)
                            .padding()
                            
                    }.swipeActions(edge: .trailing, allowsFullSwipe: false) {
                        Button("Eliminar") {
                            
                        }.tint(.red)
                    }
                }.listRowSeparatorTint(.red)
                    .listRowSeparator(.hidden)
            }
            .refreshable {}
            .searchable(text: $searchText)
            .navigationBarTitle("SwiftUI 3")
        }
        .padding()
    }
}

#Preview {
    ContentView()
}

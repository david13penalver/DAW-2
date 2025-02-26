//
//  ListDetailView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

struct ListDetailView: View {
    
    var programmer = Programmer(id: 1, name: "David", language: "Swift", avatar: Image(systemName: "person.fill"), favorite: true)
    @Binding var favorite:Bool // Crea un enlace a una propiedad externa (pasada desde otra vista). Cuando favorite cambia aquí, también cambia en la vista que lo pasa, es decir, en ListView.
    
    var body: some View {
        VStack{
            programmer
                .avatar
                .resizable()
                .frame(width: 200, height: 200)
                .clipShape(Circle())
                .overlay(Circle()
                    .stroke(Color.black, lineWidth: 4))
                .shadow(color: Color.gray, radius: 5)
            HStack{
                Text(programmer.name)
                    .font(.title)
                Button {
                    favorite.toggle() // Modifica el estado de favorito
                } label: {
                    if favorite {
                        Image(systemName: "star.fill")
                            .foregroundColor(Color.yellow)
                    } else {
                        Image(systemName: "star")
                            .foregroundColor(Color.black)
                    }
                }
            }
            Text(programmer.language)
                .font(.subheadline)
            Spacer()
        }
    }
}

#Preview {
    ListDetailView(favorite: .constant(false)) // .constant(false) se usa para probar la vista sin necesidad de un @Binding real.
}

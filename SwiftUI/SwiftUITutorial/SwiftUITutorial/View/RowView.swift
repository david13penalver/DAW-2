//
//  RowView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI

struct RowView: View { // Esta estructura es la que va a seguir el bucle @for del ListView para mostrar los programadores
    
    var programmer: Programmer // Creamos la variable programmer del tipo Programmer (el struct)
    
    var body: some View { // En la vista creamos un HStack en el que mostrar los atributos que queremos
        HStack{
            programmer.avatar
                .resizable()
                .frame(width: 40, height: 40)
                .padding(10)
            VStack(alignment: .leading){
                Text(programmer.name)
                    .font(.title)
                Text(programmer.language)
                    .font(.subheadline)
            }
            Spacer() // Para alejar todo lo posible el contenido previo del siguiente
            
            if programmer.favorite { // Para mostrar la estrella solo si es true
                Image(systemName: "star.fill")
                    .foregroundColor(Color.yellow)
            }
        }
    }
}

#Preview {
    RowView(programmer: Programmer(
        id: 1,
        name: "David",
        language: "Swift",
        avatar: Image(systemName: "person.fill"),
        favorite: true
    ))
}

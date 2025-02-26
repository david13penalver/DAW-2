//
//  ListView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI

class ProgrammersModelData: ObservableObject { // Tipo observable porque queremos que cambie dinámicamente (como en Angular)
    
    @Published var programmers = [Programmer(id: 0, name: "David", language: "Swift", avatar: Image(systemName: "person"), favorite: true),
                               Programmer(id: 1, name: "Taylor", language: "Swift", avatar: Image(systemName: "person.fill"), favorite: false),
                               Programmer(id: 2, name: "Cami", language: "Kotlin", avatar: Image(systemName: "person.fill"), favorite: true),
                               Programmer(id: 3, name: "Iván", language: "PHP", avatar: Image(systemName: "person.fill"), favorite: false),
                               Programmer(id: 4, name: "Moni", language: "None", avatar: Image(systemName: "person.fill"), favorite: false)]
    // @Published permite que se detecten cambios y actualice las vistas automáticamente
}



struct ListView: View {
    
    @EnvironmentObject var programmersModelData: ProgrammersModelData // Permite acceder a la instancia de ProgrammersModelData en toda la jerarquía de vistas (ListView no necesita recibir programmersModelData como parámetro, sino que lo obtiene automáticamente del entorno)
    @State private var showFavorites = false // Indica que showFavorites es una variable de estado. Al cambiar showFavorites, la vista se actualiza automáticamente
    
    private var filteredProgrammers: [Programmer] {
        return programmersModelData.programmers.filter { programmer in
            return !showFavorites || programmer.favorite // Si showFavorites es false, devuelve esa (negación de negación, afirmación). Si es true, al ser negativa, pasa al segundo parámetro, que siempre es true
            // Funciona porque showFavorites es un filtro global que deja pasar todo.
        }
    }
    
    var body: some View {
        
        NavigationView{ // Permite la navegación entre pantallas
            VStack{
                Toggle(isOn: $showFavorites) { // Cambia el valor de showFavorites (al ser On, lo cambia a true). $showFavorites ($ indica binding) significa que la vista actualiza el valor de showFavorites cuando el usuario interactúa con el Toggle.
                    Text("Mostrar favoritos")
                }.padding()
                
                
                List(filteredProgrammers, id: \.id){ programmer in
                    NavigationLink(destination: ListDetailView( // Permite navegar a ListDetailView
                        programmer: programmer, // Pasa el programador de la lista como programmer de esa vista
                        favorite: $programmersModelData.programmers[programmer.id].favorite)){ // favorite es un binding a la propiedad favorite del programador seleccionado. Esto significa que si favorite cambia en ListDetailView, el cambio se refleja automáticamente en programmersModelData.
                        RowView(programmer: programmer)
                    }
                }
                    
                }.navigationTitle("List of programmers:")
        }
        
        
    }
}

#Preview {
    ListView().environmentObject(ProgrammersModelData()) // environmentObject(ProgrammersModelData()) inyecta una instancia de ProgrammersModelData en la vista ListView para que pueda acceder a los datos.
}

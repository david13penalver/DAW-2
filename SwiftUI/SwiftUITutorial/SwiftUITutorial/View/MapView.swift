//
//  MapView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 24/2/25.
//

import SwiftUI
import MapKit // Se importa MapKit porque SwiftUI no tiene este elemento (lo importa de Swift)

struct MapView: UIViewRepresentable { // Para hacer un mapa
    func makeUIView(context: Context) -> some MKMapView {
        MKMapView(frame: .zero)
    }
    
    func updateUIView(_ uiView: UIViewType, context: Context) {
        
        let coordinates = CLLocationCoordinate2D(
            latitude: 40.130176, longitude: -3.2012655
        )
        
        let span = MKCoordinateSpan(latitudeDelta: 2, longitudeDelta: 2) // Lo alejado que sale el mapa
        
        let region = MKCoordinateRegion(
            center: coordinates,
            span: span
        )
        
        uiView.setRegion(
            region, animated: true
        )
    }
}

#Preview {
    MapView()
}

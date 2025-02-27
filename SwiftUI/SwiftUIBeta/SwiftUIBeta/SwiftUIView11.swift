//
//  SwiftUIView11.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView11: View { // SwiftUI 11 - Day Picker
    
    @State var currentDate: Date = Date()
    
    var body: some View {
        
        Form {
            DatePicker("Agendar cita",
                       selection: $currentDate,
                       in: Date()...,
                       displayedComponents: .date)
            DatePicker("Agendar cita",
                       selection: $currentDate,
                       in: Date()...,
                       displayedComponents: .hourAndMinute)
            Text("Cita agendada: \(currentDate)")
                .bold()
            Text("Cita agendada: ")
                .bold()
            + Text(currentDate, style: .date)
        }
        
        ScrollView {
            DatePicker("Seleccionar fecha:", selection: $currentDate)
                .datePickerStyle(WheelDatePickerStyle())
            
            
            DatePicker("Seleccionar fecha:", selection: $currentDate)
                .datePickerStyle(GraphicalDatePickerStyle())
            
            
            }
    }
}

#Preview {
    SwiftUIView11()
}

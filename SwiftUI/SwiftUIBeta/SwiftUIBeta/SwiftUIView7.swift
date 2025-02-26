//
//  SwiftUIView7.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 26/2/25.
//

import SwiftUI

struct SwiftUIView7: View { // SwiftUI 7: Text
    var body: some View {
        Text("The Star Wars opening crawl is a signature device of the opening sequences of every numbered film of the Star Wars series, an American epic space opera franchise created by George Lucas. Within a black sky background featuring a smattering of stars, the crawl is preceded both by the opening static blue text, 'A long time ago in a galaxy far, far away....' and by the Star Wars logo which recedes toward a central point on the screen before disappearing. ")
            .font(.largeTitle)
            .underline()
            .rotation3DEffect(.degrees(40), axis: (x: 1, y: 0, z: 0))
            .shadow(color: .gray, radius: 3, x: 10, y: 20)
            .lineLimit(2)
            .lineSpacing(10)
            .padding()
        
        
        Text("Mare ") // Concatenar textos
            .foregroundColor(.blue)
        + Text("meua, ")
            .foregroundColor(.yellow)
            .bold()
        + Text("nano")
            .foregroundColor(.red)
            .font(.title)
        
        Text(Date(), style: .date)
        Text(Date(), style: .time)
        Text(Date(), style: .timer) // Temporizador
        Text(Date().addingTimeInterval(3600), style: .timer) // Cuenta atrás
    }
}

#Preview {
    SwiftUIView7()
}

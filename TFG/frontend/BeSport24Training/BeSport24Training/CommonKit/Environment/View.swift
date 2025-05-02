//
//  View.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import SwiftUI

extension View {
    func withValidation(_ errorMessage: String?) -> some View {
        self.modifier(ValidationModifier(errorMessage: errorMessage))
    }
}

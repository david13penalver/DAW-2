//
//  Bs24Buttton.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import SwiftUI

struct Bs24Button: View {
    
    enum ButtonType {
        case primary
        case secondary
        case tertiary
    }
    
    var text: String
    var type: ButtonType = .primary
    var maxWidth: CGFloat?
    var disabled: Bool = false
    let action: ()->()
    
    var body: some View {
        Button(action: {
            self.action()
        }) {
            Text(text)
                .padding(internalPadding)
                .font(fontSize)
        }
        .foregroundColor(foregroundColor)
        .padding(CGFloat(externalPadding))
        .frame(maxWidth: maxWidth)
        .background(backgroundColor)
        .cornerRadius(CGFloat(cornerRadius))
        .overlay(
            RoundedRectangle(cornerRadius: cornerRadius)
                .stroke(borderColor, lineWidth: 1)
        )
    }
    
    private var backgroundColor: Color {
        switch type {
        case .primary:
            return Color("AccentColor")
        case .secondary:
            return Color("WhiteColor")
        case .tertiary:
            return Color.clear
        }
    }
    
    private var foregroundColor: Color {
        switch type {
        case .primary:
            return Color("WhiteColor")
        case .secondary:
            return Color("AccentColor")
        case .tertiary:
            return Color("AccentColor")
        }
    }
    
    private var borderColor: Color {
        switch type {
        case .primary:
            return Color("AccentColor")
        case .secondary:
            return Color("AccentColor")
        case .tertiary:
            return .clear
        }
    }
    
    private var cornerRadius: CGFloat {
        switch type {
        case .primary:
            return 8
        case .secondary:
            return 8
        case .tertiary:
            return 0
        }
    }
    
    private var internalPadding: CGFloat {
        switch type {
        case .primary:
            return 12
        case .secondary:
            return 12
        case .tertiary:
            return 0
        }
    }
    
    private var externalPadding: CGFloat {
        switch type {
        case .primary:
            return 0
        case .secondary:
            return 0
        case .tertiary:
            return 4
        }
    }
    
    private var fontSize: Font? {
        switch type {
        case .primary:
            return nil
        case .secondary:
            return nil
        case .tertiary:
            return .footnote
        }
    }
}

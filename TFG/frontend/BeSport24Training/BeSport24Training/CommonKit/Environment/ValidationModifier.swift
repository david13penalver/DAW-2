//
//  ValidationModifier.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 2/5/25.
//

import SwiftUI

struct ValidationModifier: ViewModifier {
    
    let errorMessage: String?
    
    func body(content: Content) -> some View {
        VStack(alignment: .leading, spacing: 4) {
            content
            
            Text(errorMessage ?? "")
                .font(.caption)
                .foregroundStyle(.red)
                .frame(height: 20)
                .opacity(errorMessage == nil ? 0 : 1)
                .animation(.easeInOut(duration: 0.2), value: errorMessage)
        }
    }
}

enum ValidationRule {
    case required(String)
}

@propertyWrapper
struct Validate<T: Equatable> {
    
    private var value: T
    private var initialValue: T
    private var rules: [ValidationRule]
    private var isDirty = false
    
    var wrappedValue: T {
        get { value }
        set {
            if newValue != initialValue {
                isDirty = true
            }
            
            value = newValue
        }
    }
    
    var projectedValue: String? {
        guard isDirty else { return nil }
        
        for rule in rules {
            if let message = validate(rule: rule) {
                return message
            }
        }
        
        return nil
    }
    
    private func validate(rule: ValidationRule) -> String? {
        switch rule {
        case .required(let message):
            return validateRequired(message: message)
        }
    }
    
    private func validateRequired(message: String) -> String? {
        if let stringValue = value as? String, stringValue.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty {
            return message
        }
        return nil
    }
    
    init(wrappedValue: T, _ rules: ValidationRule...) {
        self.value = wrappedValue
        self.initialValue = wrappedValue
        self.rules = rules
    }
}

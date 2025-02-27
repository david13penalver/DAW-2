//
//  SwiftUIView9.swift
//  SwiftUIBeta
//
//  Created by David Peñalver Navarro on 27/2/25.
//

import SwiftUI

struct SwiftUIView9: View { // SwiftUi 9 - TextField & SecureField
    
    @State var username: String = ""
    @State var password: String = ""
    
    var body: some View {
        VStack {
            TextField("Username", text: $username)
                .keyboardType(.emailAddress)
                .disableAutocorrection(true)
                .padding(8)
                .font(.headline)
                .background(Color.gray.opacity(0.25))
                .cornerRadius(6)
                .padding(.horizontal, 60)
                .padding(.top, 40)
                .onSubmit {
                    print("New value: \(username)")
                }
            
            SecureField("Password", text: $password)
                .keyboardType(.default)
                .disableAutocorrection(true)
                .autocapitalization(.none)
                .padding(8)
                .font(.headline)
                .background(Color.gray.opacity(0.25))
                .cornerRadius(6)
                .padding(.horizontal, 60)
                .onChange(of: password, perform: {value in
                        print("New password value: \(value)")
                })
        }
        Spacer()
    }
}

#Preview {
    SwiftUIView9()
}

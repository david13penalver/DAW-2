//
//  LoginView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import SwiftUI

struct LoginView: View {
    
    // TODO: Literals
    private var recoverPasswordText = "Don't remember my password"
    private var loginButtonText = "Log in"
    private var registerButtonText = "Sign up"
    
    @StateObject private var vm = LoginViewModel()
    
    @Environment(\.colorScheme) var colorScheme
    
    @FocusState private var isTextFocused: Bool
    @FocusState private var isPasswordFocused: Bool
    @FocusState private var isFieldFocus: FieldToFocus?
    
    @State private var isVisible: Bool = false
    @State private var isRegistered: Bool = false
    @State private var isPasswordForgotten: Bool = false
    
    enum FieldToFocus {
        case secureField, textField
    }
    
    var body: some View {
        ZStack {
            VStack {
                Image("Logo")
                    .resizable()
                    .scaledToFit()
                    .frame(height: 150)
                    .padding(.top, 60)
                    .if(colorScheme == .light) { view in
                                    view.foregroundStyle(Color("AccentColor"))
                                }
                
                Spacer()
                
                userForm
                
                VStack {
                    passwordForm
                    
                    recoverPassword
                }
                .padding(.horizontal, 24)
                
                Spacer()
                
                buttonsArea
            }
            .sheet(isPresented: $isRegistered) {
                RegisterView()
            }
        }
        .background(Color("BackgroundColor"), ignoresSafeAreaEdges: .all)
        .onTapGesture {
            isTextFocused = false
            isPasswordFocused = false
        }
        .toolbar {
            ToolbarItemGroup(placement: .keyboard) {
                if isTextFocused {
                    Button {
                        isTextFocused.toggle()
                    } label: {
                        Image(systemName: "chevron.up")
                    }
                    .disabled(true)
                    Button {
                        isPasswordFocused.toggle()
                    } label: {
                        Image(systemName: "chevron.down")
                    }
                } else {
                    Button {
                        isTextFocused.toggle()
                    } label: {
                        Image(systemName: "chevron.up")
                    }
                    Button {
                        isPasswordFocused.toggle()
                    } label: {
                        Image(systemName: "chevron.down")
                    }
                }
                Spacer()
            }
        }
        
    }
    
    private var userForm: some View {
        HStack {
            HStack {
                Image(systemName: "envelope.fill")
                    .foregroundStyle(isTextFocused ? Color("FocusColor") : Color("GrayColor"))
                TextField("", text: $vm.email, prompt: Text("Email").foregroundColor(Color("GrayColor")))
                    .foregroundStyle(Color("BlackColor"))
                    .focused($isTextFocused)
                    .autocorrectionDisabled()
                    .keyboardType(.emailAddress)
                    .textContentType(.emailAddress)
                    .autocapitalization(.none)
            }
            .padding(.vertical, 12)
            .padding(.horizontal)
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isTextFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
            )
            .background(Color("WhiteColor"))
            .cornerRadius(8)
        }
        .withValidation(vm.$email)
        .backgroundStyle(Color.clear)
        .padding(.horizontal, 24)
    }
    
    private var passwordForm: some View {
        HStack {
            Image(systemName: "lock.fill")
                .foregroundStyle(isPasswordFocused ? Color("FocusColor") : Color("GrayColor"))
            Group {
                if isVisible {
                    TextField("", text: $vm.password, prompt: Text("Password").foregroundColor(Color("GrayColor")))
                        .foregroundStyle(Color("BlackColor"))
                        .focused($isPasswordFocused)
                        .focused($isFieldFocus, equals: .textField)
                    
                } else {
                    SecureField("", text: $vm.password, prompt: Text("Password").foregroundColor(Color("GrayColor")))
                        .foregroundStyle(Color("BlackColor"))
                        .focused($isPasswordFocused)
                        .focused($isFieldFocus, equals: .secureField)
                }
            }
            .autocapitalization(.none)
            .autocorrectionDisabled()
            .textContentType(.password)
            
            Button {
                self.isVisible.toggle()
            } label: {
                isVisible ? Image(systemName: "eye.fill") : Image(systemName: "eye.slash.fill")
            }
            .tint(isPasswordFocused ? Color("FocusColor") : Color("GrayColor"))
        }
        .onChange(of: isVisible) { _, newValue in
            isFieldFocus = newValue ? .textField : .secureField
        }
        .padding(.horizontal)
        .padding(.vertical, 12)
        .background(Color("WhiteColor"))
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(isPasswordFocused ? Color("FocusColor") : Color("GrayColor"), lineWidth: 1)
        )
        .cornerRadius(8)
        .withValidation(vm.$password)
    }
    
    private var recoverPassword: some View {
        HStack {
            Spacer()
            Bs24Button(text: recoverPasswordText, type: .tertiary) {
                print("Recovering password")
            }
            .offset(y: -30)
        }
    }
    
    private var buttonsArea: some View {
        VStack(spacing: 16) {
            Bs24Button(text: loginButtonText, type: .primary, maxWidth: .infinity) {
                isTextFocused = false
                isPasswordFocused = false
                Task {
                    await vm.login()
                }
            }
            .alert(vm.alertMessage, isPresented: $vm.showAlert) {
                Button("OK", role: .cancel) { }
            }
            .padding(.horizontal, 24)
            
            Bs24Button(text: registerButtonText, type: .secondary, maxWidth: .infinity) {
                isRegistered.toggle()
            }
            .padding(.horizontal, 24)
        }
    }
}

extension View {
    @ViewBuilder func `if`<Content: View>(_ condition: Bool, apply: (Self) -> Content) -> some View {
        if condition {
            apply(self)
        } else {
            self
        }
    }
}

#Preview {
    LoginView()
}

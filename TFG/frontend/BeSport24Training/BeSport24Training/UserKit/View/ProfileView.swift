//
//  ProfileView.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 3/5/25.
//

import SwiftUI

struct ProfileView: View {
    
    @StateObject var vm = LoginViewModel()
    
    var body: some View {
        NavigationStack {
            VStack(spacing: 24) {
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Image(systemName: "person.fill")
                            .foregroundColor(.blue)
                        Spacer()
                        Text(vm.user?.name ?? "David Peñalver")
                            .foregroundStyle(Color("PrimaryColor"))
                            .font(.caption)
                    }
                    
                    HStack {
                        Image(systemName: "envelope.fill")
                            .foregroundColor(.green)
                        Spacer()
                        Text(vm.user?.email ?? "davpennav@alu.edu.gva.es")
                            .foregroundStyle(Color("PrimaryColor"))
                            .font(.caption)
                    }
                    
                    HStack {
                        Image(systemName: "lock.fill")
                            .foregroundColor(Color("RedColor"))
                        Spacer()
                        Text("••••••••")
                            .foregroundStyle(Color("PrimaryColor"))
                            .fontWeight(.regular)
                    }
                }
                .padding()
                .background(Color("WhiteColor"))
                .cornerRadius(12)
                .shadow(radius: 4)
                
                HStack(spacing: 20) {
                    Button(action: {
                        // Acción editar (pendiente)
                    }) {
                        Label("Edit", systemImage: "pencil")
                            .frame(maxWidth: .infinity)
                    }
                    .buttonStyle(.borderedProminent)
                    .tint(.blue)
                    
                    Button(action: {
                        // Acción eliminar (pendiente)
                    }) {
                        Label("Delete", systemImage: "trash")
                            .frame(maxWidth: .infinity)
                    }
                    .buttonStyle(.bordered)
                    .tint(.red)
                }
                .padding(.horizontal)
            }
            .padding()
            .navigationTitle("Profile")
            .navigationBarTitleDisplayMode(.inline)
            .onAppear {
                Task {
                    await vm.findUserById()
                }
            }
        }
    }
}

#Preview {
    ProfileView()
}

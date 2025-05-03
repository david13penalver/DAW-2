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
        VStack(alignment: .leading) {
            HStack {
                Text("Name: ")
                Text(vm.user?.name ?? "Empty name")
            }
            HStack {
                Text("Email: ")
                Text(vm.user?.email ?? "Empty email")
            }
        }
        .onAppear() {
            Task {
                await vm.findUserById()
            }
        }
    }
}

#Preview {
    ProfileView()
}

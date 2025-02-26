//
//  EnvironmentView.swift
//  SwiftUITutorial
//
//  Created by David Peñalver Navarro on 25/2/25.
//

import SwiftUI

struct EnvironmentView: View {
    
    @EnvironmentObject var user: UserData
    
    var body: some View {
        Text(user.name)
    }
}

#Preview {
    EnvironmentView().environmentObject(UserData())
}

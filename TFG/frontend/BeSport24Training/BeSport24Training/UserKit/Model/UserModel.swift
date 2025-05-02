//
//  UserModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

struct UserModel: Encodable, Sendable, Identifiable {
    var id: Int
    var name: String
}

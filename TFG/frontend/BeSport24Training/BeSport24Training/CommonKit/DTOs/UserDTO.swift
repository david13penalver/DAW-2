//
//  UserDTO.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

struct UserDTO: Encodable, Sendable, Identifiable {
    var id: Int?
    var name: String?
    var email: String
    var password: String
    
    init(dto: UserModel) {
        self.id = dto.id
        self.name = dto.name
        self.email = dto.email
        self.password = dto.password
    }
    
    init(email: String, password: String) {
        self.email = email
        self.password = password
    }
    
    init(name: String, email: String, password: String) {
        self.name = name
        self.email = email
        self.password = password
    }
}

//
//  SessionModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

struct SessionModel: Identifiable {
    let id: Int
    let name: String
    let description: String?
    let dateCreation: Date?
    
    init(id: Int, name: String, description: String?, dateCreation: Date?) {
        self.id = id
        self.name = name
        self.description = description
        self.dateCreation = dateCreation
    }
    
    init(id: Int, name: String) {
        self.id = id
        self.name = name
        self.description = ""
        self.dateCreation = Date.now
    }
    
    init(dto: SessionDTO) {
        self.id = dto.id
        self.name = dto.name
        self.description = dto.description
        self.dateCreation = dto.dateCreation
    }
}

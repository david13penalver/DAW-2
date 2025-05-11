//
//  SessionDTO.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

struct SessionDTO: Codable, Identifiable, Sendable {
    let id: Int
    let name: String
    let description: String?
    let dateCreation: Date?

    private enum CodingKeys: String, CodingKey {
        case id = "sessionId"
        case name
        case description
        case dateCreation
    }

    // Decodificador personalizado para convertir String → Date
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        id = try container.decode(Int.self, forKey: .id)
        name = try container.decode(String.self, forKey: .name)
        description = try container.decodeIfPresent(String.self, forKey: .description)
        
        if let dateString = try container.decodeIfPresent(String.self, forKey: .dateCreation) {
            let formatter = DateFormatter()
            formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
            formatter.locale = Locale(identifier: "en_US_POSIX")
            dateCreation = formatter.date(from: dateString)
        } else {
            dateCreation = nil
        }
    }
    
    init(dto: SessionModel) {
        self.id = dto.id
        self.name = dto.name
        self.description = dto.description
        self.dateCreation = dto.dateCreation
    }
}

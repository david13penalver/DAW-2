//
//  TrainingDTO.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

import Foundation

struct TrainingDTO: Codable, Identifiable, Sendable {
    var id: Int { trainingId }

    let trainingId: Int
    let name: String
    let trainingDurationSeconds: Int
    let dateCreation: Date?
    let session: SessionDTO?

    private enum CodingKeys: String, CodingKey {
        case trainingId
        case name
        case trainingDurationSeconds
        case dateCreation
        case session
    }
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        trainingId = try container.decode(Int.self, forKey: .trainingId)
        name = try container.decode(String.self, forKey: .name)
        trainingDurationSeconds = try container.decode(Int.self, forKey: .trainingDurationSeconds)

        // Decodificar la fecha si está presente
        if let dateString = try container.decodeIfPresent(String.self, forKey: .dateCreation) {
            let formatter = DateFormatter()
            formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
            formatter.locale = Locale(identifier: "en_US_POSIX")
            dateCreation = formatter.date(from: dateString)
        } else {
            dateCreation = nil
        }

        session = try container.decodeIfPresent(SessionDTO.self, forKey: .session)
    }

    init(from dto: TrainingModel) {
        self.trainingId = dto.trainingId
        self.name = dto.name
        self.trainingDurationSeconds = dto.trainingDurationSeconds
        self.dateCreation = dto.dateCreation
        self.session = dto.session.map { SessionDTO(dto: $0) }
    }
}

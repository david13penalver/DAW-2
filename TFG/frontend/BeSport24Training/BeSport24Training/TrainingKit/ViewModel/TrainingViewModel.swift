//
//  TrainingViewModel.swift
//  BeSport24Training
//
//  Created by David Peñalver Navarro on 1/5/25.
//

@MainActor
final class TrainingViewModel {
    
    var training: TrainingModel?
    var trainings: [TrainingModel] = []
    
    private let interactor: TrainingInteractorProtocol
    
    init(interactor: TrainingInteractorProtocol = TrainingInteractorImpl()) {
        self.interactor = interactor
    }
    
    func getAllTrainings() async {
        //trainings = try! await interactor.getAllTrainings()
    }
}

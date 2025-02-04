package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Figure;
import com.fpmislata.bookstore.domain.repository.FigureRepository;
import com.fpmislata.bookstore.domain.service.FigureService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class FigureServiceImpl implements FigureService {

    private final FigureRepository figureRepository;

    @Override
    public List<Figure> findAllById(List<Figure> figures) {
        List<Figure> foundFigures =  figureRepository.findAllById(
                figures
                        .stream()
                        .map(Figure::getId)
                        .toArray(Long[]::new)
        );
        if(foundFigures.size() != figures.size()) {
            throw new ResourceNotFoundException("Some genres were not found");
        }
        return foundFigures;
    }
}

package com.fpmislata.bookstore.controller.user.webmodel;

import java.util.List;

public record GameWithRole(
        List<FigureWithRole> figures
) {
}

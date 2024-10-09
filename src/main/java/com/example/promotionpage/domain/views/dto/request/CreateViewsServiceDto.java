package com.example.promotionpage.domain.views.dto.request;

import com.example.promotionpage.domain.views.domain.Views;

import java.util.Date;

public record CreateViewsServiceDto(
        Integer year,
        Integer month,
        Long views
) {
    public Views toEntity(Date date) {
        return Views.builder()
                .year(year)
                .month(month)
                .views(views)
                .createdAt(date)
                .build();
    }
}

package com.example.promotionpage.domain.recruitment.dto.request;

import com.example.promotionpage.domain.recruitment.domain.Recruitment;
import com.example.promotionpage.domain.recruitment.domain.Status;

import java.util.Date;

public record CreateRecruitmentServiceRequestDto(
        String title,
        Date startDate,
        Date deadline,
        String link
) {
    public Recruitment toEntity(Date date, Status status) {
        return Recruitment.builder()
                .title(title)
                .startDate(startDate)
                .deadline(deadline)
                .link(link)
                .createdAt(date)
                .status(status)
                .build();
    }
}

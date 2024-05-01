package com.example.promotionpage.domain.request.dto.request;

import java.util.Date;
import java.util.List;

import com.example.promotionpage.domain.request.domain.Request;

public record CreateRequestServiceDto(
	 String category,
	 String projectName,
	 String clientName,
	 String organization,
	 String contact,
	 String email,
	 String position,
	 String description
) {
	public Request toEntity(List<String> fileUrlList, String answer, Integer year, Integer month, Integer state, Date date) {
		return Request.builder()
				.category(category)
				.projectName(projectName)
				.clientName(clientName)
				.organization(organization)
				.contact(contact)
				.email(email)
				.position(position)
				.description(description)
				.answer(answer)
				.year(year)
				.month(month)
				.fileUrlList(fileUrlList)
				.state(state)
				.createdAt(date)
				.build();
	}
}

package com.example.promotionpage.domain.request.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CreateRequestDto(
	 @Schema(description = "카테고리, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "category는 필수 값입니다.")
	 String category,

	 @Schema(description = "의뢰인 이름, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "clientName은 필수 값입니다.")
	 String clientName,

	 @Schema(description = "기관 혹은 기업 이름, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "organization은 필수 값입니다.")
	 String organization,

	 @Schema(description = "연락처, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "contact는 필수 값입니다.")
	 String contact,

	 @Schema(description = "이메일 주소, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "email은 필수 값입니다.")
	 String email,

	 @Schema(description = "직책, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "position은 필수 값입니다.")
	 String position,

	 @Schema(description = "프로젝트 설명, 빈 값/공백/null 을 허용하지 않습니다.")
	 @NotBlank(message = "description은 필수 값입니다.")
	 String description
) {
	public CreateRequestServiceDto toServiceRequest() {
		return new CreateRequestServiceDto(category, clientName, organization, contact, email, position, description);
	}
}

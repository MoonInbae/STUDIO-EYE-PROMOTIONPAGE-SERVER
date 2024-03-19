package com.example.promotionpage.domain.partnerInformation.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.promotionpage.domain.partnerInformation.application.PartnerInformationService;
import com.example.promotionpage.domain.partnerInformation.dto.request.CreatePartnerInfoRequestDto;
import com.example.promotionpage.domain.project.dto.request.CreateProjectRequestDto;
import com.example.promotionpage.domain.project.dto.request.UpdateProjectRequestDto;
import com.example.promotionpage.global.common.response.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "협력사 API", description = "협력사 목록 전체 조회 / 협력사 상세 조회 / 저장 / 삭제")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartnerInformationController {

	private final PartnerInformationService partnerInformationService;

	@Operation(summary = "협력사 정보 등록 API")
	@PostMapping("/partners")
	public ApiResponse createPartnerInfo(@Valid @RequestPart("request") CreatePartnerInfoRequestDto dto, @RequestPart(value = "file", required = false) MultipartFile file){
		return partnerInformationService.createPartnerInfo(dto.toServiceRequest(), file);
	}

	@Operation(summary = "협력사 정보 삭제 API")
	@DeleteMapping("/partners/{partnerId}")
	public ApiResponse deletePartnerInfo(@PathVariable Long partnerId){
		return partnerInformationService.deletePartnerInfo(partnerId);
	}

	@Operation(summary = "협력사 목록 전체 조회 API")
	@GetMapping("/partners")
	public ApiResponse retrieveAllPartnerInfo(){
		return partnerInformationService.retrieveAllPartnerInfo();
	}

	@Operation(summary = "협력사 정보 상세 조회 API")
	@GetMapping("/partners/{partnerId}")
	public ApiResponse retrievePartnerInfo(@PathVariable Long partnerId){
		return partnerInformationService.retrievePartnerInfo(partnerId);
	}

}

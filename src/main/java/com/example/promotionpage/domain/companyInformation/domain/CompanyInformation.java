package com.example.promotionpage.domain.companyInformation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    @NotNull
    private String logoImageFileName;

    @NotNull
    private String logoImageUrl;

    @NotNull
    private String phone;

    @NotNull
    private String fax;

    @NotNull
    private String introduction;

    @NotNull
    private String sloganImageFileName;

    @NotNull
    private String sloganImageUrl;

    @ElementCollection
    private Map<String, String> detailInformation;

    @Builder
    public CompanyInformation(String address,
                              String logoImageFileName, String logoImageUrl,
                              String phone,
                              String fax,
                              String introduction,
                              String sloganImageFileName, String sloganImageUrl,
                              Map<String, String> detailInformation) {
        this.address = address;
        this.logoImageFileName = logoImageFileName;
        this.logoImageUrl = logoImageUrl;
        this.phone = phone;
        this.fax = fax;
        this.introduction = introduction;
        this.sloganImageFileName = sloganImageFileName;
        this.sloganImageUrl = sloganImageUrl;
        this.detailInformation = detailInformation;
    }
}
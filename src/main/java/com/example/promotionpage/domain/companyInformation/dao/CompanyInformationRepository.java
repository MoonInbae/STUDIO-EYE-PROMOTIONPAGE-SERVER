package com.example.promotionpage.domain.companyInformation.dao;

import com.example.promotionpage.domain.companyInformation.domain.CompanyInformation;
import com.example.promotionpage.domain.faq.dao.FaqQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Long> {
    @Query("SELECT c.logoImageUrl AS logoImageUrl FROM CompanyInformation c")
    List<String> findLogoImageUrl();
    @Query("SELECT c.address AS address, c.phone AS phone, c.fax AS fax FROM CompanyInformation c")
    List<CompanyBasicInformation> findAddressAndPhoneAndFax();
    @Query("SELECT c.introduction AS introduction, c.sloganImageUrl AS sloganImageUrl FROM CompanyInformation c")
    List<CompanyIntroductionInformation> findIntroductionAndSloganImageUrl();
}

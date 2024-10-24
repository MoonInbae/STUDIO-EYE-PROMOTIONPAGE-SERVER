package com.example.promotionpage.domain.partner_information.dao;

import com.example.promotionpage.domain.partner_information.domain.PartnerInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerInformationRepository extends JpaRepository<PartnerInformation, Long> {
    Page<PartnerInformation> findAll(Pageable pageable);

}

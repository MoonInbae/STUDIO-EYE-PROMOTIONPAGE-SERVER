package com.example.promotionpage.domain.benefit.dao;

import com.example.promotionpage.domain.benefit.domain.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
}

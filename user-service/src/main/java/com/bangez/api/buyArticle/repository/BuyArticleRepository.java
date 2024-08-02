package com.bangez.api.buyArticle.repository;

import com.bangez.api.buyArticle.domain.BuyArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyArticleRepository extends JpaRepository<BuyArticle, Long> {
}
package com.bangez.api.sellArticle.repository;

import com.bangez.api.sellArticle.domain.SellArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellArticleRepository extends JpaRepository<SellArticle, Long> {
}
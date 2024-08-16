package com.bangez.tx.repository;

import com.bangez.tx.domain.model.PointModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointModel, Long>{
    PointModel findByUserId(Long userId);

    Boolean existsByUserId(Long userId);
}
package com.bangez.tx.repository;

import com.bangez.tx.domain.model.TxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxRepository extends JpaRepository<TxModel, Long> {
}

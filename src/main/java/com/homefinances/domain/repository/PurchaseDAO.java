package com.homefinances.domain.repository;

import com.homefinances.domain.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseDAO extends JpaRepository<Purchase, Integer> {

}

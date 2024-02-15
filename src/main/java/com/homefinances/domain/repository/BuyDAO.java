package com.homefinances.domain.repository;

import com.homefinances.domain.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BuyDAO extends JpaRepository<Buy, Integer> {

}

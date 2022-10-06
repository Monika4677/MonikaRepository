package com.luxoft.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxoft.boot.entity.Trainer;
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
	Trainer findByEmail(String email);
}

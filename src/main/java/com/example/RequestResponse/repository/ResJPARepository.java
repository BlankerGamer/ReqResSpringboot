package com.example.RequestResponse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RequestResponse.entity.ResponseEntity;

@Repository
public interface ResJPARepository extends JpaRepository<ResponseEntity,Long> {
	

}

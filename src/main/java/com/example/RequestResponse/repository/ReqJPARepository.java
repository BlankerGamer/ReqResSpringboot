package com.example.RequestResponse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RequestResponse.entity.RequestEntity;
import com.example.RequestResponse.entity.ResponseEntity;
import com.example.RequestResponse.model.ResponseModel;


@Repository
public interface ReqJPARepository extends JpaRepository<RequestEntity, Long> {

	ResponseEntity save(ResponseEntity resEntity);

}

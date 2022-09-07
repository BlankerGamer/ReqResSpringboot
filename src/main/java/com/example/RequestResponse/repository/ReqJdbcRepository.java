package com.example.RequestResponse.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.RequestResponse.entity.RequestEntity;


@Repository
public class ReqJdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RequestEntity> getRequest() {
		StringBuilder sql = new StringBuilder();
		sql.append("select request_data  from request_data");
		List<RequestEntity> req = jdbcTemplate.query(sql.toString(),
				new BeanPropertyRowMapper<>(RequestEntity.class));
		return req;
		
	}

}

package com.example.RequestResponse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RequestResponse.service.ReqResService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class ReqResController {
	
	@Autowired
	private ReqResService reqResService;

    @GetMapping("/Test")
    String test(){
        return "Worked";
    }
    
//	@PostMapping("/insert")
//	public Object insertData(@RequestBody Object RequestObject) throws JsonProcessingException {
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String json = ow.writeValueAsString(RequestObject);
//		System.out.println(json);
//		return reqResServicel.insertData(RequestObject);	
//	}
    
    @PostMapping("/insert")
    public Object insertData(@RequestBody String tin) {
    	return reqResService.insertData(tin);
    }
    
//	@PostMapping("/insert")
//	public Object insertData(@RequestBody RequestEntity reqEntity) {
//		return reqResServicel.insertData(reqEntity);	
//	}
    
}

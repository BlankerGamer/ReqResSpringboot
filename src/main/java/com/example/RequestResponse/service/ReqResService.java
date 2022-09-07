package com.example.RequestResponse.service;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.RequestResponse.entity.RequestEntity;
import com.example.RequestResponse.entity.ResponseEntity;
import com.example.RequestResponse.repository.ReqJPARepository;
import com.example.RequestResponse.repository.ReqJdbcRepository;
import com.example.RequestResponse.repository.ResJPARepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
@Transactional
public class ReqResService {

	@Autowired
	private ReqJPARepository reqResjpaRepository;

	@Autowired
	private ResJPARepository jpaRepository;

	@Autowired
	private ReqJdbcRepository reqJdbcRepository;
	
	@Value("${service-config.url.vatinfo-rest-service}")
	public String BASE_URL_VATINFO;
	
	
	public Object insertData(String tin) {
	Object Datas = null;
	RequestEntity reqEntitys = new RequestEntity();
	ResponseEntity resEntity = new ResponseEntity();
	try (final DatagramSocket socket = new DatagramSocket()) {
		socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		String ip = socket.getLocalAddress().getHostAddress();

		InetAddress addr;
		addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();
		
		String url = BASE_URL_VATINFO;
		String uri = url + "/nidws/getNIDTaxpayer/NID/"+ tin;
		RestTemplate restTemplate = new RestTemplate();
		String jsonString = restTemplate.getForObject(uri, String.class);

		reqEntitys.setRequestData(tin);
		reqEntitys.setCreateBy(hostname);
		reqEntitys.setCreateIp(ip);
		reqEntitys.setCreateDateTime(new Date());
		Datas = reqEntitys = reqResjpaRepository.save(reqEntitys);

		System.out.println("GET "+jsonString);
		resEntity.setId(reqEntitys.getId());
		resEntity.setResponseData(jsonString);
		resEntity.setCreateBy(reqEntitys.getCreateBy());
		resEntity.setCreateIp(reqEntitys.getCreateIp());
		resEntity.setCreateDateTime(reqEntitys.getCreateDateTime());
	} catch (Exception e) {
		e.getMessage();
	} finally {
		Datas = jpaRepository.save(resEntity);
	}
	return Datas;
}

//	public Object insertData(Object JsonRequest) {
//		Object Datas = null;
//	
//		RequestEntity reqEntitys = new RequestEntity();
//		ResponseEntity resEntity = new ResponseEntity();
//		try (final DatagramSocket socket = new DatagramSocket()) {
//			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
//			String ip = socket.getLocalAddress().getHostAddress();
//
//			InetAddress addr;
//			addr = InetAddress.getLocalHost();
//			String hostname = addr.getHostName();
//
//			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//			String json = ow.writeValueAsString(JsonRequest);
//
//			JSONObject obj = new JSONObject(String.valueOf(json));
//			Object taxIdRequest = obj.getJSONObject("requestData").get("taxpayerIdentifier");
//
//			List<RequestEntity> reqs = reqJdbcRepository.getRequest();
//			for (RequestEntity requestEntity : reqs) {
//				String C = requestEntity.getRequestData();
//				JSONObject objs = new JSONObject(String.valueOf(C));
//				Object taxIdDataBase = objs.getJSONObject("requestData").get("taxpayerIdentifier");
//				boolean checked = taxIdRequest.toString().equals(taxIdDataBase.toString());
//				System.out.println(taxIdRequest + " -" + checked + "- " + taxIdDataBase);
//				
//				if (checked) {
//					resEntity.setResponseData("Haved_id");
//					break;
//				} else {
//					resEntity.setResponseData("Don't_Have_Id");
//				}
//			}
//
//			reqEntitys.setRequestData(json);
//			reqEntitys.setCreateBy(hostname);
//			reqEntitys.setCreateIp(ip);
//			reqEntitys.setCreateDateTime(new Date());
//			Datas = reqEntitys = reqResjpaRepository.save(reqEntitys);
//
//			resEntity.setId(reqEntitys.getId());
//			resEntity.setCreateBy(reqEntitys.getCreateBy());
//			resEntity.setCreateIp(reqEntitys.getCreateIp());
//			resEntity.setCreateDateTime(reqEntitys.getCreateDateTime());
//		} catch (Exception e) {
//			e.getMessage();
//		} finally {
//			Datas = jpaRepository.save(resEntity);
//		}
//		return Datas;
//	}
//	
	
//	public Object getNidws(String nid) throws JsonMappingException, JsonProcessingException {
//		String url = BASE_URL_VATINFO;
//		String uri = url + "/nidws/getNIDTaxpayer/NID/" + nid;
//		RestTemplate restTemplate = new RestTemplate();
//		String jsonString = restTemplate.getForObject(uri, String.class);
//		ObjectMapper om = new ObjectMapper();
//		ResponseModel resModel = om.readValue(jsonString, ResponseModel.class);
//		return resModel;
//		
//	}
	



}

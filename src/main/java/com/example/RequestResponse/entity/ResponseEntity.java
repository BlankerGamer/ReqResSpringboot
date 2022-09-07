package com.example.RequestResponse.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response_data")
public class ResponseEntity {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "RESPONSE_DATA", length = 8000)
    private String responseData;

    @Column(name = "CREATE_BY", length = 20)
    private String createBy;

    @Column(name = "CREATE_IP", length = 20)
    private String createIp;

    @Column(name = "CREATE_DATETIME")
    private Date createDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public ResponseEntity(Long id, String responseData, String createBy, String createIp, Date createDateTime) {
        super();
        this.id = id;
        this.responseData = responseData;
        this.createBy = createBy;
        this.createIp = createIp;
        this.createDateTime = createDateTime;
    }

    public ResponseEntity() {
        super();
    }

	
	
}

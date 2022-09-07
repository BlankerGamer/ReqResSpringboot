package com.example.RequestResponse.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_data")
public class RequestEntity {
    private static final long serialVersionUID = 3140361898308950985L;
    protected static final String PK = "ID";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "REQUEST_DATA", length = 8000)
    private String requestData;

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

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public static String getPk() {
        return PK;
    }

    public RequestEntity(Long id, String requestData, String createBy, String createIp, Date createDateTime) {
        super();
        this.id = id;
        this.requestData = requestData;
        this.createBy = createBy;
        this.createIp = createIp;
        this.createDateTime = createDateTime;
    }

    public RequestEntity() {
        super();
    }

}

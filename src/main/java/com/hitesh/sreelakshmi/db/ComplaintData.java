package com.hitesh.sreelakshmi.db;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="complaint_data")
@Entity
public class ComplaintData {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNo;
	private String complaintData;
	private String workerAssigned;
	@CreatedDate
	private Date OpenedDateTime;
	@UpdateTimestamp
	private Date closedDateTime;
	private Date closedDate;
    
    public ComplaintData() {
    	
    }
    
    public ComplaintData(String firstName,String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	//5432
	public String getComplaintData() {
		return complaintData;
	}

	public void setComplaintData(String complaintData) {
		this.complaintData = complaintData;
	}

	public String getWorkerAssigned() {
		return workerAssigned;
	}

	public void setWorkerAssigned(String workerAssigned) {
		this.workerAssigned = workerAssigned;
	}

	public Date getOpenedDateTime() {
		return OpenedDateTime;
	}

	public void setOpenedDateTime(Date openedDateTime) {
		OpenedDateTime = openedDateTime;
	}

	public Date getClosedDateTime() {
		return closedDateTime;
	}

	public void setClosedDateTime(Date closedDateTime) {
		this.closedDateTime = closedDateTime;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
    
    

}

package com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="tracker_enquiries")
public class TrackerEnquiries {
@Column(name="enqr_id")
private int  enqr_id;
@Column(name="enqr_date")
private  LocalDateTime enqr_date;
@Column(name="enqr_createdby")
private String enqr_createdby;
@Column(name="enqr_cust_id")
private int enqr_cust_id;
@Column(name="enqr_subject")
 private String enqr_subject;
@Column(name="enqr_desc")
 private String enqr_desc;
@Column(name="enqr_status")
private  String enqr_status;
@Column(name="enqr_assigned_to")
private int enqr_assigned_to;
@Column(name="enqr_ludate")
private  LocalDateTime enqr_ludate;
@Column(name="enqr_luser")
private int enqr_luser;

public int getEnqr_id() {
	return enqr_id;
}
public void setEnqr_id(int enqr_id) {
	this.enqr_id = enqr_id;
}
public LocalDateTime getEnqr_date() {
	return enqr_date;
}
public void setEnqr_date(LocalDateTime enqr_date) {
	this.enqr_date = enqr_date;
}
public String getEnqr_createdby() {
	return enqr_createdby;
}
public void setEnqr_createdby(String enqr_createdby) {
	this.enqr_createdby = enqr_createdby;
}
public int getEnqr_cust_id() {
	return enqr_cust_id;
}
public void setEnqr_cust_id(int enqr_cust_id) {
	this.enqr_cust_id = enqr_cust_id;
}
public String getEnqr_subject() {
	return enqr_subject;
}
public void setEnqr_subject(String enqr_subject) {
	this.enqr_subject = enqr_subject;
}
public String getEnqr_desc() {
	return enqr_desc;
}
public void setEnqr_desc(String enqr_desc) {
	this.enqr_desc = enqr_desc;
}
public String getEnqr_status() {
	return enqr_status;
}
public void setEnqr_status(String enqr_status) {
	this.enqr_status = enqr_status;
}
public int getEnqr_assigned_to() {
	return enqr_assigned_to;
}
public void setEnqr_assigned_to(int enqr_assigned_to) {
	this.enqr_assigned_to = enqr_assigned_to;
}
public LocalDateTime getEnqr_ludate() {
	return enqr_ludate;
}
public void setEnqr_ludate(LocalDateTime enqr_ludate) {
	this.enqr_ludate = enqr_ludate;
}
public int getEnqr_luser() {
	return enqr_luser;
}
public void setEnqr_luser(int enqr_luser) {
	this.enqr_luser = enqr_luser;
}
}

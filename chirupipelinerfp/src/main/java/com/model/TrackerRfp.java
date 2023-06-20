package com.model;

public class TrackerRfp {
	
	private int enqr_id;
	private String enqr_status;
	private String rfpr_status;
	
	public int getEnqr_id() {
		return enqr_id;
	}
	public void setEnqr_id(int enqr_id) {
		this.enqr_id = enqr_id;
	}
	public String getEnqr_status() {
		return enqr_status;
	}
	public void setEnqr_status(String enqr_status) {
		this.enqr_status = enqr_status;
	}
	public String getRfpr_status() {
		return rfpr_status;
	}
	public void setRfpr_status(String rfpr_status) {
		this.rfpr_status = rfpr_status;
	}
	@Override
	public String toString() {
		return "TrackerRfp [enqr_id=" + enqr_id + ", enqr_status=" + enqr_status + ", rfpr_status=" + rfpr_status + "]";
	}
	
	

}

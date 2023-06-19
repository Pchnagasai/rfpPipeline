package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracker_enquiries_documents")
public class TrackerEnquiriesDocumentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enqd_id")
    private int enqdId;

    @Column(name = "enqr_id")
    private int enqrId;

    @Column(name = "enqd_docindex")
    private int enqdDocIndex;

    @Column(name = "enqd_documentpath")
    private String enqdDocumentPath;

    @Column(name = "enqd_desc")
    private String enqdDesc;
    
 // Constructors, getters, and setters
    // ...

	public int getEnqdId() {
		return enqdId;
	}

	public void setEnqdId(int enqdId) {
		this.enqdId = enqdId;
	}

	public int getEnqrId() {
		return enqrId;
	}

	public void setEnqrId(int enqrId) {
		this.enqrId = enqrId;
	}

	public int getEnqdDocIndex() {
		return enqdDocIndex;
	}

	public void setEnqdDocIndex(int enqdDocIndex) {
		this.enqdDocIndex = enqdDocIndex;
	}

	public String getEnqdDocumentPath() {
		return enqdDocumentPath;
	}

	public void setEnqdDocumentPath(String enqdDocumentPath) {
		this.enqdDocumentPath = enqdDocumentPath;
	}

	public String getEnqdDesc() {
		return enqdDesc;
	}

	public void setEnqdDesc(String enqdDesc) {
		this.enqdDesc = enqdDesc;
	}

    
}

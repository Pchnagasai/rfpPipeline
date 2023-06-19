package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrackerEnquiriesDocumentDAO;
import com.model.TrackerEnquiriesDocumentModel;
@Service
public class TrackerEnquiriesDocumentServiceImpl implements TrackerEnquiriesDocumentService{
	
	private TrackerEnquiriesDocumentDAO  documentDAO;
	
	 @Autowired
	    public TrackerEnquiriesDocumentServiceImpl(TrackerEnquiriesDocumentDAO documentDAO) {
	        this.documentDAO = documentDAO;
	    }

	@Override
	public void saveDocument(TrackerEnquiriesDocumentModel document) {
		// TODO Auto-generated method stub
		
		documentDAO.save(document);
		
	}

}

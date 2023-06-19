package com.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.model.TrackerEnquiriesDocumentModel;

@Repository
@Transactional
public class TrackerEnquiriesDocumentDAOImpl implements TrackerEnquiriesDocumentDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TrackerEnquiriesDocumentModel document) {
        entityManager.persist(document);
        
        // Insert the enqdDocumentPath into the database separately
        String enqdDocumentPath = document.getEnqdDocumentPath();
        String query = "INSERT INTO tracker_enquiries_documents (enqd_documentpath) VALUES (:enqdDocumentPath)";
        entityManager.createNativeQuery(query)
                .setParameter("enqdDocumentPath", enqdDocumentPath)
                .executeUpdate();
    }
}

package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.model.FileEntity;

@Component
public class ViewfileDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(FileEntity fileentity) {
		entityManager.persist(fileentity);
	}

	public List<FileEntity> viewFile() {
		return entityManager.createQuery("SELECT * FROM files ").getResultList();
	}

}

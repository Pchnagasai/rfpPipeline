package com.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ViewfileDao;
import com.model.FileEntity;

@Service
public class FileUploadService {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private ViewfileDao viewfiledao;

	@Transactional
	public void uploadFile(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			throw new IllegalArgumentException("No file uploaded");
		}

		byte[] fileBytes = file.getBytes();

		FileEntity fileEntity = new FileEntity();
		fileEntity.setName(file.getOriginalFilename());
		fileEntity.setContent(fileBytes);
		fileEntity.setSize(file.getSize());

		System.out.println(fileBytes);

		entityManager.persist(fileEntity);
	}

	@Transactional
	public void add(FileEntity fileentity) {
		viewfiledao.persist(fileentity);
	}

	@Transactional
	public void addAll(Collection<FileEntity> fileentity) {
		for (FileEntity filent : fileentity) {
			viewfiledao.persist(filent);
		}
	}

	@Transactional(readOnly = true)
	public List<FileEntity> listAll() {
		return viewfiledao.viewFile();

	}

	@Transactional(readOnly = true)
	public FileEntity getFileById(int i) {
		return entityManager.find(FileEntity.class, i);
	}

}

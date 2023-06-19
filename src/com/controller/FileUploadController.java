package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.FileEntity;
import com.service.FileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@Transactional
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> fileupload(@RequestParam("profile") CommonsMultipartFile file, HttpSession session,
			Model model) {
		try {
			fileUploadService.uploadFile(file);
			return ResponseEntity.ok("File uploaded successfully");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/getfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> getFile(HttpServletRequest request) {
		 FileEntity fileEntity = fileUploadService.getFileById(12);
		    ByteArrayResource resource = new ByteArrayResource(fileEntity.getContent());

		    // Determine the content type based on the file extension
		    String fileName = fileEntity.getName();
		    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		    MediaType contentType = MediaType.parseMediaType(getContentTypeByFileExtension(fileExtension));

		    // Check if the requested content type is acceptable
		    if (!contentType.isCompatibleWith(MediaType.parseMediaType(request.getHeader(HttpHeaders.ACCEPT)))) {
		        // Return 406 Not Acceptable if the requested content type is not compatible
		        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		    }

		    return ResponseEntity.ok()
		            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
		            .contentType(contentType)
		            .body(resource);
	}

	private String getContentTypeByFileExtension(String fileExtension) {
		if (fileExtension.equalsIgnoreCase("pdf")) {
			return MediaType.APPLICATION_PDF_VALUE;
		} else if (fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")) {
			return MediaType.IMAGE_JPEG_VALUE;
		} else if (fileExtension.equalsIgnoreCase("png")) {
			return MediaType.IMAGE_PNG_VALUE;
		}
		// Add more mappings for other file extensions as needed

		// Default content type
		return MediaType.APPLICATION_OCTET_STREAM_VALUE;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		return "view";
	}
}

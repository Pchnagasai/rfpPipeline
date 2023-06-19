package com.controller;

import com.model.TrackerEnquiriesDocumentModel;
import com.service.TrackerEnquiriesDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    private TrackerEnquiriesDocumentService documentService;

    @Autowired
    public FileUploadController(TrackerEnquiriesDocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm(Model model) {
        model.addAttribute("document", new TrackerEnquiriesDocumentModel());
        return "file-upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute("document") TrackerEnquiriesDocumentModel document,
                             @RequestParam("file") MultipartFile file) {
        // Save the file to a specific location
        if (!file.isEmpty()) {
            try {
                String uploadPath = "C:\\Users\\chiranjeevi naga sai\\eclipse-workspace\\sai\\chirufileupload\\src\\files";
                String fileName = file.getOriginalFilename();
                File saveFile = new File(uploadPath, fileName);
                file.transferTo(saveFile);
                
                // Set the document path and save to the database
                document.setEnqdDocumentPath(saveFile.getAbsolutePath());
                documentService.saveDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/upload";
    }
}

package com.microservice.myproject.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.microservice.myproject.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
public class MainController {
    
    private FileUploadService fileUploadService;
	
	@GetMapping("/")
	public String home() {
		return "Good this is the home page";
	}
	
	
	@PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(fileUploadService.FileUpload(file), HttpStatus.OK);
    }
}

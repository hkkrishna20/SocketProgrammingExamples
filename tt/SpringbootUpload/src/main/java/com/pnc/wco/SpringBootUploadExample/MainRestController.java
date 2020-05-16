package com.pnc.wco.SpringBootUploadExample;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MainRestController {

	@RequestMapping(value = { "/downloadticketpdf" }, method = RequestMethod.GET)
	public String testJspView(@RequestParam("file") String ticketName) {
		System.out.println("downloadticket"+ticketName);
		System.out.println("downloadticketpdf"+ticketName);
		return "testJsp"+ticketName;
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
	public String uploadprogressbar() {
		System.out.println("upload");
		System.out.println("uploadGET");
		return "uploadprogressbar";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public ResponseEntity<ByteArrayResource> testThymeleafView(@RequestParam("file") MultipartFile uploadedPackage) throws IOException {
		System.out.println("upload");
		System.out.println("uploadPOST");
		InputStream inputStream = new ByteArrayInputStream(uploadedPackage.getBytes());
		byte[] ImageInByte = uploadedPackage.getBytes();
		 ByteArrayResource resource = new ByteArrayResource(ImageInByte);
		 return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + uploadedPackage.getOriginalFilename().toString())
                // Content-Type
                .contentType(MediaType.APPLICATION_OCTET_STREAM) //
                // Content-Lengh
                .contentLength(ImageInByte.length) //
                .body(resource);

	}

}
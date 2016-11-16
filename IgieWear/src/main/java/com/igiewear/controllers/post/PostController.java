package com.igiewear.controllers.post;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@RequestMapping("/")
	public String receiver(String user) {
		return "Received";
	}

}

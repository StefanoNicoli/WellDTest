package com.welld.nicoli.pt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/welcome")
	String Welcome() {
		return "Hello Stefano! This is WelcomeController";
	}
}

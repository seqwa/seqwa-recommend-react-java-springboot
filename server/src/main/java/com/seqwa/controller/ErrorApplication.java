package com.seqwa.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorApplication implements ErrorController {

	@RequestMapping(value = "/error")
	public String error() {
		return "index";
	}

}

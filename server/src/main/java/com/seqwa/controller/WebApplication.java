package com.seqwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebApplication {

	@RequestMapping("/")
	public String web() {
		return "index";
	}

}
package com.ateam.gc.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping(value = "/")
	public String main() {
		return "result";
	}
}

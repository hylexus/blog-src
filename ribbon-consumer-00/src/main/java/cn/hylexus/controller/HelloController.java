package cn.hylexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	RestTemplate template;

	@GetMapping("/hello")
	String hello() {
		return this.template.getForEntity("http://USER-SERVICE/hello", String.class).getBody();
	}
}

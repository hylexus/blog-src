package cn.hylexus.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/hello")
	String hello(HttpServletRequest req) {
		logger.info("user-service service on {}:{}", req.getLocalAddr(), req.getLocalPort());
		return "hello";
	}
}

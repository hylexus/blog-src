package cn.hylexus.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author hylexus
 * createdAt 2018/7/29
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/session")
    public String sessionTest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getClass());
        return "hello";
    }

}

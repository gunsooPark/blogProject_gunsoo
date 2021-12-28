package com.gunsoo.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temp/*")
public class TempControllerTest {

	@GetMapping("/home")
	public String tempHome() {
		System.out.println("tempHome()실행");
		//파일리턴 기본경로 : src/main/resources/static
		//리턴명 : /home.html
		//풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/img")
	public String tempImg() {
		return "/testImg.jpg";
	}
	
	@GetMapping("/test")
	public String tempJsp() {
		//prefix: /WEB-INF/views/
		//suffix: .jsp
		//풀경로 : /WEB-INF/views/test.jsp
		return  "/test";
	}
	
	
	
	
}

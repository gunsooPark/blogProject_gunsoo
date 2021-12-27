package com.gunsoo.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML파일)
//@controller

//사용자가 요청 -> 응답 (Data)
@RestController
@RequestMapping("/http/*")
public class HttpControllerTest {

	//인터넷 브라우저 요청은 반드시 get요청만 할 수 있음 
	@GetMapping("/get")
	public String getTest(Member m) {
		System.out.println("member : " + m);
		return "get 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
	}

	@PostMapping("/post")
	public String postTest(@RequestBody Member m) {
		System.out.println(m);
		return "post 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
	}

	@PutMapping("/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getPassword();
	}

	@DeleteMapping("/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}

package com.gunsoo.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.dto.ResponseDto;
import com.gunsoo.blog.model.User;

@RestController
//@RequestMapping("/*")
public class UserApiController {

	
	@PostMapping("/api/user")
	public ResponseEntity<Integer>  save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출 ");
		//실제로 DB에 insert를 하고 아래에서 return이 되면된다. 
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	
	
}

package com.gunsoo.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired //의존성주입
	private UserRepository userRepository;
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);//save -> insert라고 생각하면됨 
		
		return "회원가입이 완료되었습니다";
	}
	
	
}

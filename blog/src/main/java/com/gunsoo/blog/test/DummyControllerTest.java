package com.gunsoo.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

@RestController
@RequestMapping("/dummy/*")
public class DummyControllerTest {

	@Autowired //의존성주입
	private UserRepository userRepository;
	
	//회원가입 
	@PostMapping("/join")
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);//save -> insert라고 생각하면됨 
		
		return "회원가입이 완료되었습니다";
	}
	
	
	//회원상세조회 
	@GetMapping("/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4를 찾으면 데이터베이스의 user가 null값이 된다.
		//그러면 return값이 null이 되므로, 프로그램에서 문제가 생김
		//이를 방지하기 위해 Optional로 너의 User 객체를 감싸서 가져올테니깐 null인지 아닌지 판단해서 return 해라 
		
												//select 하나 조회 -> findById
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});
		
		//요청 : 웹브라우져
		//user 객체 = 자바 오브젝트 
		//변환(웹브라우저가 이해할 수 있는 데이터) -> json
		//스프링부트 = MessageConverter가 Jackson라이브러리를 호출해서
		//user 오브젝트를 json으로 변환해서 브라우저에게 던져준다. 
		return user;
	}
	
	
	
	
	
}











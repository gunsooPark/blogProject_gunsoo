package com.gunsoo.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록해준다. 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//회원가입
	@Transactional
	public int save(User user) {
		//예외가 발생할 수 있으므로 try~catch문 사용 
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입 오류발생");
		}
		return -1;
	}//end save
	
	
	
}

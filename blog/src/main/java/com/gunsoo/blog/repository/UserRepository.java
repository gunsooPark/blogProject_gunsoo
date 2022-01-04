package com.gunsoo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gunsoo.blog.model.User;

// DAO로 생각하면 된다.
// 자동으로 bean 등록이 된다.
//@Repository //생략가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{//해당 user테이블을 관리하는 JpaRepository이다. 주키는 Integer형이다.
																//JpaRepository -> 기본적인 crud는 되어있다. 
	
	
	
	
	
	
	
	
}

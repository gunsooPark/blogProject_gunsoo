package com.gunsoo.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

@RestController
@RequestMapping("/dummy/*")
public class DummyControllerTest {

	@Autowired // 의존성주입
	private UserRepository userRepository;

	// 회원가입
	@PostMapping("/join")
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());

		user.setRole(RoleType.USER);
		userRepository.save(user);// save -> insert라고 생각하면됨

		return "회원가입이 완료되었습니다";
	}

	// 회원상세조회
	@GetMapping("/user/{id}")
	public User detail(@PathVariable int id) {
		// user/4를 찾으면 데이터베이스의 user가 null값이 된다.
		// 그러면 return값이 null이 되므로, 프로그램에서 문제가 생김
		// 이를 방지하기 위해 Optional로 너의 User 객체를 감싸서 가져올테니깐 null인지 아닌지 판단해서 return 해라

		// select 하나 조회 -> findById
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});

		// 요청 : 웹브라우져
		// user 객체 = 자바 오브젝트
		// 변환(웹브라우저가 이해할 수 있는 데이터) -> json
		// 스프링부트 = MessageConverter가 Jackson라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.
		return user;
	}

	// 회원전체 조회
	@GetMapping("/users")
	public List<User> list() {
		// findAll -> 전체 select
		List<User> list = userRepository.findAll();
		return list;
	}

	// 한페이지당 2건에 데이터를 리턴받아 볼 예정
	@GetMapping("/user")
	public List<User> pageList(
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);

		List<User> users = pagingUser.getContent();

		return users;
	}

	//save함수는 id를 전달하지 않으면 insert를 함 
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update해줌 
	// 업데이트
	@Transactional //함수 종료시에 자동으로 commit이 된다. 
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id : " + id);
		System.out.println("email : " + requestUser.getEmail());
		System.out.println("password : " + requestUser.getPassword());

		// 업데이트
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저는 없습니다.");
		});

		user.setEmail(requestUser.getEmail());
		user.setPassword(requestUser.getPassword());

		//userRepository.save(user);
		// -> save를 하지 않고 위에 @Transactional를 하면 업데이트가 된다. 
		
		
		//더디 체킹 
		return user;
	}

	//회원 삭제 
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		
		//해당 아이디가 없을 수 있으므로 try~catch문으로 예외를 걸어야됨 
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다";
		}
		
		
		return "삭제되었습니다.";
	}

	
	
	
	
	
	
}

package com.gunsoo.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id //주키 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100) //not null, 길이 100자 
	private String title; //제목
	
	@Lob //대용량 데이터 
	private String content; //내용 => 섬머노트 라이브러리를 사용해서 길이가 굉장히 김
	
	@ColumnDefault("0")//int 형이기 때문에 ''가 필요없음 
	private int count;//조회수 
	
	@ManyToOne // Many -> Board, User -> One  
	@JoinColumn(name = "userId") //컬럼명을 userId로 한다. 
	private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다. -> 즉 JPA는 객체를 저장할 수 있다. 
	
	@CreationTimestamp//현재시간이 자동으로 입력됨 
	private Timestamp creaTimestamp;//생성날짜 
	
}









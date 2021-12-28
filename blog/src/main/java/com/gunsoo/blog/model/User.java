package com.gunsoo.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity //User 클래스가 MySQL에 테이블이 생성이 된다. 
public class User {

	@Id //Primary key
	@GeneratedValue(strategy =  GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. 
	private int id; //시퀀스-오라클, auto_increment-Mysql
	
	@Column(nullable = false, length = 30)//not null, 길이 30
	private String username; //아아디
	
	@Column(nullable = false, length = 100)//not null, 길이 100
	private String password; //비밀번호
	
	@Column(nullable = false, length = 50)//not null, 길이 50
	private String email; //이메일
	
	@ColumnDefault("'user'") //default값 
	private String role; //Enum을 쓰는게 좋음. //admin, user, manager //권한부여
	
	@CreationTimestamp // 시간이 자동 입력 
	private Timestamp createDate; //가입시 시간 
}

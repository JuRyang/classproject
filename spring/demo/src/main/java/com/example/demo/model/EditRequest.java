package com.example.demo.model;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class EditRequest {
	
	private int idx;  // 인덱스
	private String title; //제목
	private String contents; //내용
	private String writer; //작성자

	
	
}
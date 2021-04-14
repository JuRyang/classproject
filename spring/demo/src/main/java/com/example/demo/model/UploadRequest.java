package com.example.demo.model;

import lombok.Data;

@Data
public class UploadRequest {
	
	private int idx;  // 인덱스
	private String title; //제목
	private String contents; //내용
	private String writer; //작성자

	
	
}
package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Board {
	
	private int idx;  // 인덱스
	private String title; //제목
	private String contents; //내용
	private String writer; //작성자
	private Timestamp  date; //작성일
	private String delete; //삭제
	private String update; //수정
	private Timestamp  updateTime; //수정일
	
	private List<Board> BoardList; // 리스트



	

	
}
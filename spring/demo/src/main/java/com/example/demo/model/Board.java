package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class Board {
	
	private int idx;  // 인덱스
	@NonNull
	private String title; //제목
	@NonNull
	private String contents; //내용
	@NonNull
	private String writer; //작성자
	private Timestamp  date; //작성일
	private Timestamp  updatetime; //수정일
	
	private int cidx; //댓글 인덱스
	
	private String content; //댓글내용 
	
	private Timestamp reg_date; //댓글 작성 날짜
	
	
	
	private List<Board> BoardList; // 리스트



	

	
}
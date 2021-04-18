package com.example.demo.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Comment {

	private int cidx; //댓글 인덱스
	private int idx; //댓글이 달린 게시글 인덱스
	private String content; //댓글내용 
	private String writer; //작성자
	private Timestamp reg_date; //댓글 작성 날짜

}

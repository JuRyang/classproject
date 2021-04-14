package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;
import com.example.demo.model.UploadRequest;

@Service
public class BoardUploadService {
/*	
	private BoardMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int uploadService(HttpServletRequest req, Board board) {
		
		System.out.println(req);
		
		int result = 0;
		
		try {					
		dao = template.getMapper(BoardMapper.class);
		result = dao.boardinsert(req, board);
		
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return result;
	}

*/
}
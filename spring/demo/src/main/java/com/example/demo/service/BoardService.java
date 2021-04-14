package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;
import com.example.demo.model.UploadRequest;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	private int idx;

	public int test() {
		return boardMapper.test();
	}

	public Board getBoard() {
		return boardMapper.getBoard();
	}

	// 글쓰기
	/*
	 * public int writetBoard(int idx, Board board) {
	 * 
	 * 
	 * board.setIdx(idx); return boardMapper.boardinsert(board); }
	 */
	
	// 글쓰기
	public int writetBoard(UploadRequest upload) {
		return boardMapper.boardinsert(upload);
	}

	// 글 삭제
	public int deleteBoard(int idx) {
		return boardMapper.deleteBoard(idx);

	}

	// 글 수정
	public int updateBoard(int idx, Board board) {
		return boardMapper.updateBoard(board);
	}

	// 글 리스트
	public List<Board> getBoardList() {
		return boardMapper.selectAllBoardList();

	}

	// 한 게시물
	public Board getBoardDetail(int idx) {

		return boardMapper.selectBoardDetail(idx);
	}

}

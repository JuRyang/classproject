package com.example.demo.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Board;
import com.example.demo.model.UploadRequest;


@Mapper
public interface BoardMapper {

	public int test();

	public Board getBoard();

	/*
	 * //글 등록 int insertBoard(Board board);
	 * 
	 * 
	 * //글 수정 public int updateBoard(Board board);
	 * 
	 * 
	 * //글 리스트 public List<Board> selectBoardList();
	 * 
	 * //삭제 public int deleteBoard(int idx);
	 */

	// 게시물 저장
	int boardinsert(UploadRequest upload);

	// 전체 리스트 출력
	List<Board> selectAllBoardList();

	// 한 개의 게시물 출력
	Board selectBoardDetail(int idx);

	// 게시물 수정
	int updateBoard(Board board);

	// 게시글 삭제
	int deleteBoard(int idx);
	
	

	
	
}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;

@Service	
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;
    
    public List<Comment> commentListService() throws Exception  {
        
        return commentMapper.commentList();
    }
    
    //댓글작성
    public int commentInsertService(Comment comment) throws Exception  {
        
        return commentMapper.commentInsert(comment);
    }
    
    public int commentUpdateService(Comment comment) throws Exception  {
        
        return commentMapper.commentUpdate(comment);
    }
    
    public int commentDeleteService(int cidx) throws Exception  {
        
        return commentMapper.commentDelete(cidx);
    }



}

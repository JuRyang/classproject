package com.example.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/list") // 댓글 리스트
	@ResponseBody
	private List<Comment> CommentServiceList( Model model) throws Exception {

		return commentService.commentListService();
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public ModelAndView CommentServiceList(@RequestParam int idx,HttpServletRequest req, HttpServletResponse res) throws Exception {		
//		ModelAndView mav = new ModelAndView("view/main/detailView");		
//		List<Comment> s = commentService.commentListService(); 
//		mav.addObject("commentService",s);
//		return mav;
//	} 

//	@RequestMapping("/insert") // 댓글 작성
//	@ResponseBody
//	private String CommentServiceInsert(@RequestParam (value = "idx", required = false)  int cidx,   Comment comment)  throws Exception {
//
//
//		return "view/board/write";
//	}
	
    @RequestMapping("/insert") //댓글 작성 
    @ResponseBody
    private int CommentServiceInsert(@RequestParam int idx, @RequestParam String content) throws Exception{
        
        Comment comment = new Comment();
        comment.setIdx(idx);
        comment.setContent(content);
        //로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 됩니다. 저는 따로 폼을 구현하지 않았기때문에 임시로 "test"라는 값을 입력해놨습니다.
        comment.setWriter("test");  
        
        return commentService.commentInsertService(comment);
    }




	@RequestMapping("/update") // 댓글 수정
	@ResponseBody
	private int CommentServiceUpdateProc(@RequestParam (value = "cidx", required = false)  int cidx,   Comment comment) throws Exception {


		return commentService.commentUpdateService(comment);
	}

	@RequestMapping("/delete/{cidx}") // 댓글 삭제
	@ResponseBody
	private int CommentServiceDelete(@PathVariable int cidx) throws Exception {

		return commentService.commentDeleteService(cidx);
	}

}
package com.example.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Board;
import com.example.demo.model.UploadRequest;
import com.example.demo.service.BoardService;
import com.example.demo.service.BoardUploadService;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService listService;

	/*
	 * // 게시판에 업로드
	 * 
	 * @RequestMapping(value="/upload") public String boardUpload( UploadRequest
	 * request, Model model) {
	 * 
	 * int result = uploadService.uploadService(request);
	 * 
	 * model.addAttribute("result", result);
	 * 
	 * return "board/result"; }
	 * 
	 */
	/*
	 * // 게시판에 업로드
	 * 
	 * @RequestMapping(value = "/write", method = RequestMethod.GET) public
	 * ModelAndView boardUpload(Board board, HttpServletRequest req,
	 * HttpServletResponse res) throws Exception {
	 * 
	 * ModelAndView mav = new ModelAndView("view/board/write"); int result =
	 * listService.writetBoard(board);
	 * 
	 * return mav; }
	 */

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardUpload() {

		return "view/board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeResult(UploadRequest upload) {

		System.out.println(upload);

		int result = listService.writetBoard(upload);
		System.out.println("완료");
		System.out.println(result);

		
		return "redirect:/board/index";
	}

	// 게시판 리스트 출력
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ModelAndView mav = new ModelAndView("view/board/index");
		List<Board> boardList = listService.getBoardList();
		mav.addObject("boardList", boardList);
		System.out.println(boardList);
		
		mav.setViewName("view/board/index");

		return mav;
	}

//		//게시물 업로드s
//		@RequestMapping(value = "/test")
//		public ModelAndView index2(HttpServletRequest req, HttpServletResponse res) throws Exception {		
//			ModelAndView mav = new ModelAndView("view/main/test");		
//			Board s = boardService.getBoard(); 
//			mav.addObject("board",s);
//			return mav;
//		} 

	// 게시판에서 해당idx와 일치하는 게시물 하나만 출력
//	@RequestMapping(value = "/detailView/{idx}", method = RequestMethod.GET)
//	public String getBoardDetail(@PathVariable("idx") int idx, Model model) {
//
//		Board board = listService.getBoardDetail(idx);
//
//		model.addAttribute("board", board);
//
//		return "board/detailView";
//	}
	
	@RequestMapping(value = "/detailView", method = RequestMethod.GET)
	public String getBoardDetail(@RequestParam(value = "idx", required = false)  int idx, Model model) {

		Board board = listService.getBoardDetail(idx);

		model.addAttribute("board", board);

		return "view/board/detailView";
	}
	
	

	// 게시글 수정
	@RequestMapping(value = "/edit/{idx}", method = RequestMethod.POST)
	public String boardEdit(@PathVariable("idx") int idx, Board board, Model model) {

		int result = listService.updateBoard(idx, board);

		model.addAttribute("result", result);

		return "board/result";
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam(value = "idx") int idx) {

		int result = listService.deleteBoard(idx);


		return "redirect:/board/index";
	}

}

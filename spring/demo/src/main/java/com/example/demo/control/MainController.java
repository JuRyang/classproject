package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.BoardService;
import com.example.demo.service.BoardUploadService;


@Controller
public class MainController {

	//private final Log log = LogFactory.getLog(MainController.class);
	
	@Autowired
	private BoardUploadService uploadService;
	@Autowired
	private BoardService listService;
	
	/*
	 * // 게시판 리스트 출력
	 * 
	 * @GetMapping("/home") public String getBoardList(Model model) {
	 * 
	 * List<Board> boardList = listService.getBoardList();
	 * 
	 * model.addAttribute("boardList", boardList);
	 * 
	 * return "home"; }
	 */
	
	
	
//	@RequestMapping(value = "/list")
//	public ModelAndView index(HttpServletRequest req, HttpServletResponse res) throws Exception {		
//		ModelAndView mav = new ModelAndView("view/main/list");
//		return mav;
//	}
//	
//	
//	//게시물 업로드s
//	@RequestMapping(value = "/test")
//	public ModelAndView index2(HttpServletRequest req, HttpServletResponse res) throws Exception {		
//		ModelAndView mav = new ModelAndView("view/main/test");		
//		Board s = boardService.getBoard(); 
//		mav.addObject("board",s);
//		return mav;
//	} 
//	
//
//	/*
//	//리스트 출력
//	@RequestMapping(value = "/test")
//	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws Exception {		
//		ModelAndView mav = new ModelAndView("view/main/list");		
//		Board s = boardService.getBoard(); 
//		mav.addObject("board",s);
//		return mav;
//	}
//	*/
//	
//	
//	
///*	@RequestMapping(value = "/test")
//	public ModelAndView editBoard(HttpServletRequest req, HttpServletResponse res) throws Exception {
//
//		
//		//Service -> MemberDao: update ->mapper ->int
//				
//		//System.out.println(editRequest);
//		ModelAndView mav = new ModelAndView("view/main/test");	
//		
//		mav.addAttribute("result",boardService.editBoard(boardService, req));
//		
//		return mav;
//	}
//	*/
//	
//	
//	//게시물 업로드
//		@RequestMapping(value = "/uploadForm")
//		public ModelAndView  boardUpload(HttpServletRequest req, HttpServletResponse res) throws Exception {		
//			ModelAndView mav = new ModelAndView("view/main/uploadForm");		
//			Board s = boardService.getBoard(); 
//			mav.addObject("board",s);
//			return mav;
//		}
//	
//
//		
//	// 게시판 리스트 출력
//		@RequestMapping("/list")
//		public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
//			
//			ModelAndView mav = new ModelAndView("view/main/list");
//			List<Board> list = boardService.getBoardList();
//			
//			mav.addObject("list",list);
//			
//			return mav;
//		}
//		
//		// 게시글 수정
//		@PostMapping("/edit/{idx}")
//		public String updateBoard(
//				@PathVariable("idx") int idx,
//				Board board,
//				Model model) {
//					
//			int result = boardService.updateBoard(idx, board);
//			
//			model.addAttribute("result", result);
//			
//			return "main/result";
//		}
//		
//		// 게시물 삭제
//		@GetMapping("/board/delete/{idx}")
//		public String boardDelete(
//				@PathVariable("idx") int idx,
//				Model model) {
//			
//			int result = boardService.deleteBoard(idx);
//			
//			model.addAttribute("result", result);
//			
//			return "board/result";
//		}

}
package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import com.example.demo.service.BoardUploadService;

@Controller
public class ViewControlle {
	
	@Autowired
	private BoardUploadService uploadService;
	@Autowired
	private BoardService listService;
	
	// 업로드 폼으로 이동
	@GetMapping("/board/uploadForm")
	public String goToUpload() {
			
		return "board/uploadForm";
	}
			
	// 수정 폼으로 이동	
	@GetMapping("board/edit/{idx}")
	public String goEditForm(
			@PathVariable("idx") int idx,
			Model model) {
		
		Board oldData = listService.getBoardDetail(idx);
		
		model.addAttribute("oldData", oldData);
		
		return "board/edit";

}
}
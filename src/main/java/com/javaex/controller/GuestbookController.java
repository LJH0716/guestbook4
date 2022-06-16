package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("Controller > addList");
		
		//dao만들기
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> guestList = dao.getPersonList();
		
		model.addAttribute("guestList", guestList);
		
		return "addList";
	}

	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("Controller > add");
		
		//dao만들기
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.insert(guestbookVo);
		
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("Controller>deleteForm()");
		
		return "deleteForm";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no, 
			             @RequestParam("password") String password) {
		System.out.println("Controller>delete()");
		
		//파라미터 꺼내기
		System.out.println(no);
		System.out.println(password);
		
		//vo에 no,password담기
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		//Dao로 처리하기(삭제)
		int count = guestbookService.delete(no);
		
		
		return "redirect:/addList";
	}
		
}
	
	
	
	
	
	

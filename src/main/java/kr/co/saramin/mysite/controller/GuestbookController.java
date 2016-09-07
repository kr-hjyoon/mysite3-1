package kr.co.saramin.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.vo.GuestbookVo;

@Controller
@RequestMapping( value={"/guestbook", "/gb"} )
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping( "" )
	public String index( Model model ) {
		List<GuestbookVo> list = guestbookService.getMessageList();
		model.addAttribute( "list", list );
		return "guestbook/list";
	}
	
	@RequestMapping( "/deleteform/{no}" )
	public String deletefrom( @PathVariable( "no" ) Long no, Model model ) {
		model.addAttribute( "no", no );
		return "guestbook/deleteform";
	}

	@RequestMapping( "/delete" )
	public String delete( @ModelAttribute GuestbookVo vo ) {
		guestbookService.deleteMessage(vo);
		return "redirect:/guestbook";
	}

	@RequestMapping( "/insert" )
	public String insert( @ModelAttribute GuestbookVo vo ) {
		guestbookService.insertMessage(vo);
		return "redirect:/guestbook";
	}


}

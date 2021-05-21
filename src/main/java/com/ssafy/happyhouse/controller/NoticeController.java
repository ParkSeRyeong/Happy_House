package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "notice/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(NoticeDto noticeDto, Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			//noticeDto.setWriter(memberDto.getId());
			try {
				noticeService.noticeWrite(noticeDto);
				return "notice/writesuccess";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "글 작성 중 문제가 발생했습니다.");
				return "error/error";
			}
		} else {
			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam Map<String, String> map, Model model) {
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "10");//sizePerPage
		try {
			List<NoticeDto> list = noticeService.noticeList(map);
			PageNavigation pageNavigation = noticeService.makePageNavigation(map);
			model.addAttribute("notices", list);
			model.addAttribute("navigation", pageNavigation);
			return "notice/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam("no") int no, Model model) {
		try {
			NoticeDto noticeDto = noticeService.noticeView(no);
			model.addAttribute("notice", noticeDto);
			return "notice/modify";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 수정 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(NoticeDto noticeDto, Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			//noticeDto.setWriter(memberDto.getId());
			try {
				noticeService.noticeModify(noticeDto);
				return "notice/writesuccess";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "글 수정 중 문제가 발생했습니다.");
				return "error/error";
			}
		} else {
			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no, Model model) {
		try {
			noticeService.noticeDelete(no);
			return "redirect:list?pg=1&key=&word=";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	
}

package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notice")
@Api("Notice Controller API V1")
@CrossOrigin("*")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@ApiOperation(value = "공지사항 화면으로 이동")
	@GetMapping(value = "/list")
	public ModelAndView housemap() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/noticeList");
		List<NoticeDto> notices = noticeService.noticeList();
		mav.addObject("notices", notices);
		return mav;
	}
	
//	@ApiOperation(value = "공지사항 화면으로 이동 후, 공지사항 리스트 화면에 출력")
//	@GetMapping(value = "/noticeList")
//	public ResponseEntity<List<NoticeDto>> listNotice() throws Exception {
//		logger.debug("listNotice - 호출");
//		return new ResponseEntity<>(noticeService.noticeList(), HttpStatus.OK);
//	}
//	
	
	@ApiOperation(value = "공지사항 등록 화면으로 이동")
	@GetMapping(value = "/write")
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/noticeWrite");
		return mav;
	}
	
//	@PostMapping(value = "/write")
//	public String write(NoticeDto noticeDto, Model model, HttpSession session) {
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if(memberDto != null) {
//			//noticeDto.setWriter(memberDto.getId());
//			try {
//				noticeService.noticeWrite(noticeDto);
//				return "notice/writesuccess";
//			} catch (Exception e) {
//				e.printStackTrace();
//				model.addAttribute("msg", "글 작성 중 문제가 발생했습니다.");
//				return "error/error";
//			}
//		} else {
//			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
//			return "error/error";
//		}
//	}
	
//	@GetMapping(value = "/list")
//	public String list(@RequestParam Map<String, String> map, Model model) {
//		String spp = map.get("spp");
//		map.put("spp", spp != null ? spp : "10");//sizePerPage
//		try {
//			List<NoticeDto> list = noticeService.noticeList(map);
//			PageNavigation pageNavigation = noticeService.makePageNavigation(map);
//			model.addAttribute("notices", list);
//			model.addAttribute("navigation", pageNavigation);
//			return "notice/list";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "글 목록을 얻어오는 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//	}
	
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

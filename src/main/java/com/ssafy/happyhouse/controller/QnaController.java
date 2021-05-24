package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/qna")
@Api("QnA Controller API V1")
@CrossOrigin("*")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@ApiOperation(value = "로그인 화면으로 이동")
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
        mav.setViewName("user/login");
        return mav;
	}

	@ApiOperation(value = "유저 로그인.", response = MemberDto.class)
	@PostMapping("/login")
	public ResponseEntity<MemberDto> login(@RequestBody Map<String, String> loginInfo, HttpServletResponse response) {
		logger.debug("login 정보 - " + loginInfo);
		try {
			MemberDto user = userService.login(loginInfo);

			// 로그인에 성공했다면 토큰을 만듭시당.
			String token = jwtService.create(user);

			// 토큰 정보는 request의 헤더로 보내자
			response.setHeader("jwt-auth-token", token);

			return new ResponseEntity<MemberDto>(user, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "회원가입", response = MemberDto.class)
	@PostMapping("/regist")
	public ResponseEntity<MemberDto> register(@RequestBody MemberDto memberDto) {
		try {
			logger.debug("회원가입 : " + memberDto);
			int n = userService.userRegister(memberDto);
			
			if (n > 0) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		logger.debug("로그아웃");
		// 로그아웃 기능 구현...jwt로...
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

}
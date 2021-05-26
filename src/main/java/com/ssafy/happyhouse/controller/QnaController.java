package com.ssafy.happyhouse.controller;

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

//	@ApiOperation(value = "유저 로그인.", response = MemberDto.class)
//	@PostMapping("/login")
//	public ResponseEntity<MemberDto> login(@RequestBody Map<String, String> loginInfo, HttpServletResponse response) {
//		logger.debug("login 정보 - " + loginInfo);
//		try {
//			
//
//			// 로그인에 성공했다면 토큰을 만듭시당.
//			
//
//			// 토큰 정보는 request의 헤더로 보내자
//			response.setHeader("jwt-auth-token", token);
//
//			return new ResponseEntity<MemberDto>(user, HttpStatus.OK);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//	}

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


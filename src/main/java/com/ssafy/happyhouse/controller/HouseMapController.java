package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//안나옴
@RestController
@RequestMapping("/map")
@Api("House Controller API V1")
@CrossOrigin("*")
public class HouseMapController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	HouseMapService houseMapService;

	@Autowired
	public HouseMapController(HouseMapService houseMapService) {
		super();
		this.houseMapService = houseMapService;
	}

	@ApiOperation(value = "주택 거래가 검색 화면으로 이동")
	@GetMapping(value = "/housemap")
	public ModelAndView housemap() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("house/housemap");
		return mav;
	}

	@ApiOperation(value = "시도 리스트 반환")
	@GetMapping(value = "/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido(Model model) throws Exception {
		List<SidoGugunCodeDto> sido = houseMapService.getSido();
		try {
			return new ResponseEntity<List<SidoGugunCodeDto>>(sido, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "시도 선택 후 구군 리스트 반환")
	@GetMapping(value = "/gugun/{sido}")
	public ResponseEntity<List<Map<String, String>>> gugun(@PathVariable("sido") String sido) throws Exception {
		logger.debug("시도 : " + sido);
		try {
			List<Map<String, String>> gugun = houseMapService.getGugunInSido(sido);
			return new ResponseEntity<List<Map<String, String>>>(gugun, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "구군 선택 후 동 리스트 반환")
	@GetMapping(value = "/dong/{gugun}")
	public ResponseEntity<List<HouseDto>> dong(@PathVariable("gugun") String gugun) throws Exception {
		logger.debug("구군 : " + gugun);
		try {
			List<HouseDto> dong = houseMapService.getDongInGugun(gugun);
			return new ResponseEntity<List<HouseDto>>(dong, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "선택한 동 지도에서 확대")
	@GetMapping(value = "/donginfo/{dong}")
	public ResponseEntity<DongInfoDto> getDongInfo(@PathVariable("dong") String dong) throws IOException {
		logger.debug("동 : " + dong);
		DongInfoDto donginfo = houseMapService.getDongInfo(dong);
		try {
			return new ResponseEntity<DongInfoDto>(donginfo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} 
		
	}
	
	@ApiOperation(value = "시군구동 선택 후 해당 아파트 리스트 반환")
	@GetMapping(value = "/apt/{dong}")
	public ResponseEntity<List<HouseDto>> apt(@PathVariable("dong") String dong) throws Exception {
		logger.debug("동 : " + dong);
		List<HouseDto> apt = houseMapService.getAptInDong(dong);
		logger.debug("아파트 리스트:" + " " + apt);
		try {
			return new ResponseEntity<List<HouseDto>>(apt, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}


	@ApiOperation(value = "시군구동 선택 후 해당 아파트 리스트 화면에 표시")
	@GetMapping(value = "/dealInfo/{dong}/{aptName}")
	public ResponseEntity<List<HouseDto>> getDealInfo(@PathVariable("dong") String dong, @PathVariable("aptName") String aptName) throws Exception {
		System.out.println(dong+" "+aptName);
		List<HouseDto> aptList = houseMapService.getApt(dong,aptName);
		try {
			return new ResponseEntity<List<HouseDto>>(aptList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} 
	}

}
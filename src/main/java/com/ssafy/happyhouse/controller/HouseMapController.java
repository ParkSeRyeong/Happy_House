package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//안나옴
@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {
	
	HouseMapService houseMapService;
	
	@Autowired
	public HouseMapController(HouseMapService houseMapService) {
		super();
		this.houseMapService = houseMapService;
	}
	
	@GetMapping(value = "/housemap")
	public ModelAndView housemap() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("house/housemap");
		return mav;
	}
	
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
	
	@GetMapping(value = "/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@PathVariable("sido") String sido) throws Exception {
//		String sido = request.getParameter("sido");
//		PrintWriter out = response.getWriter();
//		List<SidoGugunCodeDto> list = null;
//		JSONArray arr = new JSONArray();
		//sido = sido.substring(0, 2);
		System.out.println("HouseController_Rest : gugun / " + sido);
		try {
			List<SidoGugunCodeDto> gugun = houseMapService.getGugunInSido(sido);
			return new ResponseEntity<List<SidoGugunCodeDto>>(gugun, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} 
	}
	
	@GetMapping(value = "/dong/{gugun}")
	public  ResponseEntity<List<HouseInfoDto>> dong(@PathVariable("gugun") String gugun) throws Exception {
//		String gugun = request.getParameter("gugun");
//		PrintWriter out = response.getWriter();
//		List<HouseInfoDto> list = null;
//		JSONArray arr = new JSONArray();
		List<HouseInfoDto> dong = houseMapService.getDongInGugun(gugun);
		try {
			return new ResponseEntity<List<HouseInfoDto>>(dong, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/apt")
	public  ResponseEntity<List<HouseInfoDto>> apt(@PathVariable("dong") String dong) throws Exception {
//		String dong = request.getParameter("dong");
//		PrintWriter out = response.getWriter();
//		List<HouseInfoDto> list = null;
//		JSONArray arr = new JSONArray();
		List<HouseInfoDto> apt = houseMapService.getAptInDong(dong);
		try {
//			for(HouseInfoDto dto : list) {
//				JSONObject obj = new JSONObject();
//				obj.put("no", dto.getNo());
//				obj.put("dong", dto.getDong());
//				obj.put("aptName", dto.getAptName());
//				obj.put("code", dto.getCode());
//				obj.put("buildYear", dto.getBuildYear());
//				obj.put("jibun", dto.getJibun());
//				obj.put("lat", dto.getLat());
//				obj.put("lng", dto.getLng());
//				arr.add(obj);
//			}
			return new ResponseEntity<List<HouseInfoDto>>(apt, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} 
	}
	
//	@RequestMapping(value = "/donginfo", method = RequestMethod.GET)
//	public String getDongInfo(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String dong = request.getParameter("dong");
//		PrintWriter out = response.getWriter();
//		JSONObject obj = null;
//		try {
//			DongInfoDto dto = new DongInfoDto();
//			dto = houseMapService.getDongInfo(dong); 
//				obj = new JSONObject();
//				obj.put("lat", dto.getLat());
//				obj.put("lng", dto.getLng());
//		} catch (Exception e) {
//			obj = new JSONObject();
//			obj.put("message_code", "-1");
//			e.printStackTrace();
//		} finally {
//			out.print(obj.toString());
//			out.close();
//		}
//		
//		return "house/housemap";
//	}
//	
//	@RequestMapping(value = "/dealInfo", method = RequestMethod.GET)
//	public String getDealInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String dong = request.getParameter("dong");
//		String aptName = request.getParameter("aptName");
//		PrintWriter out = response.getWriter();
//		List<HouseDealDto> list = null;
//		JSONArray arr = new JSONArray();
//		
//		System.out.println(dong);
//		System.out.println(aptName);
//		
//		try {
//			list = houseMapService.getApt(dong, aptName);
//			for(HouseDealDto dto : list) {
//				JSONObject obj = new JSONObject();
//				obj.put("no", dto.getNo());
//				obj.put("dong", dto.getDong());
//				obj.put("aptName", dto.getAptName());
//				obj.put("dealAmount", dto.getDealAmount());
//				obj.put("dealYear", dto.getDealYear());
//				obj.put("dealMonth", dto.getDealMonth());
//				obj.put("dealDay", dto.getDealDay());
//				obj.put("area", dto.getArea());
//				obj.put("floor", dto.getFloor());
//				obj.put("jibun", dto.getJibun());
//				arr.add(obj);
//			}
//
//		} catch (Exception e) {
//			arr = new JSONArray();
//			JSONObject obj = new JSONObject();
//			obj.put("message_code", "-1");
//			arr.add(obj);
//			e.printStackTrace();
//		} finally {
//			out.print(arr.toString());
//			out.close();
//		}
//		System.out.println("aa");
//		return "index";
//	}
	

}
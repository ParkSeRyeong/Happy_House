package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;


public interface HouseMapService {
	
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<Map<String, String>> getGugunInSido(String sido) throws Exception;
	List<HouseDto> getDongInGugun(String gugun) throws Exception;
	List<HouseDto> getApt(String dong) throws Exception;
	List<HouseDto> getAptDetail(String dong, String aptName) throws Exception;
	DongInfoDto getDongInfo(String dong);
}

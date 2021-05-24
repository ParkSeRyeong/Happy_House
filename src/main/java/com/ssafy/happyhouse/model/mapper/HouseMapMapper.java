package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {
	public List<SidoGugunCodeDto> getSido() throws SQLException;
	public List<Map<String, String>> getGugunInSido(String sido) throws SQLException;
	public List<HouseDto> getDongInGugun(String gugun) throws SQLException;
	public List<HouseDto> getAptInDong(String dong) throws SQLException;
	public List<HouseDto> getApt(String dong, String aptName) throws SQLException;
	public DongInfoDto getDongInfo(String dong);
}

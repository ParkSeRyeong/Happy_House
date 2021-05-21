package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {
	public List<SidoGugunCodeDto> getSido() throws SQLException;
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	public List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	public List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	public List<HouseDealDto> getApt(String dong, String aptName) throws SQLException;
	public DongInfoDto getDongInfo(String dong);
}

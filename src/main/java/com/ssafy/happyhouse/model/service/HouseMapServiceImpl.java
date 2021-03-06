package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.DongInfoDto;
import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getSido();
	}

	@Override
	public List<Map<String,String>> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
	}

	@Override
	public List<HouseDto> getApt(String dong) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getApt(dong);
	}
	
	@Override
	public List<HouseDto> getAptDetail(String dong, String aptName) throws Exception{
		return sqlSession.getMapper(HouseMapMapper.class).getAptDetail(dong, aptName);
	}

	@Override
	public DongInfoDto getDongInfo(String dong) {
		return sqlSession.getMapper(HouseMapMapper.class).getDongInfo(dong);
	}

}

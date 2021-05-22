package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;
import com.ssafy.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {
	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void noticeWrite(NoticeDto noticeDto) throws Exception {
//		if (noticeDto.getWriter() == null || noticeDto.getTitle() == null || noticeDto.getContent() == null) {
//			throw new Exception();
//		}
		sqlSession.getMapper(NoticeMapper.class).noticeWrite(noticeDto);
	}

	@Override
	public List<NoticeDto> noticeList() throws Exception {
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("key", map.get("key") == null ? "" : map.get("key"));
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int currentPage = Integer.parseInt(map.get("pg"));
//		int sizePerPage = Integer.parseInt(map.get("spp"));
//		int start = (currentPage - 1) * sizePerPage;
//		param.put("start", start);
//		param.put("spp", sizePerPage);
//		return sqlSession.getMapper(NoticeMapper.class).noticeList(param);
		return sqlSession.getMapper(NoticeMapper.class).noticeList();
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public NoticeDto noticeView(int no) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).noticeView(no);
	}

	@Override
	public void noticeModify(NoticeDto noticeDto) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).noticeModify(noticeDto);
	}

	@Override
	public void noticeDelete(int no) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).noticeDelete(no);
	}

}

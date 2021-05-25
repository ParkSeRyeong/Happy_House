package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.util.PageNavigation;

@Mapper
public interface BoardMapper {
//	public boolean noticeWrite(BoardDto noticeDto) throws SQLException;
//	public List<BoardDto> noticeList() throws SQLException;
//	public int getTotalCount(Map<String, String> map) throws SQLException;
//
//	public BoardDto noticeView(int no) throws SQLException;
//	public void noticeModify(BoardDto noticeDto) throws SQLException;
//	public void noticeDelete(int no) throws SQLException;
	
	List<BoardDto> list();

	BoardDto search(int no);

	int create(BoardDto boardDto);

	int modify(BoardDto boardDto);

	int delete(int no);
}

package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.util.PageNavigation;

public interface NoticeMapper {
	public boolean noticeWrite(NoticeDto noticeDto) throws SQLException;
	public List<NoticeDto> noticeList() throws SQLException;
	public int getTotalCount(Map<String, String> map) throws SQLException;

	public NoticeDto noticeView(int no) throws SQLException;
	public void noticeModify(NoticeDto noticeDto) throws SQLException;
	public void noticeDelete(int no) throws SQLException;
}

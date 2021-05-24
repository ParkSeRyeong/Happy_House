package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.util.PageNavigation;

public interface NoticeService {

	public boolean noticeWrite(NoticeDto noticeDto) throws Exception;
	public List<NoticeDto> noticeList() throws Exception;
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

	public NoticeDto noticeView(int no) throws Exception;
	public void noticeModify(NoticeDto noticeDto) throws Exception;
	public void noticeDelete(int no) throws Exception;
}

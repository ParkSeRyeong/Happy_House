package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;
import com.ssafy.happyhouse.model.mapper.FaqMapper;

@Service
public class FaqServiceImpl implements FaqService {
	
    @Autowired
	private FaqMapper faqMapper;

    @Override
	public List<BoardDto> list() {
		return faqMapper.list();
	}
    
  	@Override
	public BoardDto search(int no) {
  		return faqMapper.search(no);
	}

	@Override
	public boolean create(BoardDto boardDto) {
		return faqMapper.create(boardDto)==1;
	}

	@Override
	@Transactional
	public boolean modify(BoardDto boardDto) {
		return faqMapper.modify(boardDto)==1;
	}

	@Override
	@Transactional
	public boolean delete(int no) {
		return faqMapper.delete(no)==1;
	}
}
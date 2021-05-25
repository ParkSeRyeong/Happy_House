package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardMapper boardMapper;

    @Override
	public List<BoardDto> list() {
		return boardMapper.list();
	}
    
  	@Override
	public BoardDto search(int no) {
  		return boardMapper.search(no);
	}

	@Override
	public boolean create(BoardDto boardDto) {
		return boardMapper.create(boardDto)==1;
	}

	@Override
	@Transactional
	public boolean modify(BoardDto boardDto) {
		return boardMapper.modify(boardDto)==1;
	}

	@Override
	@Transactional
	public boolean delete(int no) {
		return boardMapper.delete(no)==1;
	}
}
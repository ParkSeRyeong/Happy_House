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
	private SqlSession sqlSession;

    @Override
	public List<BoardDto> retrieveBoard() {
		return sqlSession.getMapper(BoardMapper.class).selectBoard();
	}
    
  	@Override
	public boolean writeBoard(BoardDto board) {
  		return sqlSession.getMapper(BoardMapper.class).insertBoard(board)==1;
	}

	@Override
	public BoardDto detailBoard(int no) {
		return sqlSession.getMapper(BoardMapper.class).selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(BoardDto board) {
		return sqlSession.getMapper(BoardMapper.class).updateBoard(board)==1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return sqlSession.getMapper(BoardMapper.class).deleteBoard(no)==1;
	}
}
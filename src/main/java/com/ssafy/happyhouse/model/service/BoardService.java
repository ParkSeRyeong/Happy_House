package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> retrieveBoard();
	public BoardDto detailBoard(int no);
	public boolean writeBoard(BoardDto board);
	public boolean updateBoard(BoardDto board);
	public boolean deleteBoard(int no);
}

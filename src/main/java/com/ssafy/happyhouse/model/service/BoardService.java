package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.BoardDto;

public interface BoardService {
	 List<BoardDto> list();
	 BoardDto search(int no);
	 boolean create(BoardDto board);
	 boolean modify(BoardDto board);
	 boolean delete(int no);
}

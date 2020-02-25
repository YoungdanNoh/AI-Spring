package com.dan.recture.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dan.recture.domain.BoardModel;
import com.dan.recture.domain.BoardVO;

public interface BoardService {

	public void regist(BoardModel board) throws Exception;
	
	public List<BoardModel> list(BoardModel board)throws Exception;
	
	public List<BoardModel> selectlist(BoardModel board)throws Exception;
	
	public void delete(BoardModel board) throws Exception;
}

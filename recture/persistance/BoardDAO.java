package com.dan.recture.persistance;

import java.util.List;

import com.dan.recture.domain.BoardModel;

public interface BoardDAO {
	//VO를 가지고 실제로 접근하는 애
	//물리적
	//mapper까지 가게해줌
	public void regist(BoardModel board)throws Exception;

	public void update(BoardModel board) throws Exception;
	
	public List<BoardModel> list(BoardModel board)throws Exception;
	
	public List<BoardModel> selectList(BoardModel board)throws Exception;
	
	public void delete(BoardModel board)throws Exception;
}

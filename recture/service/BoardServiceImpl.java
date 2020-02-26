package com.dan.recture.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dan.recture.domain.BoardModel;
import com.dan.recture.persistance.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardModel board) throws Exception{
		int bdNO = board.getNO();
		if(bdNO==0) {
			dao.regist(board);
		}else {
			dao.update(board);
		}
	}
	public List<BoardModel> list(BoardModel board)throws Exception{
		return dao.list(board);
	}
	
	public List<BoardModel> selectlist(BoardModel board)throws Exception{
		return dao.selectList(board);
	}
	
	public void delete(BoardModel board) throws Exception{
		dao.delete(board);
	}
}

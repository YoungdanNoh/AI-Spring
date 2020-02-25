package com.dan.recture.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dan.recture.domain.BoardModel;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="com.dan.mappers.BoardMapper";
	
	@Override
	public void regist(BoardModel board) throws Exception{
		session.insert(namespace+".regist",board);
	}
	public void update(BoardModel board) throws Exception{
		session.update(namespace+".update",board);
	}
	public List<BoardModel> list(BoardModel board)throws Exception{
		return session.selectList(namespace+".list",board);
	}
	public List<BoardModel> selectList(BoardModel board)throws Exception{
		return session.selectList(namespace+".selectList",board);
	}
	public void delete(BoardModel board)throws Exception{
		session.delete(namespace+".delete",board);
	}
}

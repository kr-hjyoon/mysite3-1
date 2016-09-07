package kr.co.saramin.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite.exception.UserDaoException;
import kr.co.saramin.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	public void update( UserVo vo ) {
		sqlSession.update( "user.update", vo );
	}
	
	public UserVo get( UserVo vo ) {
		return sqlSession.selectOne( "user.getByEmailAndPassword", vo );
	}
	
	public void insert( UserVo vo ) throws UserDaoException {
		sqlSession.insert( "user.insert", vo );
	}	
}
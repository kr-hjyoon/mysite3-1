package kr.co.saramin.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite.dao.GuestbookDao;
import kr.co.saramin.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getMessageList() {
		GuestbookVo vo = guestbookDao.get( 1L );
		System.out.println( vo );
		
		return guestbookDao.getList();
	}
	
	public boolean deleteMessage( GuestbookVo vo ) {
		return guestbookDao.delete( vo ) == 1;
	}
	
	public boolean insertMessage( GuestbookVo vo ) {
		return guestbookDao.insert( vo ) == 1;
	}
}

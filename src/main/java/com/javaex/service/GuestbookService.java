package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	
	//생성자
	//메서드 getter/setter
	//메서드 일반
	//방명록 리스트
		public List<GuestbookVo> getList(){
			
			List<GuestbookVo> guestList = guestbookDao.getPersonList();
			System.out.println(guestList);
			return guestList;
		}
		
		//방명록 등록
		public int insert(GuestbookVo guestbookVo) {
			
			int count = guestbookDao.insert(guestbookVo);
			
			return count;
		}
		
		//방명록 삭제
		public int delete(GuestbookVo guestbookVo) {
			
			int count = guestbookDao.delete(guestbookVo);
			
			return count;
		}
		
	}


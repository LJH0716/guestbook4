package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트 가져오기
	public List<GuestbookVo> getPersonList() {
			
			
			List<GuestbookVo> guestbookList  = sqlSession.selectList("guestbook.selectList");
			System.out.println(guestbookList);
			
			return guestbookList;
	}
	
	//등록(add)
	public int insert(GuestbookVo guestbookVo) {

		int count = sqlSession.insert("guestbook.insert", guestbookVo);

		return count;
	}

	//삭제(delete)
		public int delete(int no) {
			

			int count = sqlSession.delete("guestbook.delete", no);

			return count;
		}
}
package basic220607;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//입력1. 값을 전달하여 입력
		/*
		MemberDAO dao=new MemberDAO();
		dao.insert("test", "1234");
		*/
		
		//입력2.객체에 값을 담아 입력
		/*
		MemberDAO dao=new MemberDAO();
		MemberVO member=new MemberVO("admin","1234");
		dao.insert(member);
		*/
		
		//입력3. set함수를 이용하여 입력
		/*
		MemberDAO dao=new MemberDAO();
		MemberVO member=new MemberVO();
		member.setId("admin1");
		member.setPassword("1234");
		dao.insert(member);
		*/
		
				
		//전체 출력
		/*
		MemberDAO dao=new MemberDAO();
		List list=dao.allFind();
		for(Object imsi:list) {
			System.out.println(imsi);
		}
		*/
		
		//아이디에 의한 하나의 결과값 출력
		MemberDAO dao=new MemberDAO();
		MemberVO member=dao.oneFind("admin");
		System.out.println(member);
		
		
	}

}

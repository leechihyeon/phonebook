package basic220607;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//�Է�1. ���� �����Ͽ� �Է�
		/*
		MemberDAO dao=new MemberDAO();
		dao.insert("test", "1234");
		*/
		
		//�Է�2.��ü�� ���� ��� �Է�
		/*
		MemberDAO dao=new MemberDAO();
		MemberVO member=new MemberVO("admin","1234");
		dao.insert(member);
		*/
		
		//�Է�3. set�Լ��� �̿��Ͽ� �Է�
		/*
		MemberDAO dao=new MemberDAO();
		MemberVO member=new MemberVO();
		member.setId("admin1");
		member.setPassword("1234");
		dao.insert(member);
		*/
		
				
		//��ü ���
		/*
		MemberDAO dao=new MemberDAO();
		List list=dao.allFind();
		for(Object imsi:list) {
			System.out.println(imsi);
		}
		*/
		
		//���̵� ���� �ϳ��� ����� ���
		MemberDAO dao=new MemberDAO();
		MemberVO member=dao.oneFind("admin");
		System.out.println(member);
		
		
	}

}

package basic220609;

import java.sql.SQLException;
import java.util.List;

public class PhonebookMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	PhonebookDAO dao=new PhonebookDAO();
	int result=0;
	PhonebookVO pb
	=new PhonebookVO(4,"parks", "01044444444","none");
	
//	result=dao.insert(pb);
//	if(result>0) {
//		System.out.println("데이터베이스 입력 성공");
//	}else {
//		System.out.println("데이터베이스 입력 실패");
//	}
	
//	List<PhonebookVO> list=dao.findAll();
//	//System.out.println(list);
//	for(PhonebookVO imsi:list) {
//		System.out.println(imsi);
//	}
	
	pb=dao.findOne(4);
	System.out.println(pb);
	
	pb.setMemo("변경");
	dao.update(pb);
	
	dao.delete(1);
	
	
	}

}

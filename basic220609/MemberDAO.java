package basic220607;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
Connection conn;
Statement stat;

public MemberDAO() throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"system", "1234");
	stat=conn.createStatement();
}

public int insert(String id,String password) throws SQLException {
	//inset into member values('id','password')
	String sql="insert into member values('"+id+"','"+password+"')";
	int result=stat.executeUpdate(sql);
	return result;
	
}

public int insert(MemberVO member) throws SQLException {
	String sql="insert into member values('"+member.getId()+"','"+member.getPassword()+"')";
	int result=stat.executeUpdate(sql);
	return result;
}

public List allFind() throws SQLException {
	String sql="select * from member";
	ResultSet rs=stat.executeQuery(sql);
	
	List<MemberVO> list=new ArrayList();
	
	while(rs.next()) {
		//출력방법1
		//System.out.println("id:"+rs.getString(1)
		//+",pass:"+rs.getString(2));
		
		//출력방법2
		//System.out.println("id:"+rs.getString("id")
		//+",pass:"+rs.getString("password"));
		
		//저장소에 한 행을 저장하고 리스트에 저장
		MemberVO m=new MemberVO();
		m.setId(rs.getString("id"));
		m.setPassword(rs.getString("password"));
		list.add(m);	
	}
	return list;
}

public MemberVO oneFind(String id) throws SQLException {
	String sql="select * from member where id='"+id+"'";
	ResultSet rs=stat.executeQuery(sql);
	
	if(rs.next()) {
		String id2=rs.getString("id");
		String password=rs.getString("password");
		MemberVO m=new MemberVO(id2,password);
		//MemberVO m=new MemberVO(rs.getString("id"),
		//		rs.getString("password"));
		return m;
	}
	return null;
}



}

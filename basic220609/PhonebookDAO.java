package basic220609;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAO {
Connection conn;
Statement stat;getMemo
public PhonebookDAO() throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	stat=conn.createStatement();
}

public int insert(PhonebookVO pb) throws SQLException {
	String sql="insert into phonebook values"
			+ "("+pb.getId()+",'"+pb.getName()+"','"+pb.getHp()+"','"+pb.get()+"')";
	int result=stat.executeUpdate(sql);
	return result;
	
}
public List<PhonebookVO> findAll() throws SQLException{
	String sql="select * from phonebook";
	ResultSet rs=stat.executeQuery(sql);
	List<PhonebookVO> list=new ArrayList();
	while(rs.next()) {
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String hp=rs.getString("hp");
		String memo=rs.getString("memo");
		PhonebookVO imsi=
				new PhonebookVO(id, name, hp, memo);
		list.add(imsi);
	}
	return list;
}

public PhonebookVO findOne(int _id) throws SQLException {
	String sql="select * from phonebook where id="+_id;
	ResultSet rs=stat.executeQuery(sql);
	if(rs.next()) {
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String hp=rs.getString("hp");
		String memo=rs.getString("memo");
		PhonebookVO imsi=
				new PhonebookVO(id, name, hp, memo);
		return imsi;
	}
	return null;
}
public int update(PhonebookVO pb) throws SQLException {
	if(exist(pb.getId())) {
	String sql="update phonebook set name='"+pb.getName()+"',hp='"+pb.getHp()+"',memo='"+pb.getMemo()+"' where id="+pb.getId();
	int result=stat.executeUpdate(sql);
	return result;
	}
	return 0;
}
public int delete(int id) throws SQLException {
	if(exist(id)) {
	String sql="delete from phonebook where id="+id;
	int result=stat.executeUpdate(sql);
	return result;
	}
	return 0;
}
public boolean exist(int _id) throws SQLException {
	String sql="select * from phonebook where id="+_id;
	ResultSet rs=stat.executeQuery(sql);
	if(rs.next()) {
		return true;
	}
	return false;
}

}

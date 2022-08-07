package basic220609;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	/*
	1.����Ŭ�� �����ϱ� ���ؼ��� ���̺귯��(����̹�)
	C:\app\admin\product\21c\dbhomeXE\jdbc\lib\ojdbc8.jar
	java build path-���̺귯����-Ŭ�����н�����-add jars-����̹�����
	
	2.�����ϱ� ���ؼ� �ʿ��� ������ �������� Ȯ��
	url�ּ�, �����id, �н�����
	oracle������ ���� url=jdbc:oracle:thin:@localhost:1521:xe
	id=system, password=1234
	*/
	/*	
	//1.����̹� �ε�
	Class.forName("oracle.jdbc.driver.OracleDriver");	
	//2.����Ŭ ���� �۾�
	Connection conn=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe"
			,"system"
			,"1234" 
			);
			
	System.out.println(conn);	
	if(conn==null) {
		System.out.println("�ּ�, ���̵�, ����� Ȯ���ϼ���.");
	}else {
		System.out.println("�����ͺ��̽��� �����ϼ̽��ϴ�.");
	}
	*/
	//sql������ ����ϴ� ���
	//���̺� ����
	/*
	String sql="create table member("
			+ "id varchar2(14),"
			+ "password varchar2(10)"
			+ ")";
	
	Statement stat=conn.createStatement();
	ResultSet result=stat.executeQuery(sql);
	System.out.println(result);
	//conn.commit();
	stat.close();
	conn.close();
	*/
	
	//���̺� ����
	/*
	String sql="drop table member";
	Statement stat=conn.createStatement();
	ResultSet result=stat.executeQuery(sql);
	//conn.commit();
	stat.close();
	conn.close();
	*/
		String sql="create table member("
				+ "id varchar2(14),"
				+ "password varchar2(10)"
				+ ")";
		sql="drop table member";
		Boolean result=sqlcommand(sql);
		if(result) {
			System.out.println("�����ͺ��̽� ���� ����");
		}else {
			System.out.println("�����ͺ��̽� ���� ����");
		}
	}
	
	public static Boolean sqlcommand(String sql) throws ClassNotFoundException, SQLException {
		//1.����̹� �ε�(�۾��� classpath�� ojdbc8.jar ����)
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		//2.����Ŭ ���� �۾�
		Connection conn=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe"
				,"system"
				,"1234" 
				);
		
		Statement stat=conn.createStatement();
		ResultSet result=stat.executeQuery(sql);
		stat.close();
		conn.close();
		if(result==null) {
			return false;
		}else {
			return true;
		}
	}
	
}

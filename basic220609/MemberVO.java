package basic220609;
/*
1.Ŭ���� �����
2.�Ӽ� �����(������ private�߰�)
3.�⺻������, �ʵ������ �����
4.�Ӽ��� ���� get, set�Լ� �����
5.toString�Լ��� ������̵�
*/
public class MemberVO {
private String id;
private String password;

public MemberVO() {
	// TODO Auto-generated constructor stub
}

public MemberVO(String id, String password) {
	this.id = id;
	this.password = password;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "MemberVO [id=" + id + ", password=" + password + "]";
}



}

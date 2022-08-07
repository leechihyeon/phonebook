package phonebook220526;

public class PhoneBook {
	// 멤버변수
	String name, tel, memo;

	// 생성자 함수
	public PhoneBook() { // 생성자 쉽게 만드는 방법 : Ctrl+Space하면 Constructor 누르면 된다.
	}

	// 인자값이 있는 생성자 함수 (값은 전달하기 위한 함수)
	public PhoneBook(String name, String tel, String memo) { // 우클릭 -> source -> Generate Constructor using Feilds...
		this.name = name;
		this.tel = tel;
		this.memo = memo;
	}

	@Override // 우클릭 -> source -> Generate toString()...
	public String toString() { // 사용하는함수
		return "PhoneBook [name=" + name + ", tel=" + tel + ", memo=" + memo + "]";
	}
	
	void view() {
		// 출력함수
		/*
		 * for(int i=0;i<book.length;i++) { for(int j=0; j<book.length;j++){
		 * System.out.println(book[i][j]); } }
		 */
		System.out.println("이름 : " + name + " | 전화번호 : " + tel + " | 메모 : " + memo);
	}
	
	void update(String name, String tel, String memo) {
		this.name = name;
		this.tel = tel;
		this.memo = memo;
		System.out.println(name+"님의 연락처가 수정 되었습니다.");
		
	}

	void delete() {
		this.name = "";
		this.tel = "";
		this.memo = "";
		System.out.println("연락처가 삭제 되었습니다.");
		
	}

}

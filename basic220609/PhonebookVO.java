package basic220609;

public class PhonebookVO {
	//db table 속성을 자바클래스 속성으로 일치시켜 변경
	private int id;
	private String name;
	private String hp;
	private String memo;
	
	public PhonebookVO() {
		// TODO Auto-generated constructor stub
	}

	public PhonebookVO(int id, String name, String hp, String memo) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.memo = memo;
	}
	
	public PhonebookVO(PhonebookVO pb) {
		this.id = pb.getId();
		this.name = pb.getName();
		this.hp = pb.getHp();
		this.memo = pb.getMemo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhonebookVO [id=" + id + ", name=" + name + ", hp=" + hp + ", memo=" + memo + "]";
	}

}

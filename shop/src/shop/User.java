package shop;

public class User {
	int code;
	String name, phone, id, pw;
	private Cart cart;

	public User() {

	}

	public User(int code, String name, String phone, String id, String pw) {
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.pw = pw;
	}

	public int getCode() {
		return this.code;
	}

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return this.pw;
	}

	public String getName() {
		return this.name;
	}

	public User clone() {
		return new User(this.code, this.name, this.phone, this.id, this.pw);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("성함 : %s, 전화번호 : %s, 아이디 : %s, 비밀번호 : %s", name, phone, id, pw);
	}
}

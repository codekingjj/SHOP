package shop;

public class User {
	String name, phone, id, pw;
	private Cart cart;

	public User() {

	}

	public User(String name, String phone, String id, String pw) {
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public User clone() {
		return new User(this.name, this.phone, this.id, this.pw);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("성함 : %s, 전화번호 : %s, 아이디 : %s, 비밀번호 : %s", name, phone, id, pw);
	}
}

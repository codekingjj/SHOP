package shop;

import java.util.ArrayList;

public class UserManager {

	ArrayList<User> list = new ArrayList<>();

	public UserManager() {

	}

	public User createUser(String name, String phone, String id, String pw) {
		if (isDuplId(id)) {
			User user = new User(name, phone, id, pw);
			list.add(user);
			return user.clone();
		}

		return new User();
	}

	private boolean isDuplId(String id) {
		User user = findUserByUserId(id);
		if (id.equals(user.getId())) {
			return false;
		}
		return true;
	}

	private User findUserByUserId(String id) {
		for (User user : list) {
			if (user.getId().equals(id)) {
				return user.clone();
			}
		}

		return new User();
	}

	public ArrayList<User> printList() {
		return this.list;
	} // 검수용
}

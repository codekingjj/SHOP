package shop;

import java.util.ArrayList;
import java.util.Random;

public class UserManager {
	Random random = new Random();
	
	private int buyerCnt;
	
	ArrayList<User> list = new ArrayList<>();

	public UserManager() {

	}

	public User createUser(String name, String phone, String id, String pw) {
		if (isDuplId(id)) {
			int code = generateUserCode();
			User user = new User(code, name, phone, id, pw);
			list.add(user);
			buyerCnt ++;
			return user.clone();
		}

		return new User();
	}
	
	private int generateUserCode() {
		int code = 0;
		while(true) {
			code = random.nextInt(9000) + 1000;
			
			User user = findUserByCode(code);
			
			if (user.getCode() == 0) {
				return code;
			}
		}
	}
	
	private boolean isDuplId(String id) {
		User user = findUserByUserId(id);
		if (id.equals(user.getId())) {
			return false;
		}
		return true;
	}
	
	public User findUserByCode(int code) {
		for (User user : list) {
			if (user.getCode() == (code)) {
				return user.clone();
			}
		}
		return new User();
		
	}
	
	public User findUserByUserId(String id) {
		for (User user : list) {
			if (user.getId().equals(id)) {
				return user.clone();
			}
		}
		return new User();
	}
	
	public User findUserByUserIdAndPw(String id, String pw) {
		for (User user : list) {
			if (user.getId().equals(id) && user.getPw().equals(pw)) {
				return user.clone();
			}
		}
		return new User();
	}

	public ArrayList<User> printList() {
		return this.list;
	} // 검수용
}

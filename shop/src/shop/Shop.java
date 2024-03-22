package shop;

import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);

	final int BACK = 0;
	final int BREAK = 0;
	final int BUYER = 1;
	final int OWNER = 2;

	final int SIGN_IN = 1;
	final int SIGN_OUT = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int SHOPPING = 5;
	final int MY_PAGE = 6;
	final int AUTO_SAVE = 7;
	final int AUTO_LOAD = 8;

	final int ITEM_UPLOAD = 1;
	final int ITEM_DELETE = 2;
	final int ITEM_MODIFY = 3;
	final int CHECK_SALES = 4;

	public boolean isRun;
	private int userCode = 0;
	private int log = 0;

	private UserManager usermanager = new UserManager();
	private ItemManager itemmanager = new ItemManager();

	public Shop(String message) {
		System.out.println("★ " + message + " 쇼핑몰에 오신걸 환영합니다. ★");
		this.isRun = true;
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1) 구매자");
		System.out.println("2) 관리자");
		System.out.println("0) 종료");
	}

	private int option() {
		return inputNumber("선택");
	}

	private int inputNumber(String message) {
		int number = -1;
		try {
			System.out.println(message + " : ");
			String srt = scan.next();
			number = Integer.parseInt(srt);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("유효하지 않은 값입니다.");
		}

		return number;
	}

	private String inputString(String message) {
		System.out.println(message + " : ");
		String str = scan.next();
		return str;
	}

	private void showBuyerMenu() {
		System.out.println("1) 회원가입");
		System.out.println("2) 회원탈퇴");
		System.out.println("3) 로그인");
		System.out.println("4) 로그아웃");
		System.out.println("5) 쇼핑하기");
		System.out.println("6) 마이페이지");
		System.out.println("7) 자동저장");
		System.out.println("8) 자동로드");
		System.out.println("0) 뒤로가기");
		runBuyerMenu(option());
	}

	private void showOwnerMenu() {
		System.out.println("1) 아이템 등록");
		System.out.println("2) 아이템 삭제");
		System.out.println("3) 아이템 수정");
		System.out.println("4) 총 매출액 조회");
		System.out.println("0) 뒤로가기");
		runOwnerMenu(option());
	}

	private void showSubMenu(int select) {
		switch (select) {
		case BUYER:
			showBuyerMenu();
			break;
		case OWNER:
			showOwnerMenu();
			break;
		case BREAK:
			this.isRun = false;
		}
	}

	private void signIn() {
		checkLog();
		if (checkLog()) {
			System.out.println("로그아웃 상태에서 이용가능한 서비스 입니다.");
			return;
		}
		String name = inputString("성함");
		String phone = inputString("전화번호");
		String id = inputString("아이디");
		String pw = inputString("비밀번호");

		User user = usermanager.createUser(name, phone, id, pw);

		printWelcomeMessage(user);
	}

//	private void signOut() {
//		
//	}

	private void logIn() {
		checkLog();
		if (checkLog()) {
			System.out.println("이미 로그인 상태입니다.");
			return;
		}
		String id = inputString("아이디");
		String pw = inputString("비밀번호");

		User user = usermanager.findUserByUserIdAndPw(id, pw);

		printLogInMessage(user);
		if (user.getId() != null) {
			userCode = user.getCode();
			log = 1;
		}

	}

	private void logOut() {
		checkLog();
		if (!checkLog()) {
			System.out.println("이미 로그아웃 상태입니다.");
			return;
		}

		userCode = 0;
		log = 0;
		System.out.println("로그아웃 되었습니다.");
	}

	private void printLogInMessage(User user) {
		String message = user.getId() != null ? String.format("%s(%d) 회원님 로그인 되었습니다.", user.getName(), user.getCode())
				: "로그인 실패";
		System.out.println(message);
	}

	private void printWelcomeMessage(User user) {
		String message = user.getId() != null ? String.format("%s(%d) 회원님 환영합니다.", user.getName(), user.getCode())
				: "회원가입 실패";
		System.out.println(message);
	}

	private boolean checkLog() {
		if (log == 1) {
			return true;
		}
		return false;
	}

	private void runBuyerMenu(int option) {
		switch (option) {
		case SIGN_IN:
			signIn();
			break;
		case SIGN_OUT:
//			signOut();
			break;
		case LOG_IN:
			logIn();
			break;
		case LOG_OUT:
			logOut();
			break;
		case SHOPPING:
//			shopping();
			break;
		case MY_PAGE:
//			myPage();
			break;
		case AUTO_SAVE:
//			dataSave();
			break;
		case AUTO_LOAD:
//			dataLoad();
			break;
		case BACK:
			break;
		}
	}

	private void runOwnerMenu(int option) {
		switch (option) {
		case ITEM_UPLOAD:
//			itemUpload();
			break;
		case ITEM_DELETE:
//			itemDelete();
		case ITEM_MODIFY:
//			itemModify();
		case CHECK_SALES:
//			checkSales();
		case BACK:
			break;
		}
	}

	private void showBuyer() {
		System.out.println(usermanager.printList());
	}

	public void run() {
		while (isRun) {
			printMenu();
			showSubMenu(option());
			showBuyer(); // 검수용
		}
	}
}

package shop;

public class Main {
	public static void main(String[] args) {
		Shop shop = new Shop("Mega");
		shop.run();
		
		// Shop Project
		// class : Item, ItemManager, User, UserManager
		
		//method : 
		
		//유저 - 
		// ㄴ 회원가입/탈퇴
		// ㄴ 로그인/로그아웃
		// ㄴ 쇼핑하기
		// ㄴ 마이페이지(내장바구니, 항목삭제, 수량수정, 결제)
		// ㄴ 자동저장/자동로드
		
		// 관리자 -
		// ㄴ 아이템등록/삭제/수정
		// ㄴ 조회(총 매출)
		
		
		// 시스템 기능(구매자)
				// ㄴ (1)회원가입					[O] 
				// ㄴ (2)회원탈퇴					[시작해야됨]
				// ㄴ (3)로그인					[X]
				// ㄴ (4)로그아웃					[X]
				// ㄴ (5)쇼핑하기   				[X]
				// ㄴ (6)마이페이지					[X]
				// ㄴ (7)자동저장 					[X]
				// ㄴ (8)자동로드					[X]
				// ㄴ (0)종료						[X]
		
		// 시스템 기능(관리자)
				// ㄴ (1) 아이템 등록				[X]
				// ㄴ (2) 아이템 삭제				[X]
				// ㄴ (3) 아이템 수정				[X]
				// ㄴ (4) 총 매출액 조회				[X]
	}
}

package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();

		// MemberService memberService = new MemberServiceImpl();
		// OrderService orderService = new OrderServiceImpl();

		// 먼저 멤버 저장하기
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 하나 생성하기
		memberService.join(member); // DB에 넣기

		Order order = orderService.createOrder(memberId, "itemA", 20000); // 상품 구매하기 -> 오더 생성

		System.out.println("order = " + order.toString());
		System.out.println("order = " + order.calculatePrice());
	}
}

package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		// 먼저 멤버 저장하기
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 하나 생성하기
		memberService.join(member); // DB에 넣기

		Order order = orderService.createOrder(memberId, "itemA", 20000); // 상품 구매하기 -> 오더 생성

		System.out.println("order = " + order.toString());
		System.out.println("order = " + order.calculatePrice());
	}
}

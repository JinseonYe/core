package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceTest {

	// MemberService memberService = new MemberServiceImpl();
	// OrderService orderService = new OrderServiceImpl();

	MemberService memberService;
	OrderService orderService;

	@BeforeEach //테스트 실행 전에 무조건 실행되는 것
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
		//given
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);

		//when
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);

		//then
		Assertions.assertThat(order.getDicountPrice()).isEqualTo(1000);
	}

	// @Test
	// void fieldInjectionTest() {
	// 	OrderServiceImpl orderService = new OrderServiceImpl();
	//
	// 	orderService.setMemberRepository(new MemoryMemberRepository());
	// 	orderService.setDiscountPolicy(new FixDiscountPolicy());
	//
	// 	orderService.createOrder(1L, "itemA", 10000);
	// }
}

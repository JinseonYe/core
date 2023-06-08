package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

	// public MemberService memberService() {
	// 	return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
	// //멤버서비스 임플을 만들고, 내가 만든 멤버서비스 임플은 메모리멤버리파지토리를 쓸거야! 하고 주입
	// }
	//
	// public OrderService orderService() {
	// 	return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	// }

	//위에서 아래처럼 바꿈 -> 역할이 드러날 수 있도록
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository()); //생성자 주입
		//멤버서비스 임플을 만들고, 내가 만든 멤버서비스 임플은 메모리멤버리파지토리를 쓸거야! 하고 주입
	}

	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}

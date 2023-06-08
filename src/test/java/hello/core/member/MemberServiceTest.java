package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {

	// MemberService memberService = new MemberServiceImpl(); //AppConfig 만들기 이전
	MemberService memberService;

	@BeforeEach //테스트 실행 전에 무조건 실행되는 것
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

	@Test
	void join() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);

		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
}

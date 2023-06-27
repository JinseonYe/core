package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//멤버 서비스에 대한 구현체
@Component
public class MemberServiceImpl implements MemberService {

	// private final MemberRepository memberRepository = new MemoryMemberRepository(); //AppConfig 구현하기 이전 코드
	private final MemberRepository memberRepository; //의존관계 주입

	@Autowired //ac.getBean(MemberRepository.class) 자동으로 이 코드가 들어간다고 보면 됨.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}

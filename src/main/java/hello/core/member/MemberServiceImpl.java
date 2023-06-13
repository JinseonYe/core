package hello.core.member;

//멤버 서비스에 대한 구현체
public class MemberServiceImpl implements MemberService {

	// private final MemberRepository memberRepository = new MemoryMemberRepository(); //AppConfig 구현하기 이전 코드
	private final MemberRepository memberRepository; //의존관계 주입

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

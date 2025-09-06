package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //회원 데이터를 메모리에 저장하는 저장소를 사용하는 구조

    private final MemberRepository memberRepository;
    // MemberRepository 인터페이스만 의존하는 방식으로 수정
    // MemberServiceImpl는 의존관계에 대한 고민은 AppConfig에 맡기고 실행만 집중하면 된다

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

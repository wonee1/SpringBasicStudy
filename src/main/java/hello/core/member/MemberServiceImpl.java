package hello.core.member;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //회원 데이터를 메모리에 저장하는 저장소를 사용하는 구조

    private final MemberRepository memberRepository;
    // MemberRepository 인터페이스만 의존하는 방식으로 수정
    // MemberServiceImpl는 의존관계에 대한 고민은 AppConfig에 맡기고 실행만 집중하면 된다

    @Autowired //의존관계를 자동으로 주입해준다 ac.getBean(MemberRepository.class)
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

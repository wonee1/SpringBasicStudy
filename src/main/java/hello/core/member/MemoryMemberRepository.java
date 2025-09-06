package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {


    private static Map<Long ,Member> store = new HashMap<Long, Member>();



    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

} //메모리에서만 저장되는 거여서 테스트로만 사용 (db 없을때 )

package hello.core.member;
import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService;
    @BeforeEach // JUNIT에서 쓰는 어노테이션 각각 테스트 메서드 직전에 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
}

package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given : member가 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : join = 회원가입 했을때, findMember = 회원 조회 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        
        //then : ~게 된다. 검증
        //member가 findMember와 똑같은지
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}

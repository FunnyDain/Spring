package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;


//순수한 자바코드로만 테스트해봄
public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        //멤버 회원가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //제대로 가입됐는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

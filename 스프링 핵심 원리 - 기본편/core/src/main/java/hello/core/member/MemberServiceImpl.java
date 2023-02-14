package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //가입을 하고 회원을 찾으려면 MembmerRepository인터페이스가 필요함
    //MemberRepository타입의 memberRepository객체를 다른 객체로 바꾸지 않기 위해 final사용
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


    //생성자 만들기
    //MemberRepository타입에 맞는 얘를 찾아와서 의존관계주입을 autowired해줌
    @Autowired      //마치 ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //다형성에 의해 인터페이스가 아닌 오버라이딩한 save()가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}

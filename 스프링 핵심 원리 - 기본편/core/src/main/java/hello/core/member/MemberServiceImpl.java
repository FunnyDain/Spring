package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //가입을 하고 회원을 찾으려면 MembmerRepository인터페이스가 필요함
    //MemberRepository타입의 memberRepository객체를 다른 객체로 바꾸지 않기 위해 final사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        //다형성에 의해 인터페이스가 아닌 오버라이딩한 save()가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

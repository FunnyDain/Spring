package hello.core.member;

public interface MemberService {

    //기능1. 회원 가입
    //여기서 save()로 해도 되지만 비즈니스 로직인 회원가입에서는 저장 뿐만 아니라
    //중복 검사 등 다양한 기능이 포함될 수 있기에 join()이 적절
    void join(Member member);

    //기능2. 회원 조회
    Member findMember(Long memberId);
}

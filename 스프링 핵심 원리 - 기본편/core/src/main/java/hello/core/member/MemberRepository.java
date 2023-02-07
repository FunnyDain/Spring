package hello.core.member;

public interface MemberRepository {

    //기능1. 멤버 저장
    void save(Member member);

    //기능2. 회원의 id로 멤버 찾기
    Member findById(Long memberId);

}

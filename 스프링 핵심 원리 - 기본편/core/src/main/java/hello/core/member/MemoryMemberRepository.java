package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //저장소로 실제 db가 아닌 메모리 영역 map에서 임시로 데이터를 저장하고 관리,
    //아직 db에 대한 구현사항이 정해져 있지 않기 때문
    //싱글톤을 사용하는 것처럼 메모리 하나를 계속 공유해야하기 때문에 static으로 생성해서 단 하나만 생성하게 함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        //map안에 값 넣기 : Map.put(key,value)
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        //map안에 값 가져오기 : Map.get(key)
        return store.get(memberId);
    }
}

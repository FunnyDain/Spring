package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //    1. 생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //    2. 수정자 주입
/*    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/



    //    3. 필드 주입
/*    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;*/





    //    4. 메서드 주입
/*    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);     //등급만 넘겨도 되지만 우선은 member넘김
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //OrderSerivce입장에서는 할인에 대해 아무것도 몰라도 discountPrice가 알아서 해주고, 결과를 줌
    //단일체계원칙을 아주 잘지켜서
    //할인에 문제가 생기면 할인쪽만 수정하면 됌

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

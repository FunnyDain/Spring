package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //OrderService가 필요한 것2
    //1. memberRepository에서 회원찾아야함
    private final MemberRepository memberRepository;
    //2. 할인 정책
    private final DiscountPolicy discountPolicy;      //final은 무조건 값이 할당되어야하므로 지움

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);     //등급만 넘겨도 되지만 우선은 member넘김
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    
    //OrderSerivce입장에서는 할인에 대해 아무것도 몰라도 discountPrice가 알아서 해주고, 결과를 줌
    //단일체계원칙을 아주 잘지켜서
    //할인에 문제가 생기면 할인쪽만 수정하면 됌

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

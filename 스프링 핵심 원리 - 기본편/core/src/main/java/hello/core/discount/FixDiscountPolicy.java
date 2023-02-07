package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/*정액 할인 정책*/
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){     //enum은 == 으로 비교하는 것이 맞음
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}

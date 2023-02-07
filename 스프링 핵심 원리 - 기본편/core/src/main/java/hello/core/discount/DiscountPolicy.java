package hello.core.discount;

import hello.core.member.Member;

/*할인정책*/
public interface DiscountPolicy {

    /*return이 할인 대상 금액*/
    //ex) 10000이면 1000원 할인
    int discount(Member member, int price);


}

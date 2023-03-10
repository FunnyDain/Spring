package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //RateDiscountPolicy가 정말 10% 할인되는 지
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
        //이름
    void vip_o(){           //vip ok
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
//        Assertions.assertThat(discount).isEqualTo(1000);

        assertThat(discount).isEqualTo(1000);    //Assertopns에서는 staitc import하는 것이 좋다. alt + enter
    }

    //test할때 실패 test도 꼭 만들어 봐야한다.
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);        //1000원이면 실패가 떠야함
    }

}
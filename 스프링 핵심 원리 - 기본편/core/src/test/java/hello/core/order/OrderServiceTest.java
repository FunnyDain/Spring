package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;     //primitive type은 null이 될 수도 있기때문에 wrapper type사용
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);     //member넣고

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //검증을 Assertions로
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

/*    @Test
    void field(){
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "itemA",1000);
    }*/





}

package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //application의 구성,설정 정보
public class AppConfig {
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    //@Bean memberService -> new MemoryMemberRepository
    //@Bean orderService -> new MemoryMemberRepository
    //이러면 싱글톤이 깨질까?

    //1.
    //call AppConfig.memberService
    //call AppConfig.memberRepository

    //2.
    //call AppConfig.memberRepository

    //3.
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //=> 결과적으로 memberRepository 세번 호출

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }


    //여기서도 생성자 주입을 할 것인데 memberRepository, discountPolicy 사용하는 필드가 두 개
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    private static DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}

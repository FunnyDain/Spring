package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        //AnnotationConfigApplicationContext 자체가 스프링 컨테이너
        //스프링 컨테이너에 빈을 등록하는 다양한 방법 중 지금처럼 바로 생성자에 TestBean.class를 넣어버리면,TestBean.class이 스프링 빈으로 등록됌
        //TestBean이 컴포넌트 스캔하는 것처럼 spring bean으로 등록이 됌
    }

    //임의의 test클래스
    static class TestBean {

        //1.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        //2.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //3.
        @Autowired
        public void setnoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = "+ noBean3);
        }

    }
}

package hello.core;

//AppConfig수정 하기 아까우므로 새로 생성

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration      //설정정보
//스프링 빈을 자동으로 끌어올리는, @Component가 붙은 클래스를 찾아 자동으로 스프링 빈 등록해줌
@ComponentScan(
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        //스프링 빈 등록 중 뺄것을 지정해주는 것
        //Configuration.class를 제외(AppConfig는 수동으로 등록하는 것인데 자동으로 등록하면 안되므로)
)
public class AutoAppConfig {
/*
    @Bean//(name = "memoryMemberRepository")      //소문자로 이름 바뀜
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}

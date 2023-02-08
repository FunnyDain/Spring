    package hello.core;

    import hello.core.member.Grade;
    import hello.core.member.Member;
    import hello.core.member.MemberService;
    import hello.core.member.MemberServiceImpl;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;



    public class MemberApp {

        public static void main(String[] args) {
//            순수한 자바코드로만 테스트 -> 스프링으로 테스트
//            AppConfig appConfig = new AppConfig();
//            MemberService memberService = appConfig.memberService();  
            
            //스프링 생성
            //ApplicationContext = 스프링 컨테이너, 모든 @bean을 관리해줌
            //AppConfig에 있는 환경설정 정보를 가지고 @bean 객체생성한 것들 모두를 컨테이너에 넣어 관리해줌
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//이름, 타입(MemberSerivce)

            //멤버 회원가입
            Member member = new Member(1L, "memberA", Grade.VIP);
            memberService.join(member);

            //제대로 가입됐는지 확인
            Member findMember = memberService.findMember(1L);
            System.out.println("new member = " + member.getName());
            System.out.println("findMember = " + findMember.getName());
        }
    }

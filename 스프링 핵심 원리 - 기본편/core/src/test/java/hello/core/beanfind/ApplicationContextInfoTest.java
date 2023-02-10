package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//junit5부터 public안쓰고 있음
class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);       //타입을 지정안했기 때문에 Object
            System.out.println("name = " + beanDefinitionName + " objcet " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);//getBeanDefinition : 빈에 대한 메타 데이터정보를 꺼내오는 것
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //스프링 내부에서 뭔가를 하기 위해 등록한 빈들이 아니라 애플리케이션을 개발하기 위한 빈들 or 외부 라이브러리
                Object bean = ac.getBean(beanDefinitionName);       //타입을 지정안했기 때문에 Object
                System.out.println("name = " + beanDefinitionName + " objcet " + bean);
            }


        }
    }
}

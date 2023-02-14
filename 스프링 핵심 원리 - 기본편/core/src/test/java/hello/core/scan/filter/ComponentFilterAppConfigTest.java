package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();       //null이여서는 안됌


        org.junit.jupiter.api.Assertions.assertThrows(      //Junit
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));
    }

    //나만의 Component를 scan할 수 있는 기능이 생김
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type= FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type= FilterType.ANNOTATION, classes = MyExcludeComponent.class)

    )
    static class ComponentFilterAppConfig{

    }
}

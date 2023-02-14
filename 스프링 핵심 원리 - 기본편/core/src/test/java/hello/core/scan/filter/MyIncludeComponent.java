package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    //MyIncludeComponent가 붙은 것은 ComponentScan에 추가할 것이라는 뜻
}


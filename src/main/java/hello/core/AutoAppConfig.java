package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        //basePackages ="hello.core.member", // member만 컴포넌트 스캔 대상이 된다
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class)) //설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능 제공,
//excludeFilters를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다

public class AutoAppConfig {


}

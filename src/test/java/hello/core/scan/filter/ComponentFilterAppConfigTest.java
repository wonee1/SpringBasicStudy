package hello.core.scan.filter;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = (BeanA) ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class) //exclude로 컴포넌트 스캔 대상에서 제외
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = MyExcludeComponent.class)

    )
    static class ComponentFilterAppConfig{

    }
}

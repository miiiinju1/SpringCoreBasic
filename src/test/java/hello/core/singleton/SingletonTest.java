package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.AppConfig;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SingletonTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService = SingletonService.getInstance();


        System.out.println("singletonService = " + singletonService);
        System.out.println("singletonService1 = " + singletonService1);

        assertThat(singletonService).isSameAs(singletonService1);
    }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);

    }
}

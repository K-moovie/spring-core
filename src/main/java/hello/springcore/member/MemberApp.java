package hello.springcore.member;

import hello.springcore.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    // Application을 main method를 통해 test하는 것은 바람직하지 않다.
    public static void main(String[] args) {

        // AppConfig
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 직접 생성
        // MemberService memberService = new MemberServiceImpl();

        // Bean 객체 관리
        // Spring 컨테이너에 Annotation이 붙은 멤버와 멥핑
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

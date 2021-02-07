package hello.springcore.member;

import hello.springcore.order.AppConfig;

public class MemberApp {

    // Application을 main method를 통해 test하는 것은 바람직하지 않다.
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

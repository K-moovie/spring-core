package hello.springcore.order;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        // 의존 객체를 AppConfig가 생성하여 주입한다.
        // MemberService memberService =  new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        // Order 객체의 toString() method 호출.
        System.out.println("order = " + order);
        System.out.println("calculatePrice = " + order.calculatePrice());

    }
}

package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}




//public class AppConfig {
//
////    public MemberService memberService() {
////        // MemoryMemberRepository 객체 생성 → MemberServiceImpl에 주입
////        return new MemberServiceImpl(new MemoryMemberRepository());
////    }
////
////    public OrderService orderService() {
////        // MemoryMemberRepository와 FixDiscountPolicy를 생성해서 OrderServiceImpl에 주입
////        return new OrderServiceImpl(
////                new MemoryMemberRepository(),
////                new FixDiscountPolicy());
////    }
//
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(
//                memberRepository(),
//                discountPolicy());
//    }
//
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    public DiscountPolicy discountPolicy() {
//       // return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//
//
//} 스프링 적용 전

package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.Grade;


public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()==Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }//vip 면 1000원 할인, 아니면 할인 없음



    }//인터페이스 DiscountPolicy의 함수 discount를 오버라이딩 함

}

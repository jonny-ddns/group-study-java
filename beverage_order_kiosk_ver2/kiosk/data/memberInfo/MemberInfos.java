package beverage_order_kiosk_ver2.kiosk.data.memberInfo;

import java.util.ArrayList;
import java.util.Collection;

public class MemberInfos {
    private static MemberInfos memberInfos = null;
    private static Collection<Member> memberCollection = null;
    private static Member member = null;

    private MemberInfos(){ }

    public static MemberInfos getInstance(){
        if(memberInfos == null){
            memberInfos = new MemberInfos();
        }
        return memberInfos;
    }

    public static Collection<Member> get_memberList(){
        if(memberCollection == null){
            memberCollection = new ArrayList<>();
        }
        return memberCollection;
    }

    public static Member get_member(){
        if(member == null){
            member = new Member();
        }
        return member;
    }

    //휴대전화로 회원여부 확인하기
    public Member checkMemberInList(String phone){
        memberCollection = get_memberList();
        Member member = null;
        for(Member m : memberCollection){
            if( m.getPhone().equals(phone) ){
                member = m;
                break;
            }
        }
        return member;
    }

    //휴대전화로 회원여부 리턴하기
    public boolean isMemberInList(String phone){
        memberCollection = get_memberList();
        boolean isMember = false;
        for(Member m : memberCollection){
            if( m.getPhone().equals(phone) ){
                isMember = true;
                break;
            }
        }
        return isMember;
    }

    //회원정보 리스트에 추가하기
    public void addCustomer(Member member){
        memberCollection = get_memberList();
        memberCollection.add(member);
    }

    //주문자가 회원이 아닌 경우 설정
    public void setMemberBlank(){
        Member member = new Member();
        member.setPhone("00000000")
            .setBirthday("0000")
            .setNick("NOT_A_MEMBER")
            .setPoint(0);
    }
}

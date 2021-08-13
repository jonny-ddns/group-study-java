package beverage_order_kiosk_ver2.kiosk.memberInfo;

import java.util.ArrayList;
import java.util.List;

public class MemberCollection {

    private static MemberCollection memberCollection = null;
    private static List<Member> memberList = null;
    private static Member member = null;

    private MemberCollection(){ }

    public static MemberCollection getInstance(){
        if(memberCollection == null){
            memberCollection = new MemberCollection();
        }
        return memberCollection;
    }

    public static List<Member> get_memberList(){
        if(memberList == null){
            memberList = new ArrayList<>();
        }
        return memberList;
    }

    public static Member get_member(){
        if(member == null){
            member = new Member();
        }
        return member;
    }

    //휴대전화로 회원여부 확인하기
    public Member checkMemberInList(String phone){
        memberList = get_memberList();
        Member member = null;
        for(Member m : memberList){
            if( m.getPhone().equals(phone) ){
                member = m;
                break;
            }
        }
        return member;
    }

    //휴대전화로 회원여부 리턴하기
    public boolean isMemberInList(String phone){
        memberList = get_memberList();
        boolean isMember = false;
        Member member = null;
        for(Member m : memberList){
            if( m.getPhone().equals(phone) ){
                isMember = true;
                member = m;
                break;
            }
        }
        return isMember;
    }

    //회원정보 리스트에 추가하기
    public void addCustomer(Member member){
        memberList = get_memberList();
        memberList.add(member);
    }
}

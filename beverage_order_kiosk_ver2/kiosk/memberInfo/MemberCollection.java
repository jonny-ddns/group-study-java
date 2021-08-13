package beverage_order_kiosk_ver2.kiosk.memberInfo;

import java.util.ArrayList;
import java.util.List;

public class MemberCollection {

    private static MemberCollection memberCollection = null;
    private static List<Member> memberList = null;
    private static Member member = null;

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

    //이름과 휴대전화로 회원여부 확인하기
    public boolean checkMemberInList(String name, String phone){
        memberList = get_memberList();
        boolean isMember = false;
        for(Member m : memberList){
            if( m.getName().equals(name) && m.getPhone().equals(phone) ){
                isMember = true;
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

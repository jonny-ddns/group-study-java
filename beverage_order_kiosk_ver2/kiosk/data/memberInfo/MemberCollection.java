package beverage_order_kiosk_ver2.kiosk.data.memberInfo;

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

    //�޴���ȭ�� ȸ������ Ȯ���ϱ�
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

    //�޴���ȭ�� ȸ������ �����ϱ�
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

    //ȸ������ ����Ʈ�� �߰��ϱ�
    public void addCustomer(Member member){
        memberList = get_memberList();
        memberList.add(member);
    }
}

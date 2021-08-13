package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;

import java.util.Scanner;

//회원가입 처리하기
public class MemberOperation_signUp implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("MemberOperation_signUp");
        MemberCollection memberCollection =  MemberCollection.getInstance();
        int stepParameter = 0;

        String scan_name;
        String scan_nick;
        String scan_phone;
        String scan_birthday;

        boolean goToNext;


        System.out.println("휴대폰번호를 - 없이 숫자만 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : 010-");
            scan_phone = scan.next().trim();

            //취소
            if(scan_phone.equals("c")) {
                System.out.println("취소되었습니다");
                break;
            }
            
            //동일한 휴대폰 번호가 있는지 확인하기
            boolean isMember = memberCollection.isMemberInList(scan_phone);
            
            //기존 회원
            if(isMember){
                System.out.println("이미 등록된 번호입니다");
            }
            if(){
                goToNext = true;
            }
        }

        System.out.println("이름을 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : ");
            scan_name = scan.next().trim();
        }


        System.out.println("닉네임을 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : ");
            scan_nick = scan.next().trim();
        }


        System.out.println("생일 4자리를 입력하세요 [0813] (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : ");
            scan_birthday = scan.next().trim();
        }
        
        //리스트에 회원정보 삽입하기
        Member member = new Member();
        member.setName(scan_name)
                .setNick(scan_nick)
                .setBirthday(scan_birthday)
                .setPhone(scan_phone)
                .setPoint(0);


        memberCollection.addCustomer(member);

        System.out.println("MemberOperation_signUp end");
        return stepParameter;
    }
}
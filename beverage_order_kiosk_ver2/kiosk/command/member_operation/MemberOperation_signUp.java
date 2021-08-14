package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;

import java.util.Scanner;

//회원가입 처리하기
//입력; 휴대전화, 닉네임, 생일
/*
#리턴
0 취소
1 정상처리
 */
public class MemberOperation_signUp implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("MemberOperation_signUp");

        MemberCollection memberCollection =  null;
        int stepParameter = 0;
        String scan_phone = "";
        String scan_nick = "";
        String scan_birthday = "";

        getScanPhone(scan);
        getScanName(scan);
        getScanBirthday(scan);


        
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

    private void getScanPhone(Scanner scan){
        //입력; 휴대폰
        System.out.println("휴대폰번호를 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : 010-");
            scan_phone = scan.next().trim();

            MemberFunction f = new MemberFunction();
            memberCollection = MemberCollection.getInstance();
            boolean isMember = memberCollection.isMemberInList(scan_phone);

            /* 예외상황 처리 */
            //취소 입력
            if(scan_phone.equals("c")) {
                System.out.println("취소되었습니다");
                goToNext = false;
                break;
            }
            //숫자 외에 다른 문자를 입력했다면
            else if( !f.isNumber(scan_phone) ){
                System.out.println("숫자만 입력바랍니다");
                continue;
            }
            //휴대폰 8자리 입력 오류
            else if( scan_phone.length() != 8 ){
                System.out.println("번호를 다시 입력바랍니다");
                continue;
            }
            //동일한 휴대폰 번호가 있는지 확인하기
            else if(isMember){
                System.out.println("이미 등록된 번호입니다");
                continue;
            }
            goToNext = true;
        }

    }
    private void getScanName(Scanner scan){
//입력; 이름
        System.out.println("이름을 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : ");
            scan_name = scan.next().trim();

            //취소 입력
            if(scan_name.equals("c")) {
                System.out.println("취소되었습니다");
                break;
            }

            goToNext = true;
        }
    }
    private void getScanNick(){
        //입력; 닉네임
        System.out.println("닉네임을 입력하세요 (취소는 c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("입력 : ");
            scan_nick = scan.next().trim();

            //취소 입력
            if(scan_nick.equals("c")) {
                System.out.println("취소되었습니다");
                break;
            }

            goToNext = true;
        }

    }
    //입력; 생일
    private boolean getScanBirthday(Scanner scan){
        boolean goToNext = false;
        System.out.println("생일 4자리를 입력하세요 [0813] (취소는 c)");

        while(!goToNext){
            System.out.print("입력 : ");
            scan_birthday = scan.next().trim();

            //취소 입력
            if(scan_birthday.equals("c")) {
                System.out.println("취소되었습니다");
                break;
            }

            //숫자여부 확인
            MemberFunction f = new MemberFunction();
            if(f.isNumber(scan_birthday)){
                continue;
            }
            else if(scan_birthday.length() != 4){
                System.out.println("생일을 4자리로 입력해주세요");
                continue;
            }

            //월, 일 확인
            String strMonth = scan_birthday.substring(0, 2);
            int month = Integer.parseInt(strMonth);

            String strDay = scan_birthday.substring(2, 4);
            int day = Integer.parseInt(strDay);

            //출력 확인
            System.out.println("month : "+ month);
            System.out.println("day : "+ day);

            if( !(0<month && month<13) || (0<day && day<32) ){
                System.out.println("정말요? 다시 입력해주세요");
                continue;
            }
            goToNext = true;

        }
    }
}
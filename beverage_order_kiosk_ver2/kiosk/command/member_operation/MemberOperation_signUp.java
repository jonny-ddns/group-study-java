package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.KioskOrder;
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

    private String scan_phone = "";
    private String scan_nick = "";
    private String scan_birthday = "";

    @Override
    public int execute(Scanner scan) {
        int stepParameter = 0;
        boolean resultScan_phone;
        boolean resultScan_nick = false;
        boolean resultScan_birthday = false;

        resultScan_phone = getScanPhone(scan);
        if(resultScan_phone){
            resultScan_nick = getScanNick(scan);
        }
        if(resultScan_nick){
            resultScan_birthday = getScanBirthday(scan);
        }

        MemberCollection memberCollection =  MemberCollection.getInstance();
        if(resultScan_birthday){
            //리스트에 회원정보 삽입하기
            Member member = new Member();
            member.setNick(scan_nick)
                    .setBirthday(scan_birthday)
                    .setPhone(scan_phone)
                    .setPoint(0);
            memberCollection.addCustomer(member);
            KioskOrder.setPersonNow(member);
        }
        System.out.println("MemberOperation_signUp end");
        return stepParameter;
    }

    //입력; 휴대폰번호
    private boolean getScanPhone(Scanner scan){
        System.out.println("휴대폰번호를 입력하세요 (취소는 c)");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("처음부터 다시 시도해주시기 바랍니다");
                break;
            }

            System.out.print("입력 : 010-");
            scan_phone = scan.next().trim();

            MemberFunction f = new MemberFunction();
            MemberCollection memberCollection = MemberCollection.getInstance();
            boolean isMember = memberCollection.isMemberInList(scan_phone);

            /* 예외상황 처리 */
            //동일한 휴대폰 번호가 있는지 확인하기
            if(isMember){
                System.out.println("이미 등록된 번호입니다");
                continue;
            }
            //취소 입력
            else if(scan_phone.equals("c")) {
                System.out.println("취소되었습니다");
                scanWell = false;
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
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }

    //입력; 닉네임
    private boolean getScanNick(Scanner scan){
        System.out.println("닉네임을 입력하세요 (취소는 c)");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("처음부터 다시 시도해주시기 바랍니다");
                break;
            }

            System.out.print("입력 : ");
            scan_nick = scan.next().trim();

            //취소 입력
            if(scan_nick.equals("c")) {
                System.out.println("취소되었습니다");
                break;
            }
            //1글자만 입력
            else if(scan_nick.length() < 2){
                System.out.println("닉네임이 짧습니다. 2글자 이상 입력해주세요");
                continue;
            }
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }
    
    //입력; 생일
    private boolean getScanBirthday(Scanner scan){
        System.out.println("생일 4자리를 입력하세요 [ex.0813] (취소는 c)");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("처음부터 다시 시도해주시기 바랍니다");
                break;
            }

            System.out.print("입력 : ");
            scan_birthday = scan.next().trim();
            System.out.println("scan_birthday : "+ scan_birthday);

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
            System.out.println(strMonth);
            int month = Integer.parseInt(strMonth);

            String strDay = scan_birthday.substring(2, 4);
            System.out.println(strDay);
            int day = Integer.parseInt(strDay);

            //출력 확인
            System.out.println("month : "+ month);
            System.out.println("day : "+ day);

            if( !((0<month && month<13) || (0<day && day<32)) ){
                continue;
            }
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }
}
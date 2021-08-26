package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_0_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_1_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_2_signUp;
import java.util.Scanner;

public class MemberController implements Controller{
    /*
    리턴; 0취소 1회원 2비회원
    */
    @Override
    public int control(Scanner scan) {
        System.out.println("MemberController - control");
        MemberCommand memberCommand;
        int result_Decide = 0; //리턴값
        int result_isMember;
        int result_signIn;

        //주문방식 정하기 - 회원1 /비회원2
        memberCommand = new MemberCommand_0_isMember();
        result_isMember = memberCommand.execute(scan);

        //비회원주문
        if( result_isMember == 2 ){
            result_Decide = 2;
        }
        //회원주문
        else if(result_isMember == 1) {
            memberCommand = new MemberCommand_1_signIn();
            result_signIn = memberCommand.execute(scan);

            //로그인 성공
            if(result_signIn == 1){
                result_Decide = 1;
            }

            //회원가입
            else if(result_signIn == 2){
                memberCommand = new MemberCommand_2_signUp();
                if(memberCommand.execute(scan) != 0){
                    result_Decide = 1;
                }
            }
        }
        return result_Decide;
    }
}

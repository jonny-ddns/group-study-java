package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.member_command.MemberCommand;
import beverage_order_kiosk_ver2.kiosk.command.member_command.MemberCommand_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member_command.MemberCommand_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member_command.MemberCommand_signUp;

import java.util.Scanner;

public class MemberController implements Controller{
    private MemberController memberController;
    public MemberController(){ }

    @Override
    public Controller getInstance(){
        if(memberController == null){
            memberController = new MemberController();
        }
        return memberController;
    }

    @Override
    public int control(Scanner scan) {

        return 0;
    }

    /*
    @리턴값에 따른 분기
    .주문방식 - 0취소 / 1회원 / 2비회원
    .로그인 - 0취소 / 1로그인 / 2회원가입
    .회원가입 - 0취소 / 1가입완료

    @리턴; 0취소 1회원 2비회원
    */

    private int receiveOrderWay(Scanner scan){
        MemberCommand memberCommand;
        int result_orderDecide = 0; //리턴값
        int result_isMember;
        int result_signIn;

        //주문방식 정하기 - 회원1 /비회원2
        memberCommand = new MemberCommand_isMember();
        result_isMember = memberCommand.execute(scan);

        //비회원주문
        if( result_isMember == 2 ){
            result_orderDecide = 2;
        }
        //회원주문
        else if(result_isMember == 1) {
            memberCommand = new MemberCommand_signIn();
            result_signIn = memberCommand.execute(scan);

            //로그인 성공
            if(result_signIn == 1){
                result_orderDecide = 1;
            }

            //회원가입
            else if(result_signIn == 2){
                memberCommand = new MemberCommand_signUp();
                if(memberCommand.execute(scan) != 0){
                    result_orderDecide = 1;
                }
            }
        }
        return result_orderDecide;
    }



}

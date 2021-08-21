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
    @���ϰ��� ���� �б�
    .�ֹ���� - 0��� / 1ȸ�� / 2��ȸ��
    .�α��� - 0��� / 1�α��� / 2ȸ������
    .ȸ������ - 0��� / 1���ԿϷ�

    @����; 0��� 1ȸ�� 2��ȸ��
    */

    private int receiveOrderWay(Scanner scan){
        MemberCommand memberCommand;
        int result_orderDecide = 0; //���ϰ�
        int result_isMember;
        int result_signIn;

        //�ֹ���� ���ϱ� - ȸ��1 /��ȸ��2
        memberCommand = new MemberCommand_isMember();
        result_isMember = memberCommand.execute(scan);

        //��ȸ���ֹ�
        if( result_isMember == 2 ){
            result_orderDecide = 2;
        }
        //ȸ���ֹ�
        else if(result_isMember == 1) {
            memberCommand = new MemberCommand_signIn();
            result_signIn = memberCommand.execute(scan);

            //�α��� ����
            if(result_signIn == 1){
                result_orderDecide = 1;
            }

            //ȸ������
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

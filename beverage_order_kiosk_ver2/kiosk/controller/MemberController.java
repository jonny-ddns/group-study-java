package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_0_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_1_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member.MemberCommand_2_signUp;
import java.util.Scanner;

public class MemberController implements Controller{
    /*
    ����; 0��� 1ȸ�� 2��ȸ��
    */
    @Override
    public int control(Scanner scan) {
        System.out.println("MemberController - control");
        MemberCommand memberCommand;
        int result_Decide = 0; //���ϰ�
        int result_isMember;
        int result_signIn;

        //�ֹ���� ���ϱ� - ȸ��1 /��ȸ��2
        memberCommand = new MemberCommand_0_isMember();
        result_isMember = memberCommand.execute(scan);

        //��ȸ���ֹ�
        if( result_isMember == 2 ){
            result_Decide = 2;
        }
        //ȸ���ֹ�
        else if(result_isMember == 1) {
            memberCommand = new MemberCommand_1_signIn();
            result_signIn = memberCommand.execute(scan);

            //�α��� ����
            if(result_signIn == 1){
                result_Decide = 1;
            }

            //ȸ������
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

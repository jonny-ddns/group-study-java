package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signUp;

import java.util.Scanner;

public class MemberController implements Controller{
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
        MemberOperation memberOperation;
        int result_orderDecide = 0; //���ϰ�
        int result_isMember;
        int result_signIn;

        //�ֹ���� ���ϱ� - ȸ��1 /��ȸ��2
        memberOperation = new MemberOperation_isMember();
        result_isMember = memberOperation.execute(scan);

        //��ȸ���ֹ�
        if( result_isMember == 2 ){
            result_orderDecide = 2;
        }
        //ȸ���ֹ�
        else if(result_isMember == 1) {
            memberOperation = new MemberOperation_signIn();
            result_signIn = memberOperation.execute(scan);

            //�α��� ����
            if(result_signIn == 1){
                result_orderDecide = 1;
            }

            //ȸ������
            else if(result_signIn == 2){
                memberOperation = new MemberOperation_signUp();
                if(memberOperation.execute(scan) != 0){
                    result_orderDecide = 1;
                }
            }
        }
        return result_orderDecide;
    }



}

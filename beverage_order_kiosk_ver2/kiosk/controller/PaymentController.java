package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.payment.*;
import java.util.Scanner;

/*
���ݾȳ�
> ������� ���� 
> ����, ī��, ��Ÿ ������� ����
> ȸ���� ����Ʈ �ȳ��ϱ�
> ���������ϸ� �ٽ� ������� ����
> ���������ϸ� �������� �ȳ�
> ������ ���
 */
public class PaymentController extends ControllerFunctions implements Controller{
    PaymentCommand paymentCommand;
    Scanner scan;


    @Override
    public int control(Scanner scan) {
        System.out.println("PaymentController - control");
        this.scan = scan;

        int controllerResult = 0;   //���ϰ�
//        int result_isMember;
//        int result_signIn;
        int[] result;
        
        //���ݾȳ�
        paymentCommand = new PaymentCommand_0_price();
        result = paymentCommand.execute(scan);
        //������ü�� ���� �����ϱ�
        int price = result[0];

        //�������
        paymentCommand = new PaymentCommand_1_way();
        int[] result_paymentKind = paymentCommand.execute(scan);
        int isCanceled = result_paymentKind[0];
        int paymentWay = result_paymentKind[1];

        //������� ����
        if(isCanceled == 0){
            int resultPaymentWay = setPayment(paymentWay, price);
            controllerResult = 1;
        }
        
        //�����ϱ�
        controllerResult = new PaymentCommand_30_pay()
                                .setPaymentWay(1)
                                .execute(scan)[0];
        return controllerResult;
    }


    //������� ���� -> ������ĺ� command ȣ��
    private int[] setPayment(int paymentWay, int price){
        System.out.println("setPayment - ������� switch");
        int[] result = null;
        switch(paymentWay){
            case 1:
                result = new PaymentCommand_11_cash()
                    .setTotalPrice(price)
                    .execute(scan);
                break;
            case 2:
                result = new PaymentCommand_12_creditCard()
                    .setTotalPrice(price)
                    .execute(scan);
                break;
            case 3:
                result = new PaymentCommand_13_other()
                    .setTotalPrice(price)
                    .execute(scan);
                break;
        }
        return result;
    }


    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

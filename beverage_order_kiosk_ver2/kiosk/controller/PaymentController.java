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
        int result_isMember;
        int result_signIn;
        
        //���ݾȳ�
        paymentCommand = new PaymentCommand_0_price();
        paymentCommand.execute(scan);
               
        //�������
        paymentCommand = new PaymentCommand_1_kind();
        int[] result_paymentKind = paymentCommand.execute(scan);
        int isCanceled = result_paymentKind[0];
        int paymentWay = result_paymentKind[1];

        //������� ����
        if(isCanceled == 0){
            int resultPaymentWay = setPayment(paymentWay);
            controllerResult = 1;
        }
        
        //�����ϱ�
        controllerResult = new PaymentCommand_30_pay()
                                .setPaymentWay(1)
                                .execute(scan)[0];
        return controllerResult;
    }

    //������� ����
    private int setPayment(int paymentWay){
        System.out.println("setPayment - ������� switch");
        int resultPaymentWay = 0;
        switch(paymentWay){
            case 1:
                paymentCommand = new PaymentCommand_11_cash();
                resultPaymentWay = paymentCommand.execute(scan)[1];
                break;
            case 2:
                paymentCommand = new PaymentCommand_12_creditCard();
                resultPaymentWay = paymentCommand.execute(scan)[1];
                break;
            case 3:
                paymentCommand = new PaymentCommand_13_other();
                resultPaymentWay = paymentCommand.execute(scan)[1];
                break;
            default:
                System.out.println("�� �� ���� �������");
                break;
        }
        return resultPaymentWay;
    }


    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

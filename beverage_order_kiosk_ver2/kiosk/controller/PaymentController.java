package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.payment.*;
import java.util.Scanner;

public class PaymentController extends ControllerFunctions implements Controller{
    @Override
    public int control(Scanner scan) {
        System.out.println("PaymentController - control");
        PaymentCommand paymentCommand;
        int controllerResult = 0;   //���ϰ�
        int[] result;
        int signal;
        int answer;
        int price;
        int receivedMoney;

        boolean paymentFinish = false;
        while(!paymentFinish){
            //���ݾȳ�
            paymentCommand = new PaymentCommand_0_price();
            price = paymentCommand.execute(scan)[0];    //������ ���� ����

            //��������� ���� ����
            paymentCommand = new PaymentCommand_1_way();
            result = paymentCommand.execute(scan);
            signal = result[0];
            answer = result[1];

            //������ҽ�
            if(signal == 0){ continue; }

            result = setPayment(scan, answer, price);
            signal  = result[0];
            answer  = result[1];
            receivedMoney = result[2];

            //���� ���н�
            if(signal == 0){ continue; }
            
            //������ ���
            new PaymentCommand_30_receipt().setPaymentWay(answer)
                    .setReceivedMoney(receivedMoney)
                    .execute(scan);
            controllerResult = 1;
            paymentFinish = true;
        }
        return controllerResult;
    }

    //������� ���� -> ������ĺ� command ȣ��
    private int[] setPayment(Scanner scan, int paymentWay, int price){
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
}
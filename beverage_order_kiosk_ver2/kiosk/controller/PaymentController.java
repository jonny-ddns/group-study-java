package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.payment.*;
import java.util.Scanner;

public class PaymentController extends ControllerFunctions implements Controller{
    @Override
    public int control(Scanner scan) {
        System.out.println("PaymentController - control");
        PaymentCommand paymentCommand;
        int controllerResult = 0;   //리턴값
        int[] result;
        int signal;
        int answer;
        int price;
        int receivedMoney;

        boolean paymentFinish = false;
        while(!paymentFinish){
            //가격안내
            paymentCommand = new PaymentCommand_0_price();
            price = paymentCommand.execute(scan)[0];    //결제할 가격 설정

            //결제방법에 따른 결제
            paymentCommand = new PaymentCommand_1_way();
            result = paymentCommand.execute(scan);
            signal = result[0];
            answer = result[1];

            //결제취소시
            if(signal == 0){ continue; }

            result = setPayment(scan, answer, price);
            signal  = result[0];
            answer  = result[1];
            receivedMoney = result[2];

            //결제 실패시
            if(signal == 0){ continue; }
            
            //영수증 출력
            new PaymentCommand_30_receipt().setPaymentWay(answer)
                    .setReceivedMoney(receivedMoney)
                    .execute(scan);
            controllerResult = 1;
            paymentFinish = true;
        }
        return controllerResult;
    }

    //결제방법 선택 -> 결제방식별 command 호출
    private int[] setPayment(Scanner scan, int paymentWay, int price){
        System.out.println("setPayment - 결제방식 switch");
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
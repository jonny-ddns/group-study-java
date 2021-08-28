package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.payment.*;
import java.util.Scanner;

/*
가격안내
> 결제방식 선택 
> 현금, 카드, 기타 방식으로 결제
> 회원은 포인트 안내하기
> 결제실패하면 다시 결제방식 선택
> 결제성공하면 결제성공 안내
> 영수증 출력
 */
public class PaymentController extends ControllerFunctions implements Controller{
    PaymentCommand paymentCommand;
    Scanner scan;


    @Override
    public int control(Scanner scan) {
        System.out.println("PaymentController - control");
        this.scan = scan;

        int controllerResult = 0;   //리턴값
//        int result_isMember;
//        int result_signIn;
        int[] result;
        
        //가격안내
        paymentCommand = new PaymentCommand_0_price();
        result = paymentCommand.execute(scan);
        //공유객체에 가격 설정하기
        int price = result[0];

        //결제방법
        paymentCommand = new PaymentCommand_1_way();
        int[] result_paymentKind = paymentCommand.execute(scan);
        int isCanceled = result_paymentKind[0];
        int paymentWay = result_paymentKind[1];

        //결제방식 선택
        if(isCanceled == 0){
            int resultPaymentWay = setPayment(paymentWay, price);
            controllerResult = 1;
        }
        
        //결제하기
        controllerResult = new PaymentCommand_30_pay()
                                .setPaymentWay(1)
                                .execute(scan)[0];
        return controllerResult;
    }


    //결제방법 선택 -> 결제방식별 command 호출
    private int[] setPayment(int paymentWay, int price){
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


    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

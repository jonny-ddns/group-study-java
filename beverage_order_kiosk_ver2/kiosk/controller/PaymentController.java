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
        int result_isMember;
        int result_signIn;
        
        //가격안내
        paymentCommand = new PaymentCommand_0_price();
        paymentCommand.execute(scan);
               
        //결제방법
        paymentCommand = new PaymentCommand_1_kind();
        int[] result_paymentKind = paymentCommand.execute(scan);
        int isCanceled = result_paymentKind[0];
        int paymentWay = result_paymentKind[1];

        //결제방식 선택
        if(isCanceled == 0){
            int resultPaymentWay = setPayment(paymentWay);
            controllerResult = 1;
        }
        
        //결제하기
        controllerResult = new PaymentCommand_30_pay()
                                .setPaymentWay(1)
                                .execute(scan)[0];
        return controllerResult;
    }

    //결제방법 선택
    private int setPayment(int paymentWay){
        System.out.println("setPayment - 결제방식 switch");
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
                System.out.println("알 수 없는 결제방식");
                break;
        }
        return resultPaymentWay;
    }


    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

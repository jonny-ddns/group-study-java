package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.payment.*;
import java.util.Scanner;

public class PaymentController extends ControllerFunctions implements Controller{
    PaymentCommand paymentCommand;
    Scanner scan;

    @Override
    public int control(Scanner scan) {
        this.scan = scan;

        System.out.println("PaymentController - control");

        int result_Decide = 0; //리턴값
        int result_isMember;
        int result_signIn;

        paymentCommand = new PaymentCommand_1_kind();
        int[] result_paymentKind = paymentCommand.execute(scan);
        int isCanceled = result_paymentKind[0];
        int paymentWay = result_paymentKind[1];

        //결제 
        if(!(isCanceled == 0)){
            System.out.println("111");
            //취소됨
            return 0;
        } else {
            System.out.println("222");
            paymentCommand = new PaymentCommand_0_price();

            paymentCommand.execute(scan);
            setPayment(paymentWay);
        }
        return 1;
    }

    private void setPayment(int paymentWay){
        int result;
        switch(paymentWay){
            case 1:
                paymentCommand = new PaymentCommand_11_cash();
                paymentCommand.execute(scan);
                break;
            case 2:
                paymentCommand = new PaymentCommand_12_creditCard();
                paymentCommand.execute(scan);
                break;
            case 3:
                paymentCommand = new PaymentCommand_13_other();
                paymentCommand.execute(scan);
                break;
        }
    }

    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

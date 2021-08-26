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

        int result_Decide = 0; //¸®ÅÏ°ª
        int result_isMember;
        int result_signIn;

        paymentCommand = new PaymentCommand_0_kind();
        int paymentWay = paymentCommand.execute(scan)[0];





        return 0;
    }

    private void setPayment(int paymentWay){
        int result;
        switch(paymentWay){
            case 1:
                paymentCommand = new PaymentCommand_1_cash();
                paymentCommand.execute(scan);
                break;
            case 2:
                paymentCommand = new PaymentCommand_2_creditCard();
                paymentCommand.execute(scan);
                break;
            case 3:
                paymentCommand = new PaymentCommand_3_other();
                paymentCommand.execute(scan);
                break;
        }
    }

    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }
}

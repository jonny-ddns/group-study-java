package beverage_order_kiosk_ver2.kiosk.command.payment;

import java.util.Scanner;

//搬力贸府
//府畔搬力己傍咯何
public class PaymentCommand_30_pay implements PaymentCommand{
    private int paymentWay; //搬力规侥
    @Override
    public int[] execute(Scanner scan) {
        

        return new int[0];
    }

    public PaymentCommand setPaymentWay(int paymentWay){
        this.paymentWay = paymentWay;
        return this;
    }
}

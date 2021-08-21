package beverage_order_kiosk_ver2.kiosk.controller;

import java.util.Scanner;

public class PaymentController implements Controller{
    PaymentController paymentController;

    @Override
    public Controller getInstance(){
        if(paymentController == null){
            paymentController = new PaymentController();
        }
        return paymentController;
    }

    @Override
    public int control(Scanner scan) {
        return 0;
    }
}

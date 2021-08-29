package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.controller.Controller;
import beverage_order_kiosk_ver2.kiosk.controller.MemberController;
import beverage_order_kiosk_ver2.kiosk.controller.OrderController;
import beverage_order_kiosk_ver2.kiosk.controller.PaymentController;
import java.util.Scanner;

public class KioskOrder {
    private final Controller memberController   = new MemberController();
    private final Controller orderController    = new OrderController();
    private final Controller paymentController  = new PaymentController();
    private final Scanner scan                  = new Scanner(System.in);
    private int orderCount = 0;

    protected KioskOrder() {
        System.out.println("ORDER START!");
        orderStart();
    }

    //주문받기
    private void orderStart() {
        boolean orderFinish = false;
        int controlResult;

        while(!orderFinish) {
            controlResult = memberController.control(scan);
            if(controlResult == 0){ continue; }

            controlResult = orderController.control(scan);
            if(controlResult == 0){ continue; }

            paymentController.control(scan);
            orderFinish = true;
        }
        kioskSleep();
        if( ++orderCount>9999 ){ shutdownKiosk(); }
        this.orderStart();
    }

    //거래완료후 2초동안 sleep
    private void kioskSleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored){ }
    }

    private void shutdownKiosk(){ System.exit(0);}
}
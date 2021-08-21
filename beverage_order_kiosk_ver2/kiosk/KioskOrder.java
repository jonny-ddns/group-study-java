package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.controller.Controller;
import beverage_order_kiosk_ver2.kiosk.controller.MemberController;
import beverage_order_kiosk_ver2.kiosk.controller.OrderController;
import beverage_order_kiosk_ver2.kiosk.controller.PaymentController;
import beverage_order_kiosk_ver2.kiosk.data.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverKind;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.Pricing;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverKind_ko;
import beverage_order_kiosk_ver2.kiosk.data.receipt.Receipt;
import java.util.Scanner;

public class KioskOrder {
    private final Scanner scan;
    private static Member personNow;
    private final Receipt receipt;
    private Controller controller;

    public static Member getPersonNow() {
        return personNow;
    }
    public static void setPersonNow(Member personNow) {
        KioskOrder.personNow = personNow;
    }

    public static void setPersonBasic() {
        Member member = new Member();
        member.setPhone("00000000")
                .setBirthday("0000")
                .setNick("NOT_A_MEMBER")
                .setPoint(0);
        setPersonNow(member);
    }

    protected KioskOrder() {
    	System.out.println("ORDER START!");
    	scan    = new Scanner(System.in);
        receipt = new Receipt();
        do_orderStart();
    }
    public void do_orderStart(){
        orderStart();
    }

    //주문받기
    private void orderStart() {
        personNow = null;           //주문자 정보 초기화
        boolean orderFinish = false;
        int orderCount = 0;

        while(!orderFinish) {
            
            //클래스 만들어서 분리하기
            controller = new MemberController();
            int test01 = controller.control(scan);

            controller = new OrderController();
            int test02 = controller.control(scan);

            controller = new PaymentController();
            int test03 = controller.control(scan);

            System.out.println(test01);
            System.out.println(test02);
            System.out.println(test03);

            /*-------------------------------*/
//            //1. 주문방식 결정
//            if(receiveOrderWay() == 0) { continue; }
//
//            //2. 주문받기
//            int[] result_receiveOrder = receiveOrderMenu();
//            int resultSignal    = result_receiveOrder[0];
//            orderCount          = result_receiveOrder[1];
//
//            //3. 주문자 정보 가져오기
//            personNow = getPersonNow();
//
//            //4. 결제하기
//            receivePayment();

            //주문취소시
//            if ( resultSignal==0 ) { continue; }
            orderFinish = true;
        }
        receipt.receiptPrint(orderCount);                               //영수증 생성 및 출력
        try { kioskSleep(); } catch (InterruptedException ignored){ }   //영수증 출력후 2초 sleep
        this.do_orderStart();                                           //키오스크 재호출
    }


    private void kioskSleep() throws InterruptedException{
        Thread.sleep(2000);
    }
}
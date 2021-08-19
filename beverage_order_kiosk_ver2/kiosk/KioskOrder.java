package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signUp;
import beverage_order_kiosk_ver2.kiosk.command.order_operation.*;
import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk_ver2.kiosk.menu_enum.Pricing;
import beverage_order_kiosk_ver2.kiosk.menu_enum.음료;
import beverage_order_kiosk_ver2.kiosk.receipt.CreateReceipt;
import java.util.Scanner;

public class KioskOrder {
    private final Scanner scan;

    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
    	scan = new Scanner(System.in);
        orderStart();
    }
    
    //주문받기
    private void orderStart() {
        int result_orderWay = 0;    //주문방식- 취소/회원/비회원
        int count;                  //주문개수
        
        while(result_orderWay == 0) {
            //1. 주문방식 결정
            result_orderWay = receiveOrderWay();
            System.out.println("result_orderWay : " + result_orderWay);

            //2. 주문받기
            int[] result_receiveOrder = receiveOrder();
            int resultSignal = result_receiveOrder[0];
            count = result_receiveOrder[1];

            //주문취소시
            if (resultSignal != 0) {
            } else {
            }

            //영수증 출력
            new CreateReceipt(count);
            scan.close();

            this.orderStart();
        }
    }

    /*
    #리턴값에 따른 분기
    .주문방식 - 0취소 / 1회원 / 2비회원
    .로그인 - 0취소 / 1로그인 / 2회원가입
    .회원가입 - 0취소 / 1가입완료

    #리턴; 0취소 1회원 2비회원
    */
    private int receiveOrderWay(){
        System.out.println("receiveOrderWay");

        MemberOperation memberOperation;
        int result_orderDecide = 0; //리턴값
        int result_isMember;
        int result_signIn;

        //주문방식 정하기 - 회원1 /비회원2
        memberOperation = new MemberOperation_isMember();
        result_isMember = memberOperation.execute(scan);

        //비회원주문
        if(result_isMember == 2 ){
            result_orderDecide = 2;
        }
        //회원주문
        else if(result_isMember == 1) {
            memberOperation = new MemberOperation_signIn();
            result_signIn = memberOperation.execute(scan);

            //로그인
            if(result_signIn == 1){
                result_orderDecide = 1;
            }
            //회원가입
            else if(result_signIn == 2){
                memberOperation = new MemberOperation_signUp();
                memberOperation.execute(scan);
                result_orderDecide = 1;
            }
        }
        System.out.println("receiveOrderWay end");
        return result_orderDecide;
    }

    //주문내용 받기
    private int[] receiveOrder() {
        int[] result_receiveOrder;      //리턴객체
        int count = 1;                  //주문개수
        int resultSignal = 0;           //주문신호
        boolean orderProgress = true;    //플래그

        OrderOperation orderOperation;

        while (orderProgress) {
            printMenu();
            //음료 종류
            orderOperation = new OrderOperation0_kind();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//음료 온도
            orderOperation = new OrderOperation1_temper();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//음료 샷
            orderOperation = new OrderOperation2_shot();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//음료 크기
            orderOperation = new OrderOperation3_size();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//음료 섭취장소
            orderOperation = new OrderOperation4_where();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //추가주문 희망시 주문더 받기
            orderOperation = new OrderOperation5_orderMore();
            if(!orderOperation.execute(scan)) {
                //추가주문 없을시 최종주문 확인하기
                orderOperation = new OrderOperation6_orderCheck();
                if(orderOperation.execute(scan)){
                    resultSignal = 1;
                    orderProgress = false;
                } else {
                    reset();
                    orderProgress = false;
                }
            }
            count++;
        }
        //주문결과 (결과번호, 주문개수)
        result_receiveOrder = new int[]{resultSignal, count};
        return result_receiveOrder;
    }

    //주문취소시 주문내역 reset
    private void reset(){
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //메뉴 출력
	private void printMenu() {
		음료[] 음료배열	= 음료.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		String line     = "----------------------";
		
		System.out.println(line);
		System.out.println("메뉴");
		for(int i = 0; i< BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d원\n", i+1, 음료배열[i], priceArr[i]);
		}
        System.out.println(line);
    }
}
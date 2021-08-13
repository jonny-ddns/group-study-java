package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_orderWay;
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

    boolean wantToCancel = false;	//주문취소 여부
    boolean orderMore = true;		//추가주문 여부
    boolean orderCheck = true;		//주문확인 결과
    private final Scanner scan;
    
    //constructor. 생성과 동시에 start() 메서드 호출
    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
    	scan = new Scanner(System.in);
        orderStart();
    }

    //주문받고(receiveOrder) 영수증을 출력(CreateReceipt)하는 메서드 호출
    private void orderStart() {
        wantToCancel= false;
        orderMore = true;
        orderCheck = true;
        int count = 0;

        /*
        회원여부 확인하기
        .회원 -> 로그인 or 회원가입
        .비회원 -> 바로 주문
         */

        //주문방식을 받기위해 메서드 호출
        orderWay();





        //추가주문하지 않을 때까지 반복
        while(orderMore) {
          	wantToCancel        = false;
        	boolean[] boolArr   = receiveOrder();
            orderMore           = boolArr[0];

            //주문개수 증가
            if(!boolArr[1]){
                count++;
            }
        }
        //주문확인 결과
        if(orderCheck){
            new CreateReceipt(count);
            scan.close();
        } else {
        	orderMore = true;
        	orderCheck = true;
        	this.orderStart();
        }
    }


    //주문방식 > 회원로그인 > 회원가입으로 단계 진행하기
    private void orderWay(){
        MemberOperation memberOperation;

        int result_orderWay;
        int result_signIn;
        int result_signUp;

        //주문방식 정하기 - 회원1 /비회원2
        memberOperation = new MemberOperation_orderWay();
        result_orderWay = memberOperation.execute(scan);

        if(result_orderWay == 1){
            memberOperation = new MemberOperation_signIn();
            result_signIn = memberOperation.execute(scan);

            if(result_signIn == 3){
            }
        }


        memberOperation = new MemberOperation_signUp();
        result_signUp = memberOperation.execute(scan);

    }


    //Operation 인터페이스 구현객체를 호출하여 주문받기
    private boolean[] receiveOrder() {
//        Scanner scan = new Scanner(System.in);

        boolean[] booleans = new boolean[2];
        while (!wantToCancel) {
            printMenu();
        	OrderOperation orderOperation;

        	//음료 종류
            orderOperation = new OrderOperation0_kind();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//음료 온도
            orderOperation = new OrderOperation1_temper();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//음료 샷
            orderOperation = new OrderOperation2_shot();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//음료 크기
            orderOperation = new OrderOperation3_size();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//음료 섭취장소
            orderOperation = new OrderOperation4_where();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

            orderOperation = new OrderOperation5_orderMore();
            orderMore = orderOperation.execute(scan);

            //추가주문을 원치 않는다면
            if(!orderMore) {
                orderOperation = new OrderOperation6_orderCheck();
                orderCheck = orderOperation.execute(scan);
                break;
            }
        }
        booleans[0] = orderMore;
        booleans[1] = wantToCancel;
        return booleans;
    }

    //주문취소시 List를 null로 만듬
    private void reset(){
        System.out.println("reset 호출");
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //메뉴 출력
	private void printMenu() {
		음료[] 음료배열		= 음료.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		
		System.out.println("----------------------");
		System.out.println("메뉴");
		for(int i = 0; i< BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d원\n", i+1, 음료배열[i], priceArr[i]);
		}
		System.out.println("----------------------");
	}
}
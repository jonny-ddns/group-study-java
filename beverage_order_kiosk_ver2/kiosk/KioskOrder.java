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
    
    private void orderStart() {
        boolean orderMore = true;		//추가주문 여부
        boolean orderCheck = true;		//주문확인 결과

        int count = 0;
        
        /*
        코딩방법 
        주문방식 -> 취소되면 다시 처음부터
        주문내용 -> 최소되면 다시 처음부터
        
        주문내용 반복문으로 계속 추가주문 받아야 함
        추가주문 횟수 받기
         */

        boolean isCanceled = false;
        while(!isCanceled){

            //주문방식 결정
            int result_orderDecide = 0;
            result_orderDecide = orderWayDecide();
            System.out.println("result_orderDecide : "+ result_orderDecide);

            if(result_orderDecide == 0){
                continue;
            }
            
            //주문내용 받기
            boolean[] result_receiveOrder = receiveOrder();

            System.out.println("취소여부/ 추가주문여부/ 주문확인여부");
            for(boolean b : result_receiveOrder){
                System.out.print(b+ "\t");
            }

            //주문 취소시
            if(!result_receiveOrder[0]){
                continue;
            }

            System.out.println("반복문 종료");
            isCanceled = true;
        }


          //추가주문하지 않을 때까지 반복
//        while(orderMore) {
//
//
//        	//디버깅

//
//            orderMore                  = receiveResults[0];
//
//            //주문개수 증가
//            if(!receiveResults[1]){
//                count++;
//            }
//        }
        //주문확인 결과
        if(orderCheck){
            new CreateReceipt(count);
            scan.close();
        } else {

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
    private int orderWayDecide(){
        System.out.println("orderWayDecide");

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
        System.out.println("orderWayDecide end");
        return result_orderDecide;
    }

    //주문내용 받기
    private boolean[] receiveOrder() {
        boolean[] result_receiveOrder = new boolean[3];
        boolean wantToCancel = false;
        boolean orderMore = false;
        boolean orderCheck = false;
        OrderOperation orderOperation;
        
        //while 문 말고 다른 방식으로 코딩하기
        while (!wantToCancel) {
            printMenu();

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
                if(!orderCheck){ reset(); break; }
            }
        }
        result_receiveOrder[0] = wantToCancel;
        result_receiveOrder[1] = orderMore;
        result_receiveOrder[2] = orderCheck;
        return result_receiveOrder;
    }

    //주문취소시 List를 초기화하는 메서드 호출
    private void reset(){
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //메뉴 출력
	private void printMenu() {
		음료[] 음료배열	= 음료.values();
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
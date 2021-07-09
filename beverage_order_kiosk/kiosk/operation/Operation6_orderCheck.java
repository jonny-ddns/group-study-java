package beverage_order_kiosk.kiosk.operation;

import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.operation.func.Mention;
import beverage_order_kiosk.kiosk.receipt.UnitChange;

import java.util.List;
import java.util.Scanner;

//주문내역 확인결과를 입력받는 역할 수행
public class Operation6_orderCheck implements Operation {
    @Override
    public boolean execute() {

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        boolean goToNext 	= false;	//반복 플래그 변수
        boolean OrderCheck	= false;	//주문 확인결과 리턴

        //주문내역 출력하기
        List<Orders> orderList = OrderCollection.get_orderList();        

        //OrderCollection 접근해서 List에 담긴 요청사항 출력하기
        System.out.println();
        for(Orders order: orderList) {        
	        int kind = order.getBeverKind();
	        int temper = order.getBeverTemper();
	        int shot = order.getBeverShot();
	        int size = order.getBeverSize();
	        int where = order.getBeverWhere();
	        String str1 = UnitChange.toString_kind(kind);
	        String str2 = UnitChange.toString_temper(temper);
	        String str3 = UnitChange.toString_shot(shot);
	        String str4 = UnitChange.toString_size(size);
	        String str5 = UnitChange.toString_where(where);
	
	        System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
        }
        System.out.print("주문하시겠습니까? (y/n): ");
        
		//주문확인 결과를 받기위한 반복문
        while(!goToNext) {
            Mention m = new Mention();
            String request = scan.next().trim().toLowerCase();
            boolean isYesOrNo = CheckRequest.isYesOrNo(request);

            if(isYesOrNo) {
                if(request.equals("y")){
                    goToNext = true;
                    OrderCheck = true;
                    break;
                } else if(request.equals("n")){
                    System.out.println(m.getMent7_orderAgain());
                    goToNext = true;
                    break;
                }
            } else {
                System.out.println(m.getMent9_yn_only());
            }
        }
        return OrderCheck;
    }
}

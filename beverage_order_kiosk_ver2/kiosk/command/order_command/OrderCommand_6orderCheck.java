package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;
import java.util.List;
import java.util.Scanner;

//주문내역 확인결과를 입력받는 역할 수행
public class OrderOperation6_orderCheck implements OrderOperation {
    OrderFunctions orderFunctions;

    @Override
    public boolean execute(Scanner scan) {
        orderFunctions = new OrderFunctions();

        boolean goToNext 	= false;	//반복 플래그 변수
        boolean OrderCheck	= false;	//주문 확인결과 리턴

        //주문내역 출력하기
        List<Order> orderList = OrderCollection.get_orderList();

        //OrderCollection 접근해서 List에 담긴 요청사항 출력하기
        System.out.println();
        for(Order order: orderList) {
	        String str1 = UnitChange.toString_kind(order.getBeverKind());
	        String str2 = UnitChange.toString_temper(order.getBeverTemper());
	        String str3 = UnitChange.toString_shot(order.getBeverShot());
	        String str4 = UnitChange.toString_size(order.getBeverSize());
	        String str5 = UnitChange.toString_where(order.getBeverWhere());
	        System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
        }
        System.out.print("주문하시겠습니까? (y/n): ");
        
		//주문확인 결과를 받기위한 반복문
        int count=0;
        while(!goToNext) {

            String request = scan.next().trim().toLowerCase();
            boolean isYesOrNo = orderFunctions.isYesOrNo(request);

            if(isYesOrNo) {
                if(request.equals("y")){
                    OrderCheck = true;
                    break;
                } else if(request.equals("n")){
                    System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                    break;
                }
            } else {
                System.out.println("y 혹은 n을 입력바랍니다");
            }

            if(++count > 4){
                goToNext = true;
            }
        }
        return OrderCheck;
    }
}

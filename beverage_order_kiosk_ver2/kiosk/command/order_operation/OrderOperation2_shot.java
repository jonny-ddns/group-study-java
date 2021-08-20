package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverShot;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;
import java.util.Scanner;

//음료 샷 개수를 입력받는 역할 수행
public class OrderOperation2_shot implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

        int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean isCanceled = false;		//리턴 객체

		//커피 종류를 주문하지 않았다면 아래 while 문 실행되지 않음
		Order order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			goToNext = true;
		}
   	
        while(!goToNext) {    	
			System.out.print("\n1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소 c): ");
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = orderFunctions.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverShot.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
                	
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(num);
                	
                	System.out.printf("%s(%s/%s)\n", str1, str2, str3);
                	
            		goToNext = true;
            	} else {
            		System.out.println("번호를 다시 입력바랍니다 (1~2)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println("\n주문을 취소하시겠습니까? (y/n): ");
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = orderFunctions.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                	isCanceled = true;
                	break;
            	}
            }        
            else {
				System.out.println("숫자를 입력바랍니다");
            }
    	}
        order.setBeverShot(input);

		return isCanceled;
	}
}

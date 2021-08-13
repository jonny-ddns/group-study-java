package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Order;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverTemper;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.Scanner;

//음료 온도를 입력받는 역할 수행
public class OrderOperation1_temper implements OrderOperation {
    @Override
    public boolean execute(Scanner scan) {
        int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean wantToCancel = false;	//리턴 객체

		//커피 종류를 주문하지 않았다면 아래 while 문 실행되지 않음
		Order order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			goToNext = true;
		}
    	
        while(!goToNext) {
			Mention m = new Mention();
			System.out.print(m.getMent1_temper());
	    	String request = scan.next().trim().toLowerCase();
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverTemper.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
                	
                	int kind = order.getBeverKind();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(num);
                	
                	System.out.printf("%s(%s)\n", str1, str2);
            		goToNext = true;
            	} else {
            		System.out.println("번호를 다시 입력바랍니다 (1~2)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println(m.getMent6_cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println(m.getMent7_orderAgain());
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
				System.out.println(m.getMent8_numberOnly());
            }
    	}
        order.setBeverTemper(input);

    	return wantToCancel;
    }
}
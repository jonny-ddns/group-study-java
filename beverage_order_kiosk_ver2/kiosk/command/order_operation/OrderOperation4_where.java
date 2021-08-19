package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Order;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverWhere;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.Scanner;

//음료 섭취장소를 입력받는 역할 수행
public class OrderOperation4_where implements OrderOperation {
    @Override
    public boolean execute(Scanner scan) {
    	int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean isCanceled = false;		//리턴 객체
		Order order = OrderCollection.get_orderData();
        
        while(!goToNext) {
			Mention m = new Mention();
	    	System.out.print(m.getMent4_where());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverWhere.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
            		
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	int size = order.getBeverSize();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(shot);
                	String str4 = UnitChange.toString_size(size);
                	String str5 = UnitChange.toString_where(num);

					//출력양식 조정 (커피<->음료)
					if(kind==1 || kind==2){
						System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
					} else{
						System.out.printf("%s(%s/%s)\n", str1, str4, str5);
					}

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
                	isCanceled = true;
                	break;
            	}
            }        
            else {
            	System.out.println(m.getMent8_numberOnly());
            }
    	}
    	order.setBeverWhere(input);

		return isCanceled;
    }
}

package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.receipt.UnitChange;
import beverage_order_kiosk.kiosk.menu_enum.BeverSize;

//음료 크기를 입력받는 역할 수행
public class Operation3_size implements Operation {
    @Override
    public boolean execute(Scanner scan) {
    	int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean wantToCancel = false;	//리턴 객체
		Orders order = OrderCollection.get_orderData();
 	
        while(!goToNext) {
    	
			Mention m = new Mention();
	    	System.out.print(m.getMent3_size());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverSize.values().length;
                
                if(0<num && num<count+1) {
                	input = num;

                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(shot);
                	String str4 = UnitChange.toString_size(num);

					//출력양식 조정 (커피<->음료)
                	if(kind==1 || kind==2){
						System.out.printf("%s(%s/%s/%s)\n", str1, str2, str3, str4);
					} else{
						System.out.printf("%s(%s)\n", str1, str4);
					}

            		goToNext = true;
            	} else {
            		System.out.println("번호를 다시 입력바랍니다 (1~3)");
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
        order.setBeverSize(input);
        
		return wantToCancel;
    }
}

package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverSize;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.Scanner;

//음료 크기를 입력받는 역할 수행
public class OrderOperation3_size implements OrderOperation {
	OrderFunctions orderFunctions;
    @Override
    public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

    	int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean isCanceled = false;	//리턴 객체
		Order order = OrderCollection.get_orderData();
 	
        while(!goToNext) {
	    	System.out.print("\n1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소 c): ");
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = orderFunctions.isNumber(request);
      		
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
        order.setBeverSize(input);
        
		return isCanceled;
    }
}

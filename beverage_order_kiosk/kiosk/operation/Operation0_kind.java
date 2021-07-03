package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.receipt.UnitChange;
import beverage_order_kiosk.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk.kiosk.operation.func.Mention;

public class Operation0_kind implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

        int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean wantToCancel = false;	//리턴 객체
        
        //입력 반복문      	
        while(!goToNext) {
    	
	        //멘트 출력 및 입력값 받기
			Mention m = new Mention();
	    	System.out.print(m.getMent0Choose());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
      		//숫자 입력시
            if(isNumber){
            	//입력한 숫자 변환하기
              	int num = Integer.parseInt(request);
                int count = BeverKind.values().length;
                
                if(0<num && num<count+1) {
                	input = num;

                	//입력 내용 확인
                	String str1 = UnitChange.toString_kind(num);
                	System.out.printf("%s\n", str1);       
                	
            		goToNext = true;
            	} else {
            		System.out.println("번호를 다시 입력바랍니다 (1~6)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println(m.getMent6Cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println(m.getMent7OrderAgain());
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
				System.out.println(m.getMent_NumberOnly());
            }
    	}
        Orders order = OrderCollection.get_orderData();
        order.setBeverKind(input);
    	
    	return wantToCancel;
    }    
}
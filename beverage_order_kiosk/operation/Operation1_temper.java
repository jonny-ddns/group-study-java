package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.customerOrder.Order_data;
import beverage_order_kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.func.CheckRequest;
import beverage_order_kiosk.func.EnumToString;
import beverage_order_kiosk.func.Mention;
import beverage_order_kiosk.menu_enums.BeverTemper;

public class Operation1_temper implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
//    	System.out.println(">>Operation1_temper");
    	
        int input	 		= 0;		//주문내역 저장
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean wantToCancel = false;	//리턴 객체
    	
        //입력 반복문      	
        while(!goToNext) {
    	
	        //멘트 출력 및 입력값 받기
	    	System.out.print(Mention.getMent1Temper());	    	
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
      		//숫자 입력시
            if(isNumber){
            	//입력한 숫자 변환하기
              	int num = Integer.parseInt(request);
                int count = BeverTemper.values().length;
                
                if(0<num && num<count+1) {
//                	System.out.println("request : "+ num);
                	input = num;
                	
                	//입력 내용 확인
                	Order_data order = Order_specifications.get_orderData();
                	int kind = order.getBeverKind();
                	String str1 = EnumToString.strKind(kind);                	
                	String str2 = EnumToString.strTemper(num);
                	
                	System.out.printf("%s(%s)\n", str1, str2);
                	
            		goToNext = true;
            	} else {
            		System.out.println("번호를 다시 입력바랍니다 (1~2)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println(Mention.getMent6Cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
            	System.out.println("숫자를 입력바랍니다");
            }
    	}
    	Order_data order = Order_specifications.get_orderData();
        order.setBeverTemper(input);
        
//    	System.out.println("Operation1_temper - end");
    	return wantToCancel;
    }
}
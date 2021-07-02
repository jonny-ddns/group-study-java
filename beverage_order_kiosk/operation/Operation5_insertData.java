package beverage_order_kiosk.operation;

import java.util.Scanner;

import beverage_order_kiosk.customerOrder.Order_data;
import beverage_order_kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.func.CheckRequest;
import beverage_order_kiosk.func.Mention;

public class Operation5_insertData implements Operation{
	
	@Override
	public boolean execute() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(">>Operation5_insertData");
		
		Order_data order	= Order_specifications.get_orderData();
		
		String request 		= "";		//입력 버튼
		boolean goToNext 	= false;	//반복 플래그 변수
        boolean OrderMore	= false;	//추가 주문 여부 리턴
        
        //주문 내역 받기
        int beverKind	= order.getBeverKind();
        int beverTemper	= order.getBeverTemper();
        int beverShot	= order.getBeverShot();
        int beverSize	= order.getBeverSize();
        int beverWhere	= order.getBeverWhere();
        
//        Func.
		
		System.out.println("---주문내역 출력하기");
		
	   	//추가 주문 확인하기
    	while(!goToNext) {
    		
        	//멘트 출력
        	System.out.print(Mention.getMent5Ordermore());  	
        	request = scan.next().trim().toLowerCase();    	
    		
        	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
	        if(isYesOrNo){
	        	if(request.equals("y")) {
	        		OrderMore = true;
	        	}
	        	goToNext = true;
	        } else {
	        	System.out.println("y 혹은 n을 입력바랍니다");
	        }
    	}
		
		System.out.println("Operation5_insertData - end");
		return OrderMore;
	}
}

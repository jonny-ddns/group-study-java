package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.operation.func.Mention;
public class Operation5_orderMore implements Operation {
	
	@Override
	public boolean execute() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String request 		= "";		//입력 버튼
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean orderMore	= false;	//추가 주문 여부 리턴

		//주문내역 리스트에 저장하기
		Orders data = OrderCollection.get_orderData();
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_orderInfo(data);

        //추가 주문 확인하기
    	while(!goToNext) {
    		
        	//멘트 출력
			Mention m = new Mention();
        	System.out.print(m.getMent5Ordermore());
        	request = scan.next().trim().toLowerCase();    	
    		
        	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
	        if(isYesOrNo){
	        	if(request.equals("y")) {
	        		orderMore = true;
	        	}
	        	goToNext = true;
	        } else {
	        	System.out.println("y 혹은 n을 입력바랍니다");
	        }
    	}
		return orderMore;
	}
}

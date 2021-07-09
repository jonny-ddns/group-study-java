package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.operation.func.Mention;

//추가주문 여부를 입력받는 역할 수행
public class Operation5_orderMore implements Operation {
	
	@Override
	public boolean execute() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String request 		= "";		//입력 버튼
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean orderMore	= false;	//추가 주문 여부 리턴

		//OrderCollection 클래스의 인스턴스 호출
		//-> add_orderInfo() 메서드 호출
		//-> 요청사항 리스트에 삽입하기
		Orders data = OrderCollection.get_orderData();
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_orderInfo(data);

		//추가주문 여부를 받기위한 반복문
    	while(!goToNext) {
    		Mention m = new Mention();
        	System.out.print(m.getMent5_orderMore());
        	request = scan.next().trim().toLowerCase();    	
    		
        	//y or n 입력 확인
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

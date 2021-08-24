package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.Scanner;

//추가주문 여부를 입력받는 역할 수행
public class OrderCommand_6orderMore implements OrderCommand {
	OrderFunctions orderFunctions;
	
	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

		String request;					//입력 버튼
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean orderMore	= false;	//추가 주문 여부 리턴

		//OrderCollection 클래스의 인스턴스 호출
		//-> add_orderInfo() 메서드 호출
		//-> 요청사항 리스트에 삽입하기
		Order data = OrderCollection.get_orderData();
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_orderInfo(data);

		//추가주문 여부를 받기위한 반복문
    	while(!goToNext) {
        	System.out.print("\n추가주문 하시겠습니까? (y/n): ");
        	request = scan.next().trim().toLowerCase();    	
    		
        	//y or n 입력 확인
        	boolean isYesOrNo = orderFunctions.isYesOrNo(request);
	        if(isYesOrNo){
	        	if(request.equals("y")) {
	        		orderMore = true;
	        		int countNow = data.getBeverCount();

	        	}
	        	goToNext = true;
	        } else {
	        	System.out.println("y 혹은 n을 입력바랍니다");
	        }
    	}
		return orderMore;
	}
}

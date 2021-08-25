package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.List;
import java.util.Scanner;

//추가주문 여부를 입력받기
public class OrderCommand_6orderMore implements OrderCommand {
	@Override
	public boolean execute(Scanner scan) {
		System.out.println("OrderCommand_6orderMore - execute");


		List<Order> list = OrderCollection.get_orderList();
		for(Order order : list){
			System.out.println(order.getBeverKind());
			System.out.println(order.getBeverTemper());
			System.out.println(order.getBeverCount());
			System.out.println(order.getBeverWhere());
		}





		boolean orderMore	= false;

		if(checkOrderMore(scan)){
			System.out.println("추가 주문합니다");
			orderMore = true;
		}
//		Order data = OrderCollection.get_orderData();
//		OrderCollection orderCollection = OrderCollection.getInstance();
//		orderCollection.add_orderInfo(data);

		System.out.println("OrderCommand_6orderMore - end");
    	return orderMore;
	}

	//반복문 돌면서 추가주문 물어보기
	private boolean checkOrderMore(Scanner scan){
		OrderFunctions orderFunctions = new OrderFunctions();
		boolean orderMore = false;
		boolean isYesOrNo;
		System.out.println("\n추가주문 하시겠습니까? (y/n): ");

		int count = 0;
		while( count<3 ){
			count++;
			System.out.print("입력 : ");
 			String answer = scan.next().trim().toLowerCase();
			isYesOrNo = orderFunctions.isYesOrNo(answer);
			if(isYesOrNo){
				if(answer.equals("y")) {
					orderMore = true;
				}
				break;
			} else {
				System.out.println("y 혹은 n을 입력바랍니다");
			}
		}
		return orderMore;
	}
}

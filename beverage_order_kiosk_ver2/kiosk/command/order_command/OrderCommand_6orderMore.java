package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.List;
import java.util.Scanner;

//�߰��ֹ� ���θ� �Է¹ޱ�
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
			System.out.println("�߰� �ֹ��մϴ�");
			orderMore = true;
		}
//		Order data = OrderCollection.get_orderData();
//		OrderCollection orderCollection = OrderCollection.getInstance();
//		orderCollection.add_orderInfo(data);

		System.out.println("OrderCommand_6orderMore - end");
    	return orderMore;
	}

	//�ݺ��� ���鼭 �߰��ֹ� �����
	private boolean checkOrderMore(Scanner scan){
		OrderFunctions orderFunctions = new OrderFunctions();
		boolean orderMore = false;
		boolean isYesOrNo;
		System.out.println("\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): ");

		int count = 0;
		while( count<3 ){
			count++;
			System.out.print("�Է� : ");
 			String answer = scan.next().trim().toLowerCase();
			isYesOrNo = orderFunctions.isYesOrNo(answer);
			if(isYesOrNo){
				if(answer.equals("y")) {
					orderMore = true;
				}
				break;
			} else {
				System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
			}
		}
		return orderMore;
	}
}

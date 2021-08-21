package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.Scanner;

//�߰��ֹ� ���θ� �Է¹޴� ���� ����
public class OrderCommand_5orderMore implements OrderCommand {
	OrderFunctions orderFunctions;
	
	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

		String request;					//�Է� ��ư
		boolean goToNext 	= false;	//�ݺ� �÷��� ����
		boolean orderMore	= false;	//�߰� �ֹ� ���� ����

		//OrderCollection Ŭ������ �ν��Ͻ� ȣ��
		//-> add_orderInfo() �޼��� ȣ��
		//-> ��û���� ����Ʈ�� �����ϱ�
		Order data = OrderCollection.get_orderData();
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_orderInfo(data);

		//�߰��ֹ� ���θ� �ޱ����� �ݺ���
    	while(!goToNext) {
        	System.out.print("\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): ");
        	request = scan.next().trim().toLowerCase();    	
    		
        	//y or n �Է� Ȯ��
        	boolean isYesOrNo = orderFunctions.isYesOrNo(request);
	        if(isYesOrNo){
	        	if(request.equals("y")) {
	        		orderMore = true;
	        	}
	        	goToNext = true;
	        } else {
	        	System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
	        }
    	}
		return orderMore;
	}
}

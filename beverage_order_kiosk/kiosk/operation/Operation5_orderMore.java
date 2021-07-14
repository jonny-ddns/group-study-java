package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;

//�߰��ֹ� ���θ� �Է¹޴� ���� ����
public class Operation5_orderMore implements Operation {
	
	@Override
	public boolean execute(Scanner scan) {
		String request 		= "";		//�Է� ��ư
		boolean goToNext 	= false;	//�ݺ� �÷��� ����
		boolean orderMore	= false;	//�߰� �ֹ� ���� ����

		//OrderCollection Ŭ������ �ν��Ͻ� ȣ��
		//-> add_orderInfo() �޼��� ȣ��
		//-> ��û���� ����Ʈ�� �����ϱ�
		Orders data = OrderCollection.get_orderData();
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_orderInfo(data);

		//�߰��ֹ� ���θ� �ޱ����� �ݺ���
    	while(!goToNext) {
    		Mention m = new Mention();
        	System.out.print(m.getMent5_orderMore());
        	request = scan.next().trim().toLowerCase();    	
    		
        	//y or n �Է� Ȯ��
        	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
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

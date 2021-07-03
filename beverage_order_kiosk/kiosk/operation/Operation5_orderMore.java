package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.operation.func.Mention;
public class Operation5_orderMore implements Operation{
	
	@Override
	public boolean execute() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String request 		= "";		//�Է� ��ư
		boolean goToNext 	= false;	//�ݺ� �÷��� ����
		boolean orderMore	= false;	//�߰� �ֹ� ���� ����

		//�ֹ����� ����Ʈ�� �����ϱ�
		Orders data = Order_specifications.get_orderData();
		Order_specifications spec = Order_specifications.getInstance();
		spec.add_orderInfo(data);

        //�߰� �ֹ� Ȯ���ϱ�
    	while(!goToNext) {
    		
        	//��Ʈ ���
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
	        	System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
	        }
    	}
		return orderMore;
	}
}

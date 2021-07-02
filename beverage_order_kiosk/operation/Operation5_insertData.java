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
		
		String request 		= "";		//�Է� ��ư
		boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean OrderMore	= false;	//�߰� �ֹ� ���� ����
        
        //�ֹ� ���� �ޱ�
        int beverKind	= order.getBeverKind();
        int beverTemper	= order.getBeverTemper();
        int beverShot	= order.getBeverShot();
        int beverSize	= order.getBeverSize();
        int beverWhere	= order.getBeverWhere();
        
//        Func.
		
		System.out.println("---�ֹ����� ����ϱ�");
		
	   	//�߰� �ֹ� Ȯ���ϱ�
    	while(!goToNext) {
    		
        	//��Ʈ ���
        	System.out.print(Mention.getMent5Ordermore());  	
        	request = scan.next().trim().toLowerCase();    	
    		
        	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
	        if(isYesOrNo){
	        	if(request.equals("y")) {
	        		OrderMore = true;
	        	}
	        	goToNext = true;
	        } else {
	        	System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
	        }
    	}
		
		System.out.println("Operation5_insertData - end");
		return OrderMore;
	}
}

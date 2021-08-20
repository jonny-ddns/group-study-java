package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Order;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverShot;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.Scanner;

//���� �� ������ �Է¹޴� ���� ����
public class OrderOperation2_shot implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

        int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean isCanceled = false;		//���� ��ü

		//Ŀ�� ������ �ֹ����� �ʾҴٸ� �Ʒ� while �� ������� ����
		Order order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			goToNext = true;
		}
   	
        while(!goToNext) {    	
			System.out.print("\n1.1��(+0��) 2.2��(+500��) ���� (�ֹ���� c): ");
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = orderFunctions.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverShot.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
                	
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(num);
                	
                	System.out.printf("%s(%s/%s)\n", str1, str2, str3);
                	
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~2)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println("\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ");
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = orderFunctions.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                	isCanceled = true;
                	break;
            	}
            }        
            else {
				System.out.println("���ڸ� �Է¹ٶ��ϴ�");
            }
    	}
        order.setBeverShot(input);

		return isCanceled;
	}
}

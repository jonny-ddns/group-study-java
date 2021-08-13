package beverage_order_kiosk_ver2.kiosk.operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Orders;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverTemper;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.Scanner;

//���� �µ��� �Է¹޴� ���� ����
public class Operation1_temper implements Operation {
    @Override
    public boolean execute(Scanner scan) {
        int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü

		//Ŀ�� ������ �ֹ����� �ʾҴٸ� �Ʒ� while �� ������� ����
		Orders order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			goToNext = true;
		}
    	
        while(!goToNext) {
			Mention m = new Mention();
			System.out.print(m.getMent1_temper());
	    	String request = scan.next().trim().toLowerCase();
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverTemper.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
                	
                	int kind = order.getBeverKind();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(num);
                	
                	System.out.printf("%s(%s)\n", str1, str2);
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~2)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println(m.getMent6_cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println(m.getMent7_orderAgain());
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
				System.out.println(m.getMent8_numberOnly());
            }
    	}
        order.setBeverTemper(input);

    	return wantToCancel;
    }
}
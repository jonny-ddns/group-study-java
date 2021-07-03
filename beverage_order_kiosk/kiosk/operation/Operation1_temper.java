package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.receipt.UnitChange;
import beverage_order_kiosk.kiosk.menu_enum.BeverTemper;
import beverage_order_kiosk.kiosk.operation.func.Mention;

public class Operation1_temper implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

        int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
    	
        //�Է� �ݺ���      	
        while(!goToNext) {
    	
	        //��Ʈ ��� �� �Է°� �ޱ�
			Mention m = new Mention();
			System.out.print(m.getMent1Temper());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
      		//���� �Է½�
            if(isNumber){
            	//�Է��� ���� ��ȯ�ϱ�
              	int num = Integer.parseInt(request);
                int count = BeverTemper.values().length;
                
                if(0<num && num<count+1) {
//                	System.out.println("request : "+ num);
                	input = num;
                	
                	//�Է� ���� Ȯ��
                	Orders order = OrderCollection.get_orderData();
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
            	System.out.println(m.getMent6Cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
					System.out.println(m.getMent7OrderAgain());
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
				System.out.println(m.getMent_NumberOnly());
            }
    	}
    	Orders order = OrderCollection.get_orderData();
        order.setBeverTemper(input);

    	return wantToCancel;
    }
}
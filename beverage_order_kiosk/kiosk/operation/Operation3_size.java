package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.operation.func.CheckRequest;
import beverage_order_kiosk.kiosk.receipt.UnitChange;
import beverage_order_kiosk.kiosk.menu_enum.BeverSize;
import beverage_order_kiosk.kiosk.operation.func.Mention;

//���� ũ�⸦ �Է¹޴� ���� ����
public class Operation3_size implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

    	int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
 	
        while(!goToNext) {
    	
			Mention m = new Mention();
	    	System.out.print(m.getMent3Size());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverSize.values().length;
                
                if(0<num && num<count+1) {
                	input = num;

                	Orders order = OrderCollection.get_orderData();
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(shot);
                	String str4 = UnitChange.toString_size(num);
                	
                	System.out.printf("%s(%s/%s/%s)\n", str1, str2, str3, str4);
                	
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~3)");
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
        order.setBeverSize(input);
        
		return wantToCancel;
    }
}

package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Order;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverWhere;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.Scanner;

//���� ������Ҹ� �Է¹޴� ���� ����
public class OrderOperation4_where implements OrderOperation {
    @Override
    public boolean execute(Scanner scan) {
    	int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
		Order order = OrderCollection.get_orderData();
        
        while(!goToNext) {
			Mention m = new Mention();
	    	System.out.print(m.getMent4_where());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverWhere.values().length;
                
                if(0<num && num<count+1) {
                	input = num;
            		
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	int size = order.getBeverSize();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(shot);
                	String str4 = UnitChange.toString_size(size);
                	String str5 = UnitChange.toString_where(num);

					//��¾�� ���� (Ŀ��<->����)
					if(kind==1 || kind==2){
						System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
					} else{
						System.out.printf("%s(%s/%s)\n", str1, str4, str5);
					}

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
    	order.setBeverWhere(input);

		return wantToCancel;    	
    }
}

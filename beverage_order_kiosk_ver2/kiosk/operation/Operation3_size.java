package beverage_order_kiosk_ver2.kiosk.operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Orders;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverSize;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.Scanner;

//���� ũ�⸦ �Է¹޴� ���� ����
public class Operation3_size implements Operation {
    @Override
    public boolean execute(Scanner scan) {
    	int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
		Orders order = OrderCollection.get_orderData();
 	
        while(!goToNext) {
    	
			Mention m = new Mention();
	    	System.out.print(m.getMent3_size());
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverSize.values().length;
                
                if(0<num && num<count+1) {
                	input = num;

                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	String str1 = UnitChange.toString_kind(kind);
                	String str2 = UnitChange.toString_temper(temper);
                	String str3 = UnitChange.toString_shot(shot);
                	String str4 = UnitChange.toString_size(num);

					//��¾�� ���� (Ŀ��<->����)
                	if(kind==1 || kind==2){
						System.out.printf("%s(%s/%s/%s)\n", str1, str2, str3, str4);
					} else{
						System.out.printf("%s(%s)\n", str1, str4);
					}

            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~3)");
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
        order.setBeverSize(input);
        
		return wantToCancel;
    }
}

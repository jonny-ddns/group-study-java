package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.receipt.UnitChange;
import beverage_order_kiosk.kiosk.menu_enum.BeverKind;

//���� ������ �Է¹޴� ���� ����
public class Operation0_kind implements Operation {
    @Override
    public boolean execute(Scanner scan) {
        int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
        //�Է� �ݺ���
        while(!goToNext) {
    	
	        //��Ʈ ��� �� �Է°� �ޱ�
			Mention m = new Mention();
	    	System.out.print(m.getMent0_choose());
	    	String request = scan.next().trim().toLowerCase();
	    	//�Է°��� �������� Ȯ��
      		boolean isNumber = CheckRequest.isNumber(request);
      		
            if(isNumber){
              	int num = Integer.parseInt(request);
                int count = BeverKind.values().length;
                
                //���ڰ� ������ �ش��ϴ��� Ȯ��
                if(0<num && num<count+1) {
                	input = num;

                	//��û���� ����ϱ�
                	String str1 = UnitChange.toString_kind(num);
                	System.out.printf("%s\n", str1);       
                	
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~6)");
            	}         
            }
            //��� �����
            else if(request.equals("c")) {
            	System.out.println(m.getMent6_cancel());
            	
            	//y or n �Է� Ȯ��
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
        //��û���� �ݿ�
        Orders order = OrderCollection.get_orderData();
        order.setBeverKind(input);
    	
    	return wantToCancel;
    }    
}
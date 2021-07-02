package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.customerOrder.Order_data;
import beverage_order_kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.func.CheckRequest;
import beverage_order_kiosk.func.EnumToString;
import beverage_order_kiosk.func.Mention;
import beverage_order_kiosk.menu_enums.BeverKind;

public class Operation0_kind implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
//    	System.out.println(">>Operation0_kind");
    	
        int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
        
        //�Է� �ݺ���      	
        while(!goToNext) {
    	
	        //��Ʈ ��� �� �Է°� �ޱ�
	    	System.out.print(Mention.getMent0Choose());	    	
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
      		//���� �Է½�
            if(isNumber){
            	//�Է��� ���� ��ȯ�ϱ�
              	int num = Integer.parseInt(request);
                int count = BeverKind.values().length;
                
                if(0<num && num<count+1) {
//                	System.out.println("request : "+ num);
                	input = num;

                	//�Է� ���� Ȯ��
                	String str1 = EnumToString.strKind(num);
                	System.out.printf("%s\n", str1);       
                	
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~6)");
            	}         
            }
            else if(request.equals("c")) {
            	System.out.println(Mention.getMent6Cancel());
            	
            	request = scan.next().trim().toLowerCase();
            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
            	
            	if(isYesOrNo && request.equals("y")) {
                	wantToCancel = true;
                	break;
            	}
            }        
            else {
            	System.out.println("���ڸ� �Է¹ٶ��ϴ�");
            }
    	}
        Order_data order = Order_specifications.get_orderData();
        order.setBeverKind(input);
    	
//    	System.out.println("Operation0_kind - end");
    	return wantToCancel;
    }    
}
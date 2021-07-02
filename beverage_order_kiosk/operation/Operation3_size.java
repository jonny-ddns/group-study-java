package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.customerOrder.Order_data;
import beverage_order_kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.func.CheckRequest;
import beverage_order_kiosk.func.EnumToString;
import beverage_order_kiosk.func.Mention;
import beverage_order_kiosk.menu_enums.BeverSize;

public class Operation3_size implements Operation {
    @Override
    public boolean execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
//    	System.out.println(">>Operation3_size");
    	
    	int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean wantToCancel = false;	//���� ��ü
        
        //�Է� �ݺ���      	
        while(!goToNext) {
    	
	        //��Ʈ ��� �� �Է°� �ޱ�
	    	System.out.print(Mention.getMent3Size());	    	
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = CheckRequest.isNumber(request);
      		
      		//���� �Է½�
            if(isNumber){
            	//�Է��� ���� ��ȯ�ϱ�
              	int num = Integer.parseInt(request);
                int count = BeverSize.values().length;
                
                if(0<num && num<count+1) {
//                	System.out.println("request : "+ num);
                	input = num;

                	//�Է� ���� Ȯ��
                	Order_data order = Order_specifications.get_orderData();
                	int kind = order.getBeverKind();
                	int temper = order.getBeverTemper();
                	int shot = order.getBeverShot();
                	String str1 = EnumToString.strKind(kind); 
                	String str2 = EnumToString.strTemper(temper);
                	String str3 = EnumToString.strShot(shot);
                	String str4 = EnumToString.strSize(num);
                	
                	System.out.printf("%s(%s/%s/%s)\n", str1, str2, str3, str4);
                	
            		goToNext = true;
            	} else {
            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~3)");
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
        order.setBeverSize(input);
        
//    	System.out.println("Operation3_size - end");
		return wantToCancel;		
    }    
    
}

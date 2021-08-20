package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverSize;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;
import java.util.Scanner;

//���� ũ�⸦ �Է¹޴� ���� ����
public class OrderOperation3_size implements OrderOperation {
	OrderFunctions orderFunctions;
    @Override
    public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

    	int input	 		= 0;		//�ֹ����� ����
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean isCanceled = false;	//���� ��ü
		Order order = OrderCollection.get_orderData();
 	
        while(!goToNext) {
	    	System.out.print("\n1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ���� c): ");
	    	String request = scan.next().trim().toLowerCase();  
      		boolean isNumber = orderFunctions.isNumber(request);
      		
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
        order.setBeverSize(input);
        
		return isCanceled;
    }
}

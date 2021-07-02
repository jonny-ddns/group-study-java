package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.menu_enums.BeverShot;
import beverage_order_kiosk.menu_enums.Ment;

public class Operation2_shot implements Operation {
	@Override
	public String execute() {
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
    	System.out.println(">>Operation2_shot");
    	
    	String request = "";	//�Է� ��ư
        String beverShot = "";	//���� ��ü
    	
      //��Ʈ ���
    	System.out.print(Ment.getMent2Shot());  	
    	request = scan.next().trim().toLowerCase();    	
    	boolean isNumber = Func.isNumber(request);
    	if(isNumber){
    		BeverShot[] arr = BeverShot.values();
    		int num = Integer.parseInt(request);
        	
        	if(0<num && num<arr.length+1) {
        		System.out.println("request : "+ num);
        		beverShot = arr[num-1].toString();
        		Ment.printOrderCheck();
        	} else {
        		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~2)");
        	}         
        }
        else if(request.equals("c")) {
        	System.out.println("��Ҹ� �Է��Ͽ����ϴ�");
        }        
        else {
        	System.out.println("���ڸ� �Է¹ٶ��ϴ�");
        }
    	System.out.println("Operation2_shot - end");
		return beverShot;
	}
}

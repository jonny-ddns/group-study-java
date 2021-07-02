package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.menu_enums.BeverSize;
import beverage_order_kiosk.menu_enums.Ment;

public class Operation3_size implements Operation {
    @Override
    public String execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
    	System.out.println(">>Operation3_size");
    	
    	String request = "";	//�Է� ��ư
        String beverSize = "";	//���� ��ü
        
    	//��Ʈ ���
    	System.out.print(Ment.getMent0Choose());  	
    	request = scan.next().trim().toLowerCase();    	

    	boolean isNumber = Func.isNumber(request);
        if(isNumber){
        	BeverSize[] arr = BeverSize.values();
        	int num = Integer.parseInt(request);
        	
        	if(0<num && num<arr.length+1) {
        		System.out.println("request : "+ num);
            	beverSize = arr[num-1].toString();
        		Ment.printOrderCheck();
        	} else {
        		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~3)");
        	}         
        } 
        else if(request.equals("c")) {
        	System.out.println("��Ҹ� �Է��Ͽ����ϴ�");
        }        
        else {
        	System.out.println("���ڸ� �Է¹ٶ��ϴ�");
        }
    	
    	System.out.println("Operation3_size - end");
		return beverSize;		
    }    
    
}

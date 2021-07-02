package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.menu_enums.BeverKind;
import beverage_order_kiosk.menu_enums.Ment;

public class Operation0_kind implements Operation {
    @Override
    public String execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
    	System.out.println(">>Operation0_kind");
    	
    	String request = "";	//�Է� ��ư
        String beverKind = "";	//���� ��ü
        
    	//��Ʈ ���
    	System.out.print(Ment.getMent0Choose());  	
    	request = scan.next().trim().toLowerCase();    	

    	boolean isNumber = Func.isNumber(request);
        if(isNumber){
        	BeverKind[] arr = BeverKind.values();
        	int num = Integer.parseInt(request);
        	
        	if(0<num && num<arr.length+1) {
        		System.out.println("request : "+ num);
        		beverKind = arr[num-1].toString();
        		Ment.printOrderCheck();
        	} else {
        		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~6)");
        	}         
        } 
        else if(request.equals("c")) {
        	System.out.println("��Ҹ� �Է��Ͽ����ϴ�");
        }        
        else {
        	System.out.println("���ڸ� �Է¹ٶ��ϴ�");
        }
    	
    	System.out.println("Operation0_kind - end");
		return beverKind;		
    }    
}

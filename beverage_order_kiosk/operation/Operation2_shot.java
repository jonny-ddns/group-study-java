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
    	
    	String request = "";	//입력 버튼
        String beverShot = "";	//리턴 객체
    	
      //멘트 출력
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
        		System.out.println("번호를 다시 입력바랍니다 (1~2)");
        	}         
        }
        else if(request.equals("c")) {
        	System.out.println("취소를 입력하였습니다");
        }        
        else {
        	System.out.println("숫자를 입력바랍니다");
        }
    	System.out.println("Operation2_shot - end");
		return beverShot;
	}
}

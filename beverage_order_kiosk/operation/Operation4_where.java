package beverage_order_kiosk.operation;

import java.util.Scanner;
import beverage_order_kiosk.menu_enums.BeverWhere;
import beverage_order_kiosk.menu_enums.Ment;

public class Operation4_where implements Operation {
    @Override
    public String execute() {
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
    	System.out.println(">>Operation4_where");
    	
    	String request = "";	//입력 버튼
        String beverWhere = "";	//리턴 객체
        
    	//멘트 출력
    	System.out.print(Ment.getMent4Where());  	
    	request = scan.next().trim().toLowerCase();    	

    	boolean isNumber = Func.isNumber(request);
        if(isNumber){
        	BeverWhere[] arr = BeverWhere.values();
        	int num = Integer.parseInt(request);
        	
        	if(0<num && num<arr.length+1) {
        		System.out.println("request : "+ num);
        		beverWhere = arr[num-1].toString();
        		Ment.printOrderCheck();
        	} else {
        		System.out.println("번호를 다시 입력바랍니다 (1~6)");
        	}         
        } 
        else if(request.equals("c")) {
        	System.out.println("취소를 입력하였습니다");
        }        
        else {
        	System.out.println("숫자를 입력바랍니다");
        }
    	
    	System.out.println("Operation0_kind - end");
		return beverWhere;    	
    }
}

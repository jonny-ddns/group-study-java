package beverage_order_kiosk.operation;

import beverage_order_kiosk.customerOrder.Order_specifications;

public class Operation1_kind implements Operation {
    @Override
    public void execute(String request) {
    	System.out.println("Operation1_kind");
        System.out.println("입력값 : "+ request);
        
        Order_specifications orderSpec = Order_specifications.get_orderSpec();
       
        boolean isNumber = isNumber(request);
        if(isNumber){
            int a = Integer.parseInt(request);         
            
            switch(a) {
            
            
            case 1:
            	System.out.println("request : 1");
            	System.out.println("아메리카노");            	
            	break;
            case 2:
            	System.out.println("request : 2");
            	System.out.println("바닐라라떼");
            	break;
            case 3:
            	System.out.println("request : 3");
            	System.out.println("레몬에이드");
            	break;
            case 4:
            	System.out.println("request : 4");
            	System.out.println("자몽에이드");
            	break;
            case 5:
            	System.out.println("request : 5");
            	System.out.println("수박주스");
            	break;
            case 6:
            	System.out.println("request : 6");
            	System.out.println("토마토주스");
            	break;
            default:
            	System.out.println("request : 번호를 초과하였음. 그런 메뉴는 없음");
            	break;
            	
            }

        } else {
        	System.out.println("숫자를 입력바랍니다");
        }
    }
    
    boolean isNumber(String request){
        boolean isNum = false;
        try{
          Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException nfe){
            nfe.getMessage();
        } catch (Exception e){
            e.getMessage();
        }
        return isNum;
    }
}

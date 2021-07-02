package beverage_order_kiosk.kiosk;

import java.util.Calendar;
import java.util.List;
import beverage_order_kiosk.customerOrder.Order_data;
import beverage_order_kiosk.customerOrder.Order_specifications;
import beverage_order_kiosk.menu_enums.Menu;
import beverage_order_kiosk.operation.Operation;
import beverage_order_kiosk.operation.Operation0_kind;
import beverage_order_kiosk.operation.Operation1_temper;
import beverage_order_kiosk.operation.Operation2_shot;
import beverage_order_kiosk.operation.Operation3_size;
import beverage_order_kiosk.operation.Operation4_where;
import beverage_order_kiosk.operation.Operation5_insertData;

public class KioskOrder {
    String[] ments = null;
    
    boolean wantToCancel = false;
    boolean orderMore = true;
    
    KioskOrder() {    	
    	System.out.println("ORDER START!\n");
        start();
    }
    
    private void start() {   	
    	while(orderMore) {
        	Menu beverage = new Menu();
            beverage.printMenu();
    		
    		boolean more = receiveOrder();
    		orderMore = more;
    	}
    	
    	//주문내역 출력하기
    	String invoice = printCustomerOrder();
    	System.out.println(invoice);
    }
    
    private boolean receiveOrder() {
        while (!wantToCancel) {        	
        	Operation oper = null;
        	
            for (int index=0; index<6; index ++) {
            	
                switch (index) {                
                    case 0:
                        oper = new Operation0_kind();
                        wantToCancel = oper.execute();
                        if(wantToCancel == true) {	break; }   
                        break;
                        
                    case 1:
                        oper = new Operation1_temper();
                        wantToCancel = oper.execute();
                        if(wantToCancel == true) {	break; }   
                        break;
                        
                    case 2:
                        oper = new Operation2_shot();
                        wantToCancel = oper.execute();
                        if(wantToCancel == true) {	break; }   
                        break;
                        
                    case 3:
                        oper = new Operation3_size();
                        wantToCancel = oper.execute();
                        if(wantToCancel == true) {	break; }   
                        break;
                        
                    case 4:
                        oper = new Operation4_where();
                        wantToCancel = oper.execute();
                        if(wantToCancel == true) {	break; } 
                        break;
                        
                    case 5:
                        oper = new Operation5_insertData();
                        orderMore = oper.execute();
                        wantToCancel = true;
                        break; 
                    default:
                        System.out.println("swich - error");
                        break;
                }
            }
        }
        return orderMore;
    }
    
    //주문내역 출력하기
    private String printCustomerOrder() {
    	System.out.println("--최종주문 내역을 출력하기");
    	
    	Calendar cal = Calendar.getInstance();
    	String customerNum = null;
    	String month = Integer.toString(cal.get(2));  
    	String day = Integer.toString(cal.get(3));
    	String hour = Integer.toString(cal.get(11));
    	customerNum = month+ day+ hour;
    	
    	
    	
    	
    	
    	
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("====================\n");
    	sb.append("\t"+ customerNum+ "\n");
    	
    	sb.append("========결제내역=========\n");
    	sb.append("품목\t수량\t금액\n");
    	
    	List<Order_data> orders = Order_specifications.get_orderList();
    	for(Order_data order: orders) {
    		int kind = order.getBeverKind();
    		int temper = order.getBeverTemper();
    		int shot = order.getBeverShot();
    		int size = order.getBeverSize();
    		int where = order.getBeverWhere();
    		
    		sb.append(kind);
    		sb.append(temper);
    		sb.append(shot);
    		sb.append(size);
    		sb.append(where);
    		System.out.println("-----------");
    	}
    	sb.append("합계\t\t\t\n");
    	sb.append("====================");
    	
    	return sb.toString();
    }
}
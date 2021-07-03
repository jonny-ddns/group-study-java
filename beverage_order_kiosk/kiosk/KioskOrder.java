package beverage_order_kiosk.kiosk;

import beverage_order_kiosk.kiosk.operation.*;
import beverage_order_kiosk.kiosk.receipt.CreateReceipt;
import beverage_order_kiosk.kiosk.menu_enums.BeverKind;
import beverage_order_kiosk.kiosk.menu_enums.Pricing;
import beverage_order_kiosk.kiosk.menu_enums.����;

public class KioskOrder {

    boolean wantToCancel = false;
    boolean orderMore = true;
    boolean orderCheck = true;
    
    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
        start();
    }
    
    private void start() {
        int count = 0;

        while (orderMore) {
            printMenu();
            wantToCancel    = false;
            orderMore       = receiveOrder();
            count++;
        }

        //�ֹ����� Ȯ���ϱ�
        if(orderCheck == true){
            //�ֹ����� ����ϱ�
            new CreateReceipt(count);
        } else {
            this.start();
        }
    }
    
    private boolean receiveOrder() {
        while (!wantToCancel) {
        	Operation oper = null;
        	
            for (int index=0; index<7; index ++) {
            	
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
                        oper = new Operation5_orderMore();
                        orderMore = oper.execute();
//                        wantToCancel = true;
                        break;

                    case 6:
                        oper = new Operation6_orderCheck();
                        orderCheck = oper.execute();
                        wantToCancel = true;
                        break;
                }
            }
        }
        return orderMore;
    }
        
    //�޴� ����Ʈ
	private void printMenu() {
		����[] ����迭	= ����.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		
		System.out.println("----------------------");
		System.out.println("�޴�");
		for(int i=0; i<BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d��\n", i+1, ����迭[i], priceArr[i]);
		}
		System.out.println("----------------------");
	}
}
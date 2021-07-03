package beverage_order_kiosk.kiosk;

import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk.kiosk.menu_enum.Pricing;
import beverage_order_kiosk.kiosk.menu_enum.����;
import beverage_order_kiosk.kiosk.operation.*;
import beverage_order_kiosk.kiosk.receipt.CreateReceipt;

public class KioskOrder {

    boolean wantToCancel = false;
    boolean orderMore = true;
    boolean orderCheck = true;
    
    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
        start();
    }

    private void start() {
        wantToCancel = false;
        orderMore = true;
        orderCheck = true;
        int count = 0;

        while (orderMore) {
        	wantToCancel    = false;
            orderMore       = receiveOrder();
            count++;
        }

        //�ֹ����� Ȯ���ϱ�
        if(orderCheck == true){
            //�ֹ����� ����ϱ�
            new CreateReceipt(count);
        } else {
        	orderMore = true;
        	orderCheck = true;
        	this.start();
        }
    }
    
    private boolean receiveOrder() {

        while (!wantToCancel) {
            printMenu();
        	Operation oper = null;

            oper = new Operation0_kind();
            wantToCancel = oper.execute();
            if(wantToCancel) { reset(); break; }

            oper = new Operation1_temper();
            wantToCancel = oper.execute();
            if(wantToCancel) { reset(); break; }

            oper = new Operation2_shot();
            wantToCancel = oper.execute();
            if(wantToCancel) { reset(); break; }

            oper = new Operation3_size();
            wantToCancel = oper.execute();
            if(wantToCancel) { reset(); break; }

            oper = new Operation4_where();
            wantToCancel = oper.execute();
            if(wantToCancel) { reset(); break; }

            oper = new Operation5_orderMore();
            orderMore = oper.execute();

            if(!orderMore) {
                oper = new Operation6_orderCheck();
                orderCheck = oper.execute();
                wantToCancel = true;
            }
        }
        return orderMore;
    }

    private void reset(){
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //�޴� ����Ʈ
	private void printMenu() {
		����[] ����迭	= ����.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		
		System.out.println("----------------------");
		System.out.println("�޴�");
		for(int i = 0; i<BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d��\n", i+1, ����迭[i], priceArr[i]);
		}
		System.out.println("----------------------");
	}
}
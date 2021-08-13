package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk_ver2.kiosk.menu_enum.Pricing;
import beverage_order_kiosk_ver2.kiosk.menu_enum.����;
import beverage_order_kiosk_ver2.kiosk.operation.*;
import beverage_order_kiosk_ver2.kiosk.receipt.CreateReceipt;

import java.util.Scanner;

public class KioskOrder {

    boolean wantToCancel = false;	//�ֹ���� ����
    boolean orderMore = true;		//�߰��ֹ� ����
    boolean orderCheck = true;		//�ֹ�Ȯ�� ���
    
    //constructor. ������ ���ÿ� start() �޼��� ȣ��
    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
        start();
    }

    //�ֹ��ް�(receiveOrder) �������� ���(CreateReceipt)�ϴ� �޼��� ȣ��
    private void start() {

        wantToCancel= false;
        orderMore = true;
        orderCheck = true;
        int count = 0;

        //�߰��ֹ� ����
        while (orderMore) {
          	wantToCancel        = false;
        	boolean[] boolArr   = receiveOrder();
            orderMore           = boolArr[0];

            //�ֹ����� ����
            if(!boolArr[1]){
                count++;
            }
        }
        //�ֹ�Ȯ�� ���
        if(orderCheck){
            new CreateReceipt(count);
        } else {
        	orderMore = true;
        	orderCheck = true;
        	this.start();
        }
    }
    
    //Operation �������̽� ������ü�� ȣ���Ͽ� �ֹ��ޱ�
    private boolean[] receiveOrder() {
        Scanner scan = new Scanner(System.in);

        boolean[] booleans = new boolean[2];
        while (!wantToCancel) {
            printMenu();
        	Operation oper = null;

        	//���� ����
            oper = new Operation0_kind();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� �µ�
            oper = new Operation1_temper();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� ��
            oper = new Operation2_shot();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� ũ��
            oper = new Operation3_size();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� �������
            oper = new Operation4_where();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            oper = new Operation5_orderMore();
            orderMore = oper.execute(scan);

            //�߰��ֹ��� ��ġ �ʴ´ٸ�
            if(!orderMore) {
                oper = new Operation6_orderCheck();
                orderCheck = oper.execute(scan);
                break;
            }
        }
        booleans[0] = orderMore;
        booleans[1] = wantToCancel;
        return booleans;
    }

    //�ֹ���ҽ� List�� null�� ����
    private void reset(){
        System.out.println("reset ȣ��");
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //�޴� ���
	private void printMenu() {
		����[] ����迭		= ����.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		
		System.out.println("----------------------");
		System.out.println("�޴�");
		for(int i = 0; i< BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d��\n", i+1, ����迭[i], priceArr[i]);
		}
		System.out.println("----------------------");
	}
}
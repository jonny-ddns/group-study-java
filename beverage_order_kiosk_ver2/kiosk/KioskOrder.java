package beverage_order_kiosk_ver2.kiosk;

import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_isMember;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signIn;
import beverage_order_kiosk_ver2.kiosk.command.member_operation.MemberOperation_signUp;
import beverage_order_kiosk_ver2.kiosk.command.order_operation.*;
import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk_ver2.kiosk.menu_enum.Pricing;
import beverage_order_kiosk_ver2.kiosk.menu_enum.����;
import beverage_order_kiosk_ver2.kiosk.receipt.CreateReceipt;
import java.util.Scanner;

public class KioskOrder {
    private final Scanner scan;

    protected KioskOrder() {    	
    	System.out.println("ORDER START!\n");
    	scan = new Scanner(System.in);
        orderStart();
    }
    
    private void orderStart() {
        boolean orderMore = true;		//�߰��ֹ� ����
        boolean orderCheck = true;		//�ֹ�Ȯ�� ���

        int count = 0;
        
        /*
        �ڵ���� 
        �ֹ���� -> ��ҵǸ� �ٽ� ó������
        �ֹ����� -> �ּҵǸ� �ٽ� ó������
        
        �ֹ����� �ݺ������� ��� �߰��ֹ� �޾ƾ� ��
        �߰��ֹ� Ƚ�� �ޱ�
         */

        boolean isCanceled = false;
        while(!isCanceled){

            //�ֹ���� ����
            int result_orderDecide = 0;
            result_orderDecide = orderWayDecide();
            System.out.println("result_orderDecide : "+ result_orderDecide);

            if(result_orderDecide == 0){
                continue;
            }
            
            //�ֹ����� �ޱ�
            boolean[] result_receiveOrder = receiveOrder();

            System.out.println("��ҿ���/ �߰��ֹ�����/ �ֹ�Ȯ�ο���");
            for(boolean b : result_receiveOrder){
                System.out.print(b+ "\t");
            }

            //�ֹ� ��ҽ�
            if(!result_receiveOrder[0]){
                continue;
            }

            System.out.println("�ݺ��� ����");
            isCanceled = true;
        }


          //�߰��ֹ����� ���� ������ �ݺ�
//        while(orderMore) {
//
//
//        	//�����

//
//            orderMore                  = receiveResults[0];
//
//            //�ֹ����� ����
//            if(!receiveResults[1]){
//                count++;
//            }
//        }
        //�ֹ�Ȯ�� ���
        if(orderCheck){
            new CreateReceipt(count);
            scan.close();
        } else {

        	this.orderStart();
        }
    }

    /*
    #���ϰ��� ���� �б�
    .�ֹ���� - 0��� / 1ȸ�� / 2��ȸ��
    .�α��� - 0��� / 1�α��� / 2ȸ������
    .ȸ������ - 0��� / 1���ԿϷ�

    #����; 0��� 1ȸ�� 2��ȸ��
    */
    private int orderWayDecide(){
        System.out.println("orderWayDecide");

        MemberOperation memberOperation;
        int result_orderDecide = 0; //���ϰ�
        int result_isMember;
        int result_signIn;

        //�ֹ���� ���ϱ� - ȸ��1 /��ȸ��2
        memberOperation = new MemberOperation_isMember();
        result_isMember = memberOperation.execute(scan);

        //��ȸ���ֹ�
        if(result_isMember == 2 ){
            result_orderDecide = 2;
        }
        //ȸ���ֹ�
        else if(result_isMember == 1) {
            memberOperation = new MemberOperation_signIn();
            result_signIn = memberOperation.execute(scan);

            //�α���
            if(result_signIn == 1){
                result_orderDecide = 1;
            }
            //ȸ������
            else if(result_signIn == 2){
                memberOperation = new MemberOperation_signUp();
                memberOperation.execute(scan);
                result_orderDecide = 1;
            }
        }
        System.out.println("orderWayDecide end");
        return result_orderDecide;
    }

    //�ֹ����� �ޱ�
    private boolean[] receiveOrder() {
        boolean[] result_receiveOrder = new boolean[3];
        boolean wantToCancel = false;
        boolean orderMore = false;
        boolean orderCheck = false;
        OrderOperation orderOperation;
        
        //while �� ���� �ٸ� ������� �ڵ��ϱ�
        while (!wantToCancel) {
            printMenu();

            //���� ����
            orderOperation = new OrderOperation0_kind();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� �µ�
            orderOperation = new OrderOperation1_temper();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� ��
            orderOperation = new OrderOperation2_shot();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� ũ��
            orderOperation = new OrderOperation3_size();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

        	//���� �������
            orderOperation = new OrderOperation4_where();
            wantToCancel = orderOperation.execute(scan);
            if(wantToCancel) { reset(); break; }

            orderOperation = new OrderOperation5_orderMore();
            orderMore = orderOperation.execute(scan);

            //�߰��ֹ��� ��ġ �ʴ´ٸ�
            if(!orderMore) {
                orderOperation = new OrderOperation6_orderCheck();
                orderCheck = orderOperation.execute(scan);
                if(!orderCheck){ reset(); break; }
            }
        }
        result_receiveOrder[0] = wantToCancel;
        result_receiveOrder[1] = orderMore;
        result_receiveOrder[2] = orderCheck;
        return result_receiveOrder;
    }

    //�ֹ���ҽ� List�� �ʱ�ȭ�ϴ� �޼��� ȣ��
    private void reset(){
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //�޴� ���
	private void printMenu() {
		����[] ����迭	= ����.values();
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
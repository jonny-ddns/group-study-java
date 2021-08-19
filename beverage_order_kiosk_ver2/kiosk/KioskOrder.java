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
    
    //�ֹ��ޱ�
    private void orderStart() {
        int result_orderWay = 0;    //�ֹ����- ���/ȸ��/��ȸ��
        int count;                  //�ֹ�����
        
        while(result_orderWay == 0) {
            //1. �ֹ���� ����
            result_orderWay = receiveOrderWay();
            System.out.println("result_orderWay : " + result_orderWay);

            //2. �ֹ��ޱ�
            int[] result_receiveOrder = receiveOrder();
            int resultSignal = result_receiveOrder[0];
            count = result_receiveOrder[1];

            //�ֹ���ҽ�
            if (resultSignal != 0) {
            } else {
            }

            //������ ���
            new CreateReceipt(count);
            scan.close();

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
    private int receiveOrderWay(){
        System.out.println("receiveOrderWay");

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
        System.out.println("receiveOrderWay end");
        return result_orderDecide;
    }

    //�ֹ����� �ޱ�
    private int[] receiveOrder() {
        int[] result_receiveOrder;      //���ϰ�ü
        int count = 1;                  //�ֹ�����
        int resultSignal = 0;           //�ֹ���ȣ
        boolean orderProgress = true;    //�÷���

        OrderOperation orderOperation;

        while (orderProgress) {
            printMenu();
            //���� ����
            orderOperation = new OrderOperation0_kind();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//���� �µ�
            orderOperation = new OrderOperation1_temper();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//���� ��
            orderOperation = new OrderOperation2_shot();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//���� ũ��
            orderOperation = new OrderOperation3_size();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
        	//���� �������
            orderOperation = new OrderOperation4_where();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //�߰��ֹ� ����� �ֹ��� �ޱ�
            orderOperation = new OrderOperation5_orderMore();
            if(!orderOperation.execute(scan)) {
                //�߰��ֹ� ������ �����ֹ� Ȯ���ϱ�
                orderOperation = new OrderOperation6_orderCheck();
                if(orderOperation.execute(scan)){
                    resultSignal = 1;
                    orderProgress = false;
                } else {
                    reset();
                    orderProgress = false;
                }
            }
            count++;
        }
        //�ֹ���� (�����ȣ, �ֹ�����)
        result_receiveOrder = new int[]{resultSignal, count};
        return result_receiveOrder;
    }

    //�ֹ���ҽ� �ֹ����� reset
    private void reset(){
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
        
    //�޴� ���
	private void printMenu() {
		����[] ����迭	= ����.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		String line     = "----------------------";
		
		System.out.println(line);
		System.out.println("�޴�");
		for(int i = 0; i< BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d��\n", i+1, ����迭[i], priceArr[i]);
		}
        System.out.println(line);
    }
}
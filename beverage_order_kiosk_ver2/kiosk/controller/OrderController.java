package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order_operation.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;

import java.util.Scanner;

public class OrderController implements Controller{
    @Override
    public int control(Scanner scan) {
        return 0;
    }

    private void reset(){
        OrderCollection orderCollection = OrderCollection.getInstance();
        orderCollection.reset_orderInfo();
    }

    private int[] receiveOrderMenu(Scanner scan) {

        int[] result_receiveOrder;      //���ϰ�ü
        int count = 0;                  //�ֹ�����
        int resultSignal = 0;           //�ֹ���ȣ (���0 �ֹ�1)
        boolean orderProgress = true;   //�÷���

        OrderOperation orderOperation;

        while (orderProgress) {
//            printMenu();
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
                } else {
                    reset();
                }
                orderProgress = false;
            }
            count++;
        }
        //�ֹ���� (�����ȣ, �ֹ�����)
        result_receiveOrder = new int[]{resultSignal, count};
        return result_receiveOrder;
    }



}

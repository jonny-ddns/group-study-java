package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order_command.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import java.util.Scanner;

public class OrderController implements Controller{
    @Override
    public int control(Scanner scan) {
        int result_receiveOrder;        //���ϰ�ü
        int count = 0;                  //�ֹ�����
        int resultSignal = 0;           //�ֹ���ȣ (���0 �ֹ�1)
        boolean orderProgress = true;   //�÷���

        OrderCommand orderCommand;

        while (orderProgress) {
//            printMenu();
            //���� ����
            orderCommand = new OrderCommand_0kind();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //���� �µ�
            orderCommand = new OrderCommand_2temper();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //���� ��
            orderCommand = new OrderCommand_3shot();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //���� ũ��
            orderCommand = new OrderCommand_4size();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //���� �������
            orderCommand = new OrderCommand_5where();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //�߰��ֹ� ����� �ֹ��� �ޱ�
            orderCommand = new OrderCommand_6orderMore();
            if(!orderCommand.execute(scan)) {
                //�߰��ֹ� ������ �����ֹ� Ȯ���ϱ�
                orderCommand = new OrderCommand_7orderCheck();
                if(orderCommand.execute(scan)){
                    resultSignal = 1;
                } else {
                    reset();
                }
                orderProgress = false;
            }
            count++;
        }
        //�ֹ���� (�����ȣ, �ֹ�����)
        result_receiveOrder = resultSignal;
        return result_receiveOrder;
    }

    private void reset(){
        OrderCollection orderCollection = OrderCollection.getInstance();
        orderCollection.reset_orderInfo();
    }
}

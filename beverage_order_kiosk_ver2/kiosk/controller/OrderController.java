package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;

public class OrderController extends ControllerFunctions implements Controller{

    //�Է°� �ݿ��ϱ�
    int input_kind = 0;
    int input_count = 0;
    int input_temper = 0;
    int input_shot = 0;
    int input_size = 0;
    int input_where = 0;

    @Override
    public int control(Scanner scan) {
        System.out.println("OrderController - control");
        int result_receiveOrder;        //���ϰ�ü

        int resultSignal = 0;
        boolean isCanceled = getRequest(scan);
        if(!isCanceled){
            resultSignal = 1;
            save(setOrderInfo());
        }

        //�ֹ���� (�����ȣ, �ֹ�����)
        result_receiveOrder = resultSignal;
        return result_receiveOrder;
    }

    //���ʷ� �ֹ����� �ޱ�
    private boolean getRequest(Scanner scan){
        OrderCommand orderCommand;
        boolean isCanceled = true;  //�ֹ���ȣ (���0 �ֹ�1)
        int[] answerArr;

        boolean orderProgress = true;   //�÷���
        while (orderProgress) {
            //���� ����
            orderCommand = new OrderCommand_0_kind();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_kind = answerArr[1];
            }

            //���� ����
            orderCommand = new OrderCommand_1_Count();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_count = answerArr[1];
            }

            //���� �µ�
            orderCommand = new OrderCommand_2_temper();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_temper = answerArr[1];
            }

            //���� ��
            orderCommand = new OrderCommand_3_shot();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_shot = answerArr[1];
            }

            //���� ũ��
            orderCommand = new OrderCommand_4_size();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_size = answerArr[1];
            }

            //���� �������
            orderCommand = new OrderCommand_5_where();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_where = answerArr[1];
            }

            //�߰��ֹ�
            orderCommand = new OrderCommand_20_orderMore();
            answerArr = orderCommand.execute(scan);

            //�߰��ֹ� ���� Ȯ��
            if(!intToBoolean(answerArr[0])) {
                //�߰��ֹ� ������ �����ֹ� Ȯ���ϱ�
                orderCommand = new OrderCommand_10_orderCheck();
                answerArr = orderCommand.execute(scan);
                //�ֹ� Ȯ����
                if(intToBoolean(answerArr[0])){
                    isCanceled = false;
                }
                orderProgress = false;
            }
        }
        return isCanceled;
    }

    //�ѹ��� setting �ؼ� �����ϱ�
    private Order setOrderInfo(){
        Order order = new Order();
        order.setBeverKind(input_kind)
                .setBeverCount(input_count)
                .setBeverTemper(input_temper)
                .setBeverShot(input_shot)
                .setBeverSize(input_size)
                .setBeverWhere(input_where);
        return order;
    }

    private void save(Order order){
        Collection<Order> collection = OrderInfos.getOrderCollection();
        collection.add(order);
    }

    @Override
    public boolean intToBoolean(int i) {
        return super.intToBoolean(i);
    }

}



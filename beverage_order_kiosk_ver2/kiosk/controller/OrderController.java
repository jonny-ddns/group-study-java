package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order_command.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class OrderController implements Controller{

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
        boolean isCanceled = getOrder(scan);
        if(!isCanceled){
            resultSignal = 1;
            addToList(setOrderData());
        }

        //�ֹ���� (�����ȣ, �ֹ�����)
        result_receiveOrder = resultSignal;
        return result_receiveOrder;
    }


    private boolean getOrder(Scanner scan){
        OrderCommand orderCommand;
        boolean isCanceled = true;  //�ֹ���ȣ (���0 �ֹ�1)
        int[] answerArr;

        boolean orderProgress = true;   //�÷���
        while (orderProgress) {
            //���� ����
            orderCommand = new OrderCommand_0kind();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_kind = answerArr[1];
            }

            orderCommand = new OrderCommand_1Count();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_count = answerArr[1];
            }

            //���� �µ�
            orderCommand = new OrderCommand_2temper();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_temper = answerArr[1];
            }

            //���� ��
            orderCommand = new OrderCommand_3shot();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_shot = answerArr[1];
            }

            //���� ũ��
            orderCommand = new OrderCommand_4size();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_size = answerArr[1];
            }

            //���� �������
            orderCommand = new OrderCommand_5where();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_where = answerArr[1];
            }

            //�߰��ֹ�
            orderCommand = new OrderCommand_6orderMore();
            answerArr = orderCommand.execute(scan);

            //�߰��ֹ� ���� Ȯ��
            if(!intToBoolean(answerArr[0])) {
                //�߰��ֹ� ������ �����ֹ� Ȯ���ϱ�
                orderCommand = new OrderCommand_7orderCheck();
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
    private Order setOrderData(){
        Order order = OrderInfos.get_orderData();
        order.setBeverKind(input_kind)
                .setBeverCount(input_count)
                .setBeverTemper(input_temper)
                .setBeverShot(input_shot)
                .setBeverSize(input_size)
                .setBeverWhere(input_where);
        return order;
    }

    private Collection<Order> addToList(Order order){
        Collection<Order> collection = OrderInfos.getOrderCollection();
        collection.add(order);
        return collection;
    }

    private boolean intToBoolean(int i){
        boolean answer = i == 1;
        return answer;
    }
}



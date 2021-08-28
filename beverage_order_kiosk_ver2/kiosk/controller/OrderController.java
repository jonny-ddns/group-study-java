package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;

public class OrderController extends ControllerFunctions implements Controller{
    private OrderCommand orderCommand;

    //입력값 반영하기
    int input_kind = 0;
    int input_count = 0;
    int input_temper = 0;
    int input_shot = 0;
    int input_size = 0;
    int input_where = 0;

    @Override
    public int control(Scanner scan) {
        System.out.println("OrderController - control");

        int[] answerArr;
        int resultSignal = 0;
        boolean orderFinish = false;
        boolean isCanceled;
        boolean isChecked;
        boolean orderMore;

        while (!orderFinish){
            //주문 받기
            isCanceled = getRequest_order(scan);
            //주문내역에 반영하기
            if(!isCanceled) {
                save(setOrderInfo());
            }

            //1) 추가주문 확인
            answerArr = getRequest_orderMore(scan);
            isCanceled = intToBoolean(answerArr[0]);
            orderMore = intToBoolean(answerArr[1]);

            //주문취소
            if(isCanceled) {
                System.out.println("주문 취소되었습니다");
                break;
            }

            //추가주문
            if(orderMore){
                continue;
            }

            //2) 주문확인
            answerArr = getRequest_orderCheck(scan);
            isChecked = intToBoolean(answerArr[0]);
            if(isChecked){
                resultSignal = 1;
                orderFinish = true;
            }
        }
        return resultSignal;
    }

    //차례로 주문정보 받기
    private boolean getRequest_order(Scanner scan){
        int[] answerArr;
        boolean isCanceled = true;      //주문신호 (취소0 주문1)
        boolean orderProgress = true;   //플래그

        while (orderProgress) {
            //음료 종류
            orderCommand = new OrderCommand_0_kind();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_kind = answerArr[1];
            }

            //음료 종류
            orderCommand = new OrderCommand_1_Count();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_count = answerArr[1];
            }

            //음료 온도
            orderCommand = new OrderCommand_2_temper();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_temper = answerArr[1];
            }

            //음료 샷
            orderCommand = new OrderCommand_3_shot();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_shot = answerArr[1];
            }

            //음료 크기
            orderCommand = new OrderCommand_4_size();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_size = answerArr[1];
            }

            //음료 섭취장소
            orderCommand = new OrderCommand_5_where();
            answerArr = orderCommand.execute(scan);
            if(intToBoolean(answerArr[0])) {
                break;
            } else {
                input_where = answerArr[1];
            }
            isCanceled = false;
            orderProgress = false;
        }
        return isCanceled;
    }

    //추가주문 받기
    private int[] getRequest_orderMore(Scanner scan){
        //추가주문
        orderCommand = new OrderCommand_10_orderMore();
        return orderCommand.execute(scan);
    }

    //주문확인 받기
    private int[] getRequest_orderCheck(Scanner scan){
        orderCommand = new OrderCommand_20_orderCheck();
        return orderCommand.execute(scan);
    }

    //한번에 setting 해서 대입하기
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
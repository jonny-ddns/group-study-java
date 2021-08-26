package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;

public class OrderController extends ControllerFunctions implements Controller{

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
        int result_receiveOrder;        //리턴객체

        int resultSignal = 0;
        boolean isCanceled = getRequest(scan);
        if(!isCanceled){
            resultSignal = 1;
            save(setOrderInfo());
        }

        //주문결과 (결과번호, 주문개수)
        result_receiveOrder = resultSignal;
        return result_receiveOrder;
    }

    //차례로 주문정보 받기
    private boolean getRequest(Scanner scan){
        OrderCommand orderCommand;
        boolean isCanceled = true;  //주문신호 (취소0 주문1)
        int[] answerArr;

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

            //음료 개수
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

            //추가주문
            orderCommand = new OrderCommand_20_orderMore();
            answerArr = orderCommand.execute(scan);

            //추가주문 여부 확인
            if(!intToBoolean(answerArr[0])) {
                //추가주문 없을시 최종주문 확인하기
                orderCommand = new OrderCommand_10_orderCheck();
                answerArr = orderCommand.execute(scan);
                //주문 확인함
                if(intToBoolean(answerArr[0])){
                    isCanceled = false;
                }
                orderProgress = false;
            }
        }
        return isCanceled;
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



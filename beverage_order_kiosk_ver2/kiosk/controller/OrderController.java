package beverage_order_kiosk_ver2.kiosk.controller;

import beverage_order_kiosk_ver2.kiosk.command.order_command.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import java.util.Scanner;

public class OrderController implements Controller{
    @Override
    public int control(Scanner scan) {
        System.out.println("OrderController - control");
        int result_receiveOrder;        //리턴객체
        int count = 0;                  //주문개수
        int resultSignal = 0;           //주문신호 (취소0 주문1)
        boolean orderProgress = true;   //플래그

        OrderCommand orderCommand;

        while (orderProgress) {
            System.out.println("OrderController - while 시작");
            //음료 종류
            orderCommand = new OrderCommand_0kind();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //음료 온도
            orderCommand = new OrderCommand_2temper();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //음료 샷
            orderCommand = new OrderCommand_3shot();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //음료 크기
            orderCommand = new OrderCommand_4size();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //음료 섭취장소
            orderCommand = new OrderCommand_5where();
            if(orderCommand.execute(scan)) {
                reset();
                break;
            }
            //추가주문 희망시 주문더 받기
            orderCommand = new OrderCommand_6orderMore();
            if(!orderCommand.execute(scan)) {
                //추가주문 없을시 최종주문 확인하기
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
        System.out.println("OrderController - while 종료");
        //주문결과 (결과번호, 주문개수)
        result_receiveOrder = resultSignal;
        return result_receiveOrder;
    }

    private void reset(){
        OrderCollection orderCollection = OrderCollection.getInstance();
        orderCollection.reset_orderInfo();
    }
}

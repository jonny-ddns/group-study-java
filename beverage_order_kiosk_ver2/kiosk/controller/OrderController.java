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

        int[] result_receiveOrder;      //리턴객체
        int count = 0;                  //주문개수
        int resultSignal = 0;           //주문신호 (취소0 주문1)
        boolean orderProgress = true;   //플래그

        OrderOperation orderOperation;

        while (orderProgress) {
//            printMenu();
            //음료 종류
            orderOperation = new OrderOperation0_kind();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //음료 온도
            orderOperation = new OrderOperation1_temper();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //음료 샷
            orderOperation = new OrderOperation2_shot();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //음료 크기
            orderOperation = new OrderOperation3_size();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //음료 섭취장소
            orderOperation = new OrderOperation4_where();
            if(orderOperation.execute(scan)) {
                reset();
                break;
            }
            //추가주문 희망시 주문더 받기
            orderOperation = new OrderOperation5_orderMore();
            if(!orderOperation.execute(scan)) {
                //추가주문 없을시 최종주문 확인하기
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
        //주문결과 (결과번호, 주문개수)
        result_receiveOrder = new int[]{resultSignal, count};
        return result_receiveOrder;
    }



}

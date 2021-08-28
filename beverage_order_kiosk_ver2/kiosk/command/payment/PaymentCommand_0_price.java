package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//결제할 가격 정보 가져오기
public class PaymentCommand_0_price implements PaymentCommand {
    private int beverage_kind;
    private int beverage_count;
    private int beverage_temper;
    private int beverage_shot;
    private int beverage_size;
    private int beverage_where;

    private int price;

    @Override
    public int[] execute(Scanner scan) {
        System.out.println("PaymentCommand_0_price");
        System.out.println("가격은 얼마입니다");

        Collection<Order> orderCollection = OrderInfos.getOrderCollection();

/*
음료종류:
개수:
온도:
샷:
크기:
장소:


 */

        System.out.println("주문개수 : "+ orderCollection.size());
        AtomicInteger sum = new AtomicInteger();
        if(orderCollection.iterator().hasNext()){
            orderCollection.forEach(order -> {
                printOrderInfo(order);
                int tmp = priceChange(order);
                System.out.println(order.getBeverKind() + "\t"+ tmp+ "원");
                sum.addAndGet(tmp);
//                sum = sum + tmp;
            });
            System.out.println("sum : " + sum);
        }
        return new int[]{sum.intValue()};
//        return new int[0];
    }

    //주문정보 가져오기
    private void printOrderInfo(Order order){

        beverage_kind = order.getBeverKind();
        beverage_count = order.getBeverCount();
        beverage_temper = order.getBeverTemper();
        beverage_shot = order.getBeverShot();
        beverage_size = order.getBeverSize();
        beverage_where = order.getBeverWhere();
        
        //값 출력확인
        System.out.println(beverage_kind);
        System.out.println(beverage_count);
        System.out.println(beverage_temper);
        System.out.println(beverage_shot);
        System.out.println(beverage_size);
        System.out.println(beverage_where);
    }
    
    //가격으로 변환하기
    private int priceChange(Order order){
        beverage_kind = order.getBeverKind();
        beverage_count = order.getBeverCount();
        beverage_temper = order.getBeverTemper();
        beverage_shot = order.getBeverShot();
        beverage_size = order.getBeverSize();
        beverage_where = order.getBeverWhere();

        price = 1000+
            beverage_kind+
            beverage_count+
            beverage_temper+
            beverage_shot+
            beverage_size+
            beverage_where;
        return price;
    }


}

package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;

//결제할 가격 정보 가져오기
public class PaymentCommand_0_price implements PaymentCommand {
    private int beverage_kind;
    private int beverage_count;
    private int beverage_temper;
    private int beverage_shot;
    private int beverage_size;
    private int beverage_where;

    @Override
    public int[] execute(Scanner scan) {
        System.out.println("PaymentCommand_1_price");


        System.out.println("가격정보 가져오기");


        Collection<Order> orderCollection = OrderInfos.getOrderCollection();

        System.out.println("주문개수 : "+ orderCollection.size());

        if(orderCollection.iterator().hasNext()){
            orderCollection.stream().forEach( order -> {
                printOrderInfo(order);
            });
        }


        return new int[0];
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
    private void priceChange(){
        

    }

}

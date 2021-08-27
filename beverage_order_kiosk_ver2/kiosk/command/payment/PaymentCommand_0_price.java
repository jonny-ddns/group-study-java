package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;

//������ ���� ���� ��������
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


        System.out.println("�������� ��������");


        Collection<Order> orderCollection = OrderInfos.getOrderCollection();

        System.out.println("�ֹ����� : "+ orderCollection.size());

        if(orderCollection.iterator().hasNext()){
            orderCollection.stream().forEach( order -> {
                printOrderInfo(order);
            });
        }


        return new int[0];
    }

    //�ֹ����� ��������
    private void printOrderInfo(Order order){
        beverage_kind = order.getBeverKind();
        beverage_count = order.getBeverCount();
        beverage_temper = order.getBeverTemper();
        beverage_shot = order.getBeverShot();
        beverage_size = order.getBeverSize();
        beverage_where = order.getBeverWhere();
        
        //�� ���Ȯ��
        System.out.println(beverage_kind);
        System.out.println(beverage_count);
        System.out.println(beverage_temper);
        System.out.println(beverage_shot);
        System.out.println(beverage_size);
        System.out.println(beverage_where);
    }
    
    //�������� ��ȯ�ϱ�
    private void priceChange(){
        

    }

}

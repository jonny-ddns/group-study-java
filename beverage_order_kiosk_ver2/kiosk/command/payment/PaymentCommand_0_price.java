package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//������ ���� ���� ��������
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
        System.out.println("PaymentCommand_1_price");


        System.out.println("�������� ��������");


        Collection<Order> orderCollection = OrderInfos.getOrderCollection();

        System.out.println("�ֹ����� : "+ orderCollection.size());
        AtomicInteger sum = new AtomicInteger();
        if(orderCollection.iterator().hasNext()){
            orderCollection.forEach(order -> {
                printOrderInfo(order);
                int tmp = priceChange(order);
                System.out.println(order.getBeverKind() + "\t"+ tmp+ "��");
                sum.addAndGet(tmp);
//                sum = sum + tmp;
            });
            System.out.println("sum : " + sum);
        }
        return new int[]{sum.intValue()};
//        return new int[0];
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

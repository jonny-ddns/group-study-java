package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.List;
import java.util.Scanner;

//�ֹ����� Ȯ�ΰ���� �Է¹޴� ���� ����
public class OrderOperation6_orderCheck implements OrderOperation {
    OrderFunctions orderFunctions;

    @Override
    public boolean execute(Scanner scan) {
        orderFunctions = new OrderFunctions();

        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean OrderCheck	= false;	//�ֹ� Ȯ�ΰ�� ����

        //�ֹ����� ����ϱ�
        List<Order> orderList = OrderCollection.get_orderList();

        //OrderCollection �����ؼ� List�� ��� ��û���� ����ϱ�
        System.out.println();
        for(Order order: orderList) {
	        String str1 = UnitChange.toString_kind(order.getBeverKind());
	        String str2 = UnitChange.toString_temper(order.getBeverTemper());
	        String str3 = UnitChange.toString_shot(order.getBeverShot());
	        String str4 = UnitChange.toString_size(order.getBeverSize());
	        String str5 = UnitChange.toString_where(order.getBeverWhere());
	        System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
        }
        System.out.print("�ֹ��Ͻðڽ��ϱ�? (y/n): ");
        
		//�ֹ�Ȯ�� ����� �ޱ����� �ݺ���
        int count=0;
        while(!goToNext) {

            String request = scan.next().trim().toLowerCase();
            boolean isYesOrNo = orderFunctions.isYesOrNo(request);

            if(isYesOrNo) {
                if(request.equals("y")){
                    OrderCheck = true;
                    break;
                } else if(request.equals("n")){
                    System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                    break;
                }
            } else {
                System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
            }

            if(++count > 4){
                goToNext = true;
            }
        }
        return OrderCheck;
    }
}

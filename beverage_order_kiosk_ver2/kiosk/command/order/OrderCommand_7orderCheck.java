package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

//�ֹ����� Ȯ�ΰ���� �Է¹޴� ���� ����
public class OrderCommand_7orderCheck implements OrderCommand {
    private final OrderFunctions orderFunctions = new OrderFunctions();
    @Override
    public int[] execute(Scanner scan) {
        System.out.println("OrderCommand_7orderCheck - execute");

        boolean OrderCheck = false;
        boolean isYesOrNo;
        String input;
        int count = 0;

        printWhatOrdered(orderFunctions);
        while(count<3) {
            count++;
            input = scanInput(scan);

            isYesOrNo = orderFunctions.isYesOrNo(input);
            if(isYesOrNo) {
                if(input.equals("y")) {
                    OrderCheck = true;
                    break;
                } else if (input.equals("n")) {
                    System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                    break;
                }
            } else {
                System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
            }
        }
//        return OrderCheck;
        return null;
    }

    private void printWhatOrdered(OrderFunctions orderFunctions) {
        System.out.println("printWhatOrdered");
        orderFunctions = new OrderFunctions();
        Collection<Order> orderList = OrderInfos.getOrderCollection();

        UnitChange unitChange = new UnitChange();

        //�ֹ����� ����ϱ�
        System.out.println();
        for (Order order : orderList) {
            String str1 = unitChange.toString_kind(order.getBeverKind());
            String str2 = unitChange.toString_temper(order.getBeverTemper());
            String str3 = unitChange.toString_shot(order.getBeverShot());
            String str4 = unitChange.toString_size(order.getBeverSize());
            String str5 = unitChange.toString_where(order.getBeverWhere());
            System.out.printf("%s(%s/%s/%s/%s)", str1, str2, str3, str4, str5);
        }
        System.out.println("\n�ֹ������� Ȯ�����ּ��� (y/n): ");
    }

    private String scanInput(Scanner scan) {
        System.out.print("�Է� : ");
        return scan.next().trim().toLowerCase();
    }
}
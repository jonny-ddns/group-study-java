package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.Collection;
import java.util.Scanner;

//�ֹ����� Ȯ�ΰ���� �Է¹޴� ���� ����
//���� - �ֹ�Ȯ�ο���
public class OrderCommand_20_orderCheck implements OrderCommand {
    private final CommandFunctions commandFunctions = new CommandFunctions();

    @Override
    public int[] execute(Scanner scan) {
        int OrderCheck = 0;
        int count = 0;
        boolean isYesOrNo;
        String input;

        printWhatOrdered();

        while(count<3) {
            count++;
            input = scanInput(scan);
            isYesOrNo = commandFunctions.isYesOrNo(input);

            if(!isYesOrNo){
                System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
                continue;
            }

            if(input.equals("n")) {
                System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �ֹ����ּ���");
                break;
            }

            if(input.equals("y")) {
                OrderCheck = 1;
                break;
            }
        }
        return new int[]{OrderCheck};
    }

    private void printWhatOrdered() {
        Collection<Order> orderList = OrderInfos.getOrderCollection();
        UnitChange unitChange = new UnitChange();

        //�ֹ����� ����ϱ�
        System.out.println();
        assert orderList != null;
        for (Order order : orderList) {
            String str1 = unitChange.toString_kind(order.getBeverKind());
            String str2 = unitChange.toString_temper(order.getBeverTemper());
            String str3 = unitChange.toString_shot(order.getBeverShot());
            String str4 = unitChange.toString_size(order.getBeverSize());
            String str5 = unitChange.toString_where(order.getBeverWhere());
            int int01 = order.getBeverCount();
            System.out.printf("%s(%s/%s/%s/%s/%d��)\n", str1, str2, str3, str4, str5, int01);
        }
        System.out.println("\n�ֹ������� Ȯ�����ּ��� (y/n)");
    }

    private String scanInput(Scanner scan) {
        System.out.print("�Է� : ");
        return scan.next().trim().toLowerCase();
    }
}
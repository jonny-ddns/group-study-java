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

        printWhatOrdered(commandFunctions);

        while(count<3) {
            count++;
            input = scanInput(scan);
            isYesOrNo = commandFunctions.isYesOrNo(input);

            if(!isYesOrNo){
                System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
                continue;
            }

            if(isYesOrNo && input.equals("n")) {
                System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �ֹ����ּ���");
                break;
            }

            if(isYesOrNo && input.equals("y")) {
                OrderCheck = 1;
                break;
            }
        }
        return new int[]{OrderCheck};
    }

    private void printWhatOrdered(CommandFunctions commandFunctions) {
        System.out.println("printWhatOrdered");
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
            System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
        }
        System.out.println("\n�ֹ������� Ȯ�����ּ��� (y/n)");
    }

    private String scanInput(Scanner scan) {
        System.out.print("�Է� : ");
        return scan.next().trim().toLowerCase();
    }
}
package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.Collection;
import java.util.Scanner;

//주문내역 확인결과를 입력받는 역할 수행
//리턴 - 주문확인여부
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
                System.out.println("y 혹은 n을 입력바랍니다");
                continue;
            }

            if(input.equals("n")) {
                System.out.println("주문이 취소되었습니다. 다시 주문해주세요");
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

        //주문내용 출력하기
        System.out.println();
        assert orderList != null;
        for (Order order : orderList) {
            String str1 = unitChange.toString_kind(order.getBeverKind());
            String str2 = unitChange.toString_temper(order.getBeverTemper());
            String str3 = unitChange.toString_shot(order.getBeverShot());
            String str4 = unitChange.toString_size(order.getBeverSize());
            String str5 = unitChange.toString_where(order.getBeverWhere());
            int int01 = order.getBeverCount();
            System.out.printf("%s(%s/%s/%s/%s/%d잔)\n", str1, str2, str3, str4, str5, int01);
        }
        System.out.println("\n주문내용을 확인해주세요 (y/n)");
    }

    private String scanInput(Scanner scan) {
        System.out.print("입력 : ");
        return scan.next().trim().toLowerCase();
    }
}
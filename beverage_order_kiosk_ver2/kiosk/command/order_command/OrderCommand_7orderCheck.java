package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.util.List;
import java.util.Scanner;

//주문내역 확인결과를 입력받는 역할 수행
public class OrderCommand_7orderCheck implements OrderCommand {
    OrderFunctions orderFunctions;

    @Override
    public boolean execute(Scanner scan) {
        System.out.println("OrderCommand_7orderCheck - execute");

        boolean OrderCheck = false;
        boolean isYesOrNo;
        String input;
        int count = 0;

        printWhatOrdered();
        while(count<3) {
            count++;
            input = scanInput(scan);

            isYesOrNo = orderFunctions.isYesOrNo(input);
            if(isYesOrNo) {
                if(input.equals("y")) {
                    OrderCheck = true;
                    break;
                } else if (input.equals("n")) {
                    System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                    break;
                }
            } else {
                System.out.println("y 혹은 n을 입력바랍니다");
            }
        }
        return OrderCheck;
    }

    private void printWhatOrdered() {
        System.out.println("printWhatOrdered");
        orderFunctions = new OrderFunctions();
        List<Order> orderList = OrderCollection.get_orderList();

        //주문내용 출력하기
        System.out.println();
        for (Order order : orderList) {
            String str1 = UnitChange.toString_kind(order.getBeverKind());
            String str2 = UnitChange.toString_temper(order.getBeverTemper());
            String str3 = UnitChange.toString_shot(order.getBeverShot());
            String str4 = UnitChange.toString_size(order.getBeverSize());
            String str5 = UnitChange.toString_where(order.getBeverWhere());
            System.out.printf("%s(%s/%s/%s/%s)", str1, str2, str3, str4, str5);
        }
        System.out.println("\n주문내용을 확인해주세요 (y/n): ");
    }

    private String scanInput(Scanner scan) {
        System.out.print("입력 : ");
        return scan.next().trim().toLowerCase();
    }
}
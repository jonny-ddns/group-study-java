package beverage_order_kiosk_ver2.kiosk.command.order;

import java.util.Scanner;

//리턴 ; [취소여부, 입력값]
public interface OrderCommand {
    int[] execute(Scanner scan);
}

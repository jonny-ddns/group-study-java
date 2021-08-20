package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import java.util.Scanner;

//KioskOrder클래스  - receiveOrder() 메서드에서 호출함
public interface OrderOperation {
    boolean execute(Scanner scan);
}

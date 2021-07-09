package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;

//KioskOrder클래스  - receiveOrder() 메서드에서 호출함
public interface Operation {
    boolean execute(Scanner scan);
}

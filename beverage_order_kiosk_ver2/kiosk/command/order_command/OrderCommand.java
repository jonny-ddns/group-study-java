package beverage_order_kiosk_ver2.kiosk.command.order_command;

import java.util.Scanner;

//KioskOrderŬ����  - receiveOrder() �޼��忡�� ȣ����
public interface OrderCommand {
    boolean execute(Scanner scan);
}

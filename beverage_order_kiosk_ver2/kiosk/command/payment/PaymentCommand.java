package beverage_order_kiosk_ver2.kiosk.command.payment;

import java.util.Scanner;

public interface PaymentCommand {
    int[] execute(Scanner scan);
}

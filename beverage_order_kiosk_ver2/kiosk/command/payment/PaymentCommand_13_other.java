package beverage_order_kiosk_ver2.kiosk.command.payment;

import java.util.Scanner;

public class PaymentCommand_13_other implements PaymentCommand {
    private int totalPrice;
    public int getTotalPrice() {
        return totalPrice;
    }
    public PaymentCommand setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
    @Override
    public int[] execute(Scanner scan) {
        System.out.println("PaymentCommand_13_other");
        System.out.println("지금은 지원되지 않는 기능입니다");
        System.out.println("다른 방법으로 결제해주세요");
        return new int[0];
    }
}

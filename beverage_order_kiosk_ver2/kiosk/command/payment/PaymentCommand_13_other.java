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
        System.out.println("������ �������� �ʴ� ����Դϴ�");
        System.out.println("�ٸ� ������� �������ּ���");
        return new int[0];
    }
}

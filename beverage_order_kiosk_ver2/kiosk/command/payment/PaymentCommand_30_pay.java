package beverage_order_kiosk_ver2.kiosk.command.payment;

import java.util.Scanner;

//����ó��
//���ϰ�����������
public class PaymentCommand_30_pay implements PaymentCommand{
    private int paymentWay; //�������
    @Override
    public int[] execute(Scanner scan) {
        

        return new int[0];
    }

    public PaymentCommand setPaymentWay(int paymentWay){
        this.paymentWay = paymentWay;
        return this;
    }
}

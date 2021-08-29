package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//���� �õ��ϱ�
public class PaymentCommand_11_cash implements PaymentCommand {
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
        System.out.println("PaymentCommand_11_cash");

        CommandFunctions commandFunctions = new CommandFunctions();
        commandFunctions.paymentGuide("����");

        int price = getTotalPrice();
        int signal = 0;
        int paymentWay = 1;
        int receivedMoney = 0;
        int count = 0;
        int balance;
        String input;
        boolean finished = false;

        while(!finished){
            if(++count > 10){
                System.out.println("���������Ͽ����ϴ�. ó������ �õ��ٶ��ϴ�");
                break;
            }

            input = commandFunctions.getMonenyFromCustomer(scan);
            if(!commandFunctions.isYesOrNo(input)){
                System.out.println("���ڸ� �Է¹ٶ��ϴ�");
                continue;
            }

            receivedMoney = Integer.parseInt(input);
            balance = commandFunctions.calculateBalance(price, receivedMoney);
            if (balance == -1){
                System.out.println("�ܾ��� �����մϴ�");
                continue;
            }
            signal = 1;
            finished = true;
        }
        return new int[]{signal, paymentWay, receivedMoney};
    }
}
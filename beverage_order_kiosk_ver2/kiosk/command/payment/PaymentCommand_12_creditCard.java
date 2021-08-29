package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

public class PaymentCommand_12_creditCard implements PaymentCommand {
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
        System.out.println("PaymentCommand_12_creditCard");

        CommandFunctions commandFunctions = new CommandFunctions();
        commandFunctions.paymentGuide("카드");

        int price = getTotalPrice();
        int signal = 0;
        int paymentWay = 2;
        int receivedMoney = 0;
        int count = 0;
        int balance;
        String input;
        boolean finished = false;

        while(!finished){
            if(++count > 10){
                System.out.println("결제실패하였습니다. 처음부터 시도바랍니다");
                break;
            }

            input = commandFunctions.getMonenyFromCustomer(scan);
            if(!commandFunctions.isYesOrNo(input)){
                System.out.println("숫자만 입력바랍니다");
                continue;
            }

            receivedMoney = Integer.parseInt(input);
            balance = commandFunctions.calculateBalance(price, receivedMoney);
            if (balance == -1){
                System.out.println("잔액이 부족합니다");
                continue;
            }
            giveBalaceToCustomer(balance);
            signal = 1;
            finished = true;
        }
        return new int[]{signal, paymentWay, receivedMoney};
    }

    private void giveBalaceToCustomer(int balance){
        if (balance > 0){
            System.out.printf("잔액은 %d원입니다\n", balance);
        }
    }
}

package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;

import java.util.Scanner;

//결제 시도하기
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
        System.out.println("PaymentCommand_1_cash");
        int price = getTotalPrice();
        String input;
        int receivedMoney;
        CommandFunctions commandFunctions = new CommandFunctions();
        commandFunctions.paymentGuide("현금");


        boolean finished = false;
        int count = 0;
        while(!finished){
            if(++count > 10){
                break;
            }

            input = t(scan);
            if(!commandFunctions.isYesOrNo(input)){
                System.out.println("숫자만 입력바랍니다");
                continue;
            }

            receivedMoney = Integer.parseInt(input);

            if(price < receivedMoney){
                System.out.println("돈 부족하니 돈 좀 더내라");
                if(count != 0){
                    count--;
                }
            }


            finished = true;

        }


        











        return new int[0];
    }
    private String t(Scanner scan){
        System.out.print("금액 : ");
        return scan.next().trim();
    }

    private void calculate( ){



    }






}

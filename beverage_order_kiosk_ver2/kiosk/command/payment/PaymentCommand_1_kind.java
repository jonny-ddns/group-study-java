package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//결제할 수단 확인하기
//리턴; 취소여부/결제방식
public class PaymentCommand_1_kind implements PaymentCommand {
    private final CommandFunctions commandFunctions = new CommandFunctions();

    @Override
    public int[] execute(Scanner scan) {
        int isCanceled = 1;
        int answer;
        int count = 0;
        boolean isOk = false;
        String input = "1";

        printPaymentWay();

        while(!isOk){
            if(++count>10){
                break;
            }
            System.out.println("입력 : ");

            input = scan.next().trim().toLowerCase();
            if(input.equals("c")){
                if(commandFunctions.askOrderCancel(scan)){
                    System.out.println("결제가 취소되었습니다. 다시 입력해주세요");
                    break;
                }
                continue;
            }

            if(commandFunctions.isNumber(input)){
                if(commandFunctions.checkInputRange(input, 3)){
                    isCanceled = 0;
                    isOk = true;
                } else {
                    System.out.println("번호를 다시 입력바랍니다 (1~3)");
                }
            } else{
                System.out.println("숫자를 입력바랍니다");
            }
        }
        answer = Integer.parseInt(input);
        return new int[]{isCanceled, answer};
    }

    private void printPaymentWay(){
        System.out.println("결제하실 수단을 선택하세요");
        System.out.println("1. 현금\n2. 카드\n3. 기타");
    }
}

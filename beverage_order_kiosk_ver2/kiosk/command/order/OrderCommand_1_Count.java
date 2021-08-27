package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//음료 개수 입력받기
public class OrderCommand_1_Count implements OrderCommand{
    private final CommandFunctions commandFunctions = new CommandFunctions();
    @Override
    public int[] execute(Scanner scan) {
        int isCanceled = 1;
        int answer;
        int count = 0;
        int number;
        boolean isOk = false;
        String input = "0";

        while(!isOk) {
            count++;
            if(count > 5) {
                break;
            }
            input = getScanInput(scan);

            //취소시
            if(input.equals("c")){
                if(commandFunctions.askOrderCancel(scan)){
                    System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                    break;
                }
                count = 0;
                continue;
            }

            if(!commandFunctions.isNumber(input)){
                System.out.println("개수는 숫자를 입력바랍니다");
                continue;
            }


            number = Integer.parseInt(input);

            if(number < 1){
                System.out.println("최소 1잔 이상 주문바랍니다");
                count = 0;
                continue;
            }

            if(number > 100){
                System.out.println("주문개수가 너무 많습니다. 확인해주세요");
                count = 0;
                continue;
            }
            isCanceled = 0;
            isOk = true;
        }
        answer = Integer.parseInt(input);
        return new int[]{isCanceled, answer};
    }

    //스캐너 입력받기
    private String getScanInput(Scanner scan){
        System.out.print("\n음료 개수를 입력하세요 (주문취소 c): ");
        return scan.next().trim().toLowerCase();
    }
}

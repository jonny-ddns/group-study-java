package beverage_order_kiosk_ver2.kiosk.command.order;

import java.util.Scanner;

//음료 개수 입력받기
public class OrderCommand_1_Count implements OrderCommand{
    private final OrderFunctions orderFunctions = new OrderFunctions();
    @Override
    public int[] execute(Scanner scan) {
        int isCanceled = 1;
        int answer;
        int count = 0;
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
                if(orderFunctions.askOrderCancel(scan)){
                    System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                    break;
                }
                count = 0;
                continue;
            }

            if(!orderFunctions.isNumber(input)){
                System.out.println("개수는 숫자를 입력바랍니다");
                continue;
            }
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

package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;

import java.util.Scanner;

//음료 개수 입력받기
public class OrderCommand_1Count implements OrderCommand{
    OrderFunctions orderFunctions;
    @Override
    public boolean execute(Scanner scan) {
        orderFunctions = new OrderFunctions();
        Order order = OrderCollection.get_orderData();
        boolean isCanceled = false;
        int count = 0;
        String input = "0";
        boolean isOk = false;

        while(!isOk) {
            count++;
            if(count > 5) {
                isCanceled = true;
                break;
            }
            input = getScanInput(scan);

            //취소시
            if(input.equals("c")){
                if(askOrderCancel(scan)){
                    System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
                    break;
                }
                count = 0;
                continue;
            }

            //입력값 확인
            if(checkScanInput(input)){
                check_beverageChoose(input);
                isOk = true;
            } else{
                System.out.printf("번호를 다시 입력바랍니다 (1~%d)\n", BeverageInfo.SHOT.values().length);
            }
        }
        order.setBeverShot(Integer.parseInt(input));
        return isCanceled;
    }

    //스캐너 입력받기
    private String getScanInput(Scanner scan){
        System.out.print("\n음료 개수를 입력하세요 (주문취소 c): ");
        return scan.next().trim().toLowerCase();
    }

    //적절한 숫자 입력여부 확인
    private boolean checkScanInput(String input){
        boolean inputCheck = false;
        if(orderFunctions.isNumber(input)){
            int num = Integer.parseInt(input);

            //숫자가 범위에 해당하는지 확인
            if(0<num && num<100) {
                inputCheck = true;
            }
        }
        return inputCheck;
    }

    //반복문 돌면서 취소여부 물어보기
    private boolean askOrderCancel(Scanner scan){
        System.out.println("\n주문을 취소하시겠습니까? (y/n): ");
        boolean wantToCancel = false;
        int count = 0;
        while( count<3 ){
            count++;
            System.out.print("입력 : ");
            String cancelAnswer = scan.next().trim().toLowerCase();

            if(!orderFunctions.isYesOrNo(cancelAnswer)){
                System.out.println("y 혹은 n을 입력바랍니다");
                continue;
            }
            if(cancelAnswer.equals("y")){
                wantToCancel = true;
            }
            break;
        }
        return wantToCancel;
    }

    //단위변환
    private void check_beverageChoose(String input){
        System.out.printf("%s\n", Integer.parseInt(input));
    }
}

package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import java.util.Scanner;

//KioskOrder클래스  - receiveOrder() 메서드에서 호출함
public interface OrderOperation {
    boolean execute(Scanner scan);

    class CheckRequest {
        //입력값이 숫자인지 확인하기
        public static boolean isNumber(String request){
            boolean isNum = false;
            try{
                Integer.parseInt(request);
                isNum = true;
            } catch (NumberFormatException ignored){ }
            return isNum;
        }

        //입력값이 y 혹은 n인지 확인하기
        public static boolean isYesOrNo(String request) {
            return request.equals("y") || request.equals("n");
        }
    }
}

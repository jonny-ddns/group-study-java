package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import java.util.Scanner;

//KioskOrderŬ����  - receiveOrder() �޼��忡�� ȣ����
public interface OrderOperation {
    boolean execute(Scanner scan);

    class CheckRequest {
        //�Է°��� �������� Ȯ���ϱ�
        public static boolean isNumber(String request){
            boolean isNum = false;
            try{
                Integer.parseInt(request);
                isNum = true;
            } catch (NumberFormatException ignored){ }
            return isNum;
        }

        //�Է°��� y Ȥ�� n���� Ȯ���ϱ�
        public static boolean isYesOrNo(String request) {
            return request.equals("y") || request.equals("n");
        }
    }
}

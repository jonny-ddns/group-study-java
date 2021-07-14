package beverage_order_kiosk.kiosk.operation;

import java.util.Scanner;

//KioskOrderŬ����  - receiveOrder() �޼��忡�� ȣ����
public interface Operation {
    boolean execute(Scanner scan);

    class CheckRequest {
        //�Է°��� �������� Ȯ���ϱ�
        public static boolean isNumber(String request){
            boolean isNum = false;
            try{
                Integer.parseInt(request);
                isNum = true;
            } catch (NumberFormatException nfe){
                nfe.getMessage();
            } catch (Exception e){
                e.getMessage();
            }
            return isNum;
        }

        //�Է°��� y Ȥ�� n���� Ȯ���ϱ�
        public static boolean isYesOrNo(String request) {
            boolean isYesOrNo = false;
            if(request.equals("y") || request.equals("n")) {
                isYesOrNo = true;
            }
            return isYesOrNo;
        }
    }
}

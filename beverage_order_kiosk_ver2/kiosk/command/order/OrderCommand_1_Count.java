package beverage_order_kiosk_ver2.kiosk.command.order;

import java.util.Scanner;

//���� ���� �Է¹ޱ�
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

            //��ҽ�
            if(input.equals("c")){
                if(orderFunctions.askOrderCancel(scan)){
                    System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                    break;
                }
                count = 0;
                continue;
            }

            if(!orderFunctions.isNumber(input)){
                System.out.println("������ ���ڸ� �Է¹ٶ��ϴ�");
                continue;
            }
            isOk = true;
        }
        answer = Integer.parseInt(input);
        return new int[]{isCanceled, answer};
    }

    //��ĳ�� �Է¹ޱ�
    private String getScanInput(Scanner scan){
        System.out.print("\n���� ������ �Է��ϼ��� (�ֹ���� c): ");
        return scan.next().trim().toLowerCase();
    }
}

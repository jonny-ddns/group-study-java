package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//���� ���� �Է¹ޱ�
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

            //��ҽ�
            if(input.equals("c")){
                if(commandFunctions.askOrderCancel(scan)){
                    System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                    break;
                }
                count = 0;
                continue;
            }

            if(!commandFunctions.isNumber(input)){
                System.out.println("������ ���ڸ� �Է¹ٶ��ϴ�");
                continue;
            }


            number = Integer.parseInt(input);

            if(number < 1){
                System.out.println("�ּ� 1�� �̻� �ֹ��ٶ��ϴ�");
                count = 0;
                continue;
            }

            if(number > 100){
                System.out.println("�ֹ������� �ʹ� �����ϴ�. Ȯ�����ּ���");
                count = 0;
                continue;
            }
            isCanceled = 0;
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

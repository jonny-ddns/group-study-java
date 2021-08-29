package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//������ ���� Ȯ���ϱ�
//����; ��ҿ���/�������
public class PaymentCommand_1_way implements PaymentCommand {
    private final CommandFunctions commandFunctions = new CommandFunctions();

    @Override
    public int[] execute(Scanner scan) {
        System.out.println("PaymentCommand_1_way");
        int signal = 0;
        int answer;
        int count = 0;
        boolean isOk = false;
        String input = "1";

        printPaymentWay();

        while(!isOk){
            if(++count>10){
                break;
            }
            System.out.print("�Է� : ");

            input = scan.next().trim().toLowerCase();
            if(input.equals("c")){
                if(commandFunctions.askOrderCancel(scan)){
                    System.out.println("������ ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
                    break;
                }
                continue;
            }

            if(commandFunctions.isNumber(input)){
                if(commandFunctions.checkInputRange(input, 3)){
                    signal = 1;
                    isOk = true;
                } else {
                    System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~3)");
                }
            } else{
                System.out.println("���ڸ� �Է¹ٶ��ϴ�");
            }
        }
        answer = Integer.parseInt(input);
        return new int[]{signal, answer};
    }

    private void printPaymentWay(){
        System.out.println("�����Ͻ� ������ �����ϼ��� ");
        System.out.println("1. ����\n2. ī��\n3. ��Ÿ");
        System.out.println("(�ٽ� �ֹ��Ϸ��� c �Է�)");
    }
}

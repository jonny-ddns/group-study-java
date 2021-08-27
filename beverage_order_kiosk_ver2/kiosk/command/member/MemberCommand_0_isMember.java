package beverage_order_kiosk_ver2.kiosk.command.member;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;

import java.util.Scanner;

//�ֹ���� �����ϱ� - ȸ��/��ȸ��
/*
#����
0 ���
1 ȸ��
2 ��ȸ��
 */
public class MemberCommand_0_isMember implements MemberCommand {
    private final CommandFunctions commandFunctions = new CommandFunctions();

    @Override
    public int execute(Scanner scan) {
        String scanInput;
        int stepParameter = 2;
        int count = 0;
        boolean isOk = false;

        printWelcomeMent();

        while(!isOk){
            //Ƚ�� ����
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                stepParameter = 3;
                break;
            }

            System.out.print("\n�Է�: ");
            scanInput = scan.next().trim();

            //�Է��� ��ȣ �����ϱ�
            if(!commandFunctions.isNumber(scanInput)){
                System.out.println("���ڸ� �Է����ּ���");
                continue;
            } if(!(scanInput.equals("1") || scanInput.equals("2"))){
                System.out.println("1 Ȥ�� 2�� �Է��ϼ���");
                continue;
            }
            //ȸ���ֹ��� ���� 1
            //��ȸ���ֹ��� ���� 2
            if(Integer.parseInt(scanInput) == 1){
                stepParameter = 1;
            }
            isOk = true;
        }
        return stepParameter;
    }

    private void printWelcomeMent(){
        System.out.println("�ȳ��ϼ���. �����ֹ� Ű����ũ�Դϴ�\n�ֹ������ �������ּ���\n");
        System.out.println("1. ȸ������ �ֹ�");
        System.out.println("2. ��ȸ������ �ֹ�");
    }
}

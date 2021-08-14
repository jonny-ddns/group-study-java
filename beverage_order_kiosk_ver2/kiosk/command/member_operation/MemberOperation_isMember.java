package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import java.util.Scanner;

//�ֹ���� �����ϱ� - ȸ��/��ȸ��
/*
#����
0 ���
1 ȸ��
2 ��ȸ��
 */
public class MemberOperation_isMember implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        int stepParameter = 2;

        System.out.println("MemberOperation_isMember");
        boolean isOk = false;
        String scanInput;

        System.out.println("1. ȸ������ �ֹ�");
        System.out.println("2. ��ȸ������ �ֹ�");

        int count = 0;
        while(!isOk){
            //Ƚ�� ����
            count++;
            if( count>3 ){
                System.out.println(new Mention().getMENT_ORDER_AGAIN());
                stepParameter = 3;
                break;
            }

            System.out.print("\n�Է�: ");
            scanInput = scan.next().trim();

            //�Է��� ��ȣ �����ϱ�
            MemberFunction f = new MemberFunction();
            if(!f.isNumber(scanInput)){
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
        System.out.println("MemberOperation_isMember end");
        return stepParameter;
    }
}
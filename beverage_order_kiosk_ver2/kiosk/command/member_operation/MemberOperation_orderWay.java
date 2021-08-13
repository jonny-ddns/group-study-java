package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import java.util.Scanner;

//ȸ������ Ȯ���ϱ�
public class MemberOperation_orderWay implements MemberOperation {
    @Override
    public boolean execute(Scanner scan) {
        System.out.println("Operation_orderWay");
        boolean isMember = false;
        boolean inputcheck = false;
        String inputNumber;

        System.out.println("1. ȸ������ �ֹ�");
        System.out.println("2. ��ȸ������ �ֹ�");
        System.out.print("\n�Է�: ");

        while(!inputcheck){
            inputNumber = scan.next().trim();

            //�Է��� ��ȣ �����ϱ�
            if(!isNumber(inputNumber)){
                System.out.println("���ڸ� �Է����ּ���");
                continue;
            } if(!(inputNumber.equals("1") || inputNumber.equals("2"))){
                System.out.println("1 Ȥ�� 2�� �Է��ϼ���");
                continue;
            }

            if(Integer.parseInt(inputNumber) == 1){
                isMember = true;
            }
        }
        System.out.println("Operation_orderWay end");
        return isMember;
    }

    //���ڰ��� �������� Ȯ���ϱ�
    private boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException nfe){ }
        return isNum;
    }
}

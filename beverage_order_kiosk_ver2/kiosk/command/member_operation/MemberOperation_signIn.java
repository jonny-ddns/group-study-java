package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;
import java.util.Scanner;

public class MemberOperation_signIn implements MemberOperation {

    @Override
    public boolean execute(Scanner scan) {
        System.out.println("Operation_signIn");
        boolean goToNext = false;
        //ȸ�� ���� ��������
        MemberCollection memberCollection = MemberCollection.getInstance();
        memberCollection.checkMemberInList(name, phone);

        System.out.println("���̵� �Է��ϼ���");
        System.out.println("-ȸ�������Ϸ��� 'q' �Է�");
        System.out.println("-��������Ϸ��� 'c' �Է�");
        System.out.println("\n�Է� : ");

        String request = scan.next().trim().toLowerCase();
        //�����ϱ�
        if(request.equals('q')) {


        }
        //����ϱ�
        if(request.equals('c')){


        }


        //���̵� ��ġ�ϴ��� Ȯ���ϱ�



        System.out.println("Operation_signIn");
        return goToNext;
    }
}
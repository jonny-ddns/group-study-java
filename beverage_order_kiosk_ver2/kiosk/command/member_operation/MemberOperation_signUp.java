package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;

import java.util.Scanner;

//ȸ������ ó���ϱ�
public class MemberOperation_signUp implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("MemberOperation_signUp");
        MemberCollection memberCollection =  MemberCollection.getInstance();
        int stepParameter = 0;

        String scan_name;
        String scan_nick;
        String scan_phone;
        String scan_birthday;

        boolean goToNext;


        System.out.println("�޴�����ȣ�� - ���� ���ڸ� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : 010-");
            scan_phone = scan.next().trim();

            //���
            if(scan_phone.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }
            
            //������ �޴��� ��ȣ�� �ִ��� Ȯ���ϱ�
            boolean isMember = memberCollection.isMemberInList(scan_phone);
            
            //���� ȸ��
            if(isMember){
                System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�");
            }
            if(){
                goToNext = true;
            }
        }

        System.out.println("�̸��� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_name = scan.next().trim();
        }


        System.out.println("�г����� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_nick = scan.next().trim();
        }


        System.out.println("���� 4�ڸ��� �Է��ϼ��� [0813] (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_birthday = scan.next().trim();
        }
        
        //����Ʈ�� ȸ������ �����ϱ�
        Member member = new Member();
        member.setName(scan_name)
                .setNick(scan_nick)
                .setBirthday(scan_birthday)
                .setPhone(scan_phone)
                .setPoint(0);


        memberCollection.addCustomer(member);

        System.out.println("MemberOperation_signUp end");
        return stepParameter;
    }
}
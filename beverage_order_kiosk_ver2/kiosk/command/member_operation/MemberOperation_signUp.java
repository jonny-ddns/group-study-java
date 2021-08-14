package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;

import java.util.Scanner;

//ȸ������ ó���ϱ�
/*
#����
0 ���
1 ����ó��
 */
public class MemberOperation_signUp implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("MemberOperation_signUp");

        MemberCollection memberCollection =  null;
        int stepParameter = 0;
        boolean goToNext;
        boolean isCanceled;
        String scan_name = "";
        String scan_nick = "";
        String scan_phone = "";
        String scan_birthday = "";

        //�Է�; �޴���
        System.out.println("�޴�����ȣ�� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : 010-");
            scan_phone = scan.next().trim();

            MemberFunction f = new MemberFunction();
            memberCollection = MemberCollection.getInstance();
            boolean isMember = memberCollection.isMemberInList(scan_phone);

            /* ���ܻ�Ȳ ó�� */
            //��� �Է�
            if(scan_phone.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }
            //���� �ܿ� �ٸ� ���ڸ� �Է��ߴٸ�
            else if( !f.isNumber(scan_phone) ){
                System.out.println("���ڸ� �Է¹ٶ��ϴ�");
                continue;
            }
            //�޴��� 8�ڸ� �Է� ����
            else if( scan_phone.length() != 8 ){
                System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ�");
                continue;
            }
            //������ �޴��� ��ȣ�� �ִ��� Ȯ���ϱ�
            else if(isMember){
                System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�");
                continue;
            }
            goToNext = true;
        }

        //�Է�; �̸�
        System.out.println("�̸��� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_name = scan.next().trim();

            //��� �Է�
            if(scan_name.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }

            goToNext = true;
        }

        //�Է�; �г���
        System.out.println("�г����� �Է��ϼ��� (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_nick = scan.next().trim();

            //��� �Է�
            if(scan_nick.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }

            goToNext = true;
        }

        //�Է�; ����
        System.out.println("���� 4�ڸ��� �Է��ϼ��� [0813] (��Ҵ� c)");
        goToNext = false;
        while(!goToNext){
            System.out.print("�Է� : ");
            scan_birthday = scan.next().trim();

            //��� �Է�
            if(scan_birthday.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }

            //���ڿ��� Ȯ��
            MemberFunction f = new MemberFunction();
            if(f.isNumber(scan_birthday)){
                continue;
            }
            else if(scan_birthday.length() != 4){
                System.out.println("������ 4�ڸ��� �Է����ּ���");
                continue;
            }
            
            //��, �� Ȯ��
            String strMonth = scan_birthday.substring(0, 2);
            int month = Integer.parseInt(strMonth);

            String strDay = scan_birthday.substring(2, 4);
            int day = Integer.parseInt(strDay);

            //��� Ȯ��
            System.out.println("month : "+ month);
            System.out.println("day : "+ day);

            if( !(0<month && month<13) || (0<day && day<32) ){
                System.out.println("������? �ٽ� �Է����ּ���");
                continue;
            }
            goToNext = true;

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
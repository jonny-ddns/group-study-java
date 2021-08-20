package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.KioskOrder;
import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;
import java.util.Scanner;

//ȸ������ ó���ϱ�
//�Է�; �޴���ȭ, �г���, ����
/*
#����
0 ���
1 ����ó��
 */
public class MemberOperation_signUp implements MemberOperation {

    private String scan_phone = "";
    private String scan_nick = "";
    private String scan_birthday = "";

    @Override
    public int execute(Scanner scan) {
        int stepParameter = 0;
        boolean resultScan_phone;
        boolean resultScan_nick = false;
        boolean resultScan_birthday = false;

        resultScan_phone = getScanPhone(scan);
        if(resultScan_phone){
            resultScan_nick = getScanNick(scan);
        }
        if(resultScan_nick){
            resultScan_birthday = getScanBirthday(scan);
        }

        MemberCollection memberCollection =  MemberCollection.getInstance();
        if(resultScan_birthday){
            stepParameter = 1;
            //����Ʈ�� ȸ������ �����ϱ�
            Member member = new Member();
            member.setNick(scan_nick)
                    .setBirthday(scan_birthday)
                    .setPhone(scan_phone)
                    .setPoint(0);
            memberCollection.addCustomer(member);
            KioskOrder.setPersonNow(member);
        }
        return stepParameter;
    }

    //�Է�; �޴�����ȣ
    private boolean getScanPhone(Scanner scan){
        System.out.println("�޴�����ȣ�� ���ڸ� �Է��ϼ���(��Ҵ� c)");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                break;
            }

            System.out.print("�Է� : 010-");
            scan_phone = scan.next().trim();

            MemberFunctions f = new MemberFunctions();
            MemberCollection memberCollection = MemberCollection.getInstance();
            boolean isMember = memberCollection.isMemberInList(scan_phone);

            /* ���ܻ�Ȳ ó�� */
            //������ �޴��� ��ȣ�� �ִ��� Ȯ���ϱ�
            if(isMember){
                System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�");
                continue;
            }
            //��� �Է�
            else if(scan_phone.equals("c")) {
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
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }

    //�Է�; �г���
    private boolean getScanNick(Scanner scan){
        System.out.println("�г����� �Է��ϼ���(��Ҵ� c)");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                break;
            }

            System.out.print("�Է� : ");
            scan_nick = scan.next().trim();

            //��� �Է�
            if(scan_nick.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }
            //1���ڸ� �Է�
            else if(scan_nick.length() < 2){
                System.out.println("�г����� ª���ϴ�. 2���� �̻� �Է����ּ���");
                continue;
            }
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }
    
    //�Է�; ����
    private boolean getScanBirthday(Scanner scan){
        System.out.println("���� 4�ڸ��� �Է��ϼ���(��Ҵ� c) [ex.0813]");
        boolean goToNext = false;
        boolean scanWell = false;
        int count = 0;
        MemberFunctions f;
        while(!scanWell){
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                break;
            }

            System.out.print("�Է� : ");
            scan_birthday = scan.next().trim();

            //��� �Է�
            if(scan_birthday.equals("c")) {
                System.out.println("��ҵǾ����ϴ�");
                break;
            }
            //���ڿ��� Ȯ��
            f = new MemberFunctions();
            if(!f.isNumber(scan_birthday)){
                continue;
            }
            //4���� �Է� Ȯ��
            if(scan_birthday.length() != 4){
                System.out.println("������ 4�ڸ��� �Է����ּ���");
                continue;
            }
            //��, �� Ȯ��
            String strMonth = scan_birthday.substring(0, 2);
            String strDay   = scan_birthday.substring(2, 4);
            int month   = Integer.parseInt(strMonth);
            int day     = Integer.parseInt(strDay);

            if( !((0<month && month<13) && (0<day && day<32)) ){
                System.out.println("��¥�� �ٽ� �Է¹ٶ��ϴ�");
                continue;
            }
            System.out.println("\nȸ������ �Ϸ�!");
            goToNext = true;
            scanWell = true;
        }
        return goToNext;
    }
}
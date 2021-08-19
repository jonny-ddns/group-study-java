package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;
import java.util.Scanner;

//ȸ�� �α��� ó���ϱ�
/*
#����
0 ���
1 �α���
2 ����
 */
public class MemberOperation_signIn implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("Operation_signIn");
        int stepParameter = 0;
        
        System.out.println("ȸ�����θ� Ȯ���մϴ�");
        System.out.println("�޴��� ��ȣ 8�ڸ��� �Է��ϼ���");
        System.out.println("(ȸ�������� 'q' ������Ҵ� 'c' �Է�)");

        int count = 0;
        boolean isOk = false;
        while(!isOk){
            //Ƚ�� ����
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                stepParameter = 0;
                break;
            }

            System.out.print("\n�Է� : ");
            String scanInput = scan.next().trim().toLowerCase();

            //ȸ������ ó��
            if(scanInput.equals("q")) {
                System.out.println("\nȸ�������Ͻðڽ��ϱ� [y/n]");
                String inputSignup = scan.next().trim().toLowerCase();

                if(inputSignup.equals("y")){
                    stepParameter = 2;
                }
                break;
            }
            //��� ó��
            else if(scanInput.equals("c")){
                stepParameter = 3;
                break;
            }
            
            //����Ʈ�� �޴���ȭ �����Ϳ� ���ϱ�
            //ȸ�� ���� ��������
            MemberCollection memberCollection = MemberCollection.getInstance();
            Member member = memberCollection.checkMemberInList(scanInput);

            //��ġ�ϴ� ȸ�������� ����
            if(member == null){
                System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�. �ٽ� �Է����ּ���");
//                continue;
            } else {
                System.out.printf("[%s]�� �ݰ����ϴ�\n", member.getNick());
                
                isOk = true;
            }
        }
        System.out.println("Operation_signIn end");
        return stepParameter;
    }
}
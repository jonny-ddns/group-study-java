package beverage_order_kiosk_ver2.kiosk.command.member_command;

import beverage_order_kiosk_ver2.kiosk.data.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.data.memberInfo.MemberInfos;
import java.util.Scanner;

//ȸ�� �α��� ó���ϱ�
/*
#����
0 ���
1 �α���
2 ����
 */
public class MemberCommand_signIn implements MemberCommand {
    @Override
    public int execute(Scanner scan) {
        int stepParameter = 0;

        System.out.println("\nȸ�����θ� Ȯ���մϴ�");
        System.out.println("�޴��� ���ڸ� 8���� �Է��ϼ���");
        System.out.println("(ȸ�������� 'q' ��Ҵ� 'c' �Է�)");

        int count = 0;
        boolean isOk = false;
        while(!isOk){
            //Ƚ�� ����
            count++;
            if( count>3 ){
                System.out.println("ó������ �ٽ� �õ����ֽñ� �ٶ��ϴ�");
                break;
            }
            System.out.print("\n�Է� : ");
            String scanInput = scan.next().trim().toLowerCase();

            //0 ��� ó��
            if(scanInput.equals("c")){
                break;
            }
            //2 ȸ������ ó��
            else if(scanInput.equals("q")) {
                System.out.print("ȸ�������Ͻðڽ��ϱ�[y/n] : ");
                String inputSignup = scan.next().trim().toLowerCase();

                if(inputSignup.equals("y")){
                    stepParameter = 2;
                }
                break;
            }
            //1 �α��� ó��
            //ȸ�� ���� �����ͼ� ����Ʈ�� �޴���ȭ �����Ϳ� ���ϱ�
            MemberInfos memberInfos = MemberInfos.getInstance();
            Member member = memberInfos.checkMemberInList(scanInput);

            //��ġ�ϴ� ȸ�������� ����
            if(member == null){
                System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�. �ٽ� �Է����ּ���");
                stepParameter = 0;
            } else {
                System.out.printf("[%s]�� �ݰ����ϴ�\n", member.getNick());
                isOk = true;
                stepParameter = 1;
            }
        }
        return stepParameter;
    }
}
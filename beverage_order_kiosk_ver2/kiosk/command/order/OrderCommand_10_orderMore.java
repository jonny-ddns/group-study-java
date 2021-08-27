package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//�߰��ֹ� ���θ� �Է¹ޱ�
//���� - ��ҿ���/�߰��ֹ�����
public class OrderCommand_10_orderMore implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();
	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		System.out.println("\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): ");
		while(!isOk) {
			count++;
			if(count > 5) {
				break;
			}
			System.out.print("�Է� : ");
			input = scan.next().trim().toLowerCase();

			//��ҽ�
			if(input.equals("c")){
				if(commandFunctions.askOrderCancel(scan)){
//					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
					break;
				}
				count = 0;
				continue;
			}

			//�Է°� Ȯ��
			if(!commandFunctions.isYesOrNo(input)){
				System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
				continue;
			}

			if(input.equals("y")){
				System.out.println("�߰��ֹ� YES");
				input = "1";
			} else {
				System.out.println("�߰��ֹ� NO");
				input = "0";
			}
			isCanceled = 0;
			isOk = true;
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}

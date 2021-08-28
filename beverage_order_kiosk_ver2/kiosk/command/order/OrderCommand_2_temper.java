package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.TEMPER;
import java.util.Scanner;

//���� �µ��� �Է¹޴� ���� ����
public class OrderCommand_2_temper implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();
	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		System.out.println("\n1.ice 2.hot ���� (�ֹ���� c)");
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
					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
					break;
				}
				count = 0;
				continue;
			}

			//�Է°� Ȯ��
			int index = TEMPER.values().length;
			if(commandFunctions.checkInputRange(input, index)){
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~%d)\n", TEMPER.values().length);
			}
		}
		answer = Integer.parseInt(input) -1;
		return new int[]{isCanceled, answer};
	}
}
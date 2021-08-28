package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.SIZE;
import java.util.Scanner;

//���� ũ�⸦ �Է¹޴� ���� ����
public class OrderCommand_4_size implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();
	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		System.out.println("\n1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ���� c)");
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
			int index = SIZE.values().length;
			if(commandFunctions.checkInputRange(input, index)){
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~%d)\n", SIZE.values().length);
			}
		}
		answer = Integer.parseInt(input) -1;
		return new int[]{isCanceled, answer};
	}
}
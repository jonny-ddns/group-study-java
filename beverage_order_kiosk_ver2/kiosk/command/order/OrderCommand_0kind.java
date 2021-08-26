package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Scanner;

//���� ������ �Է¹޴� ���� ����
//��ҿ��� ����
public class OrderCommand_0kind implements OrderCommand {
	private final OrderFunctions orderFunctions = new OrderFunctions();

	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		orderFunctions.printMenu();
		System.out.println("\n����(��ȣ)�� �������ּ��� (�ֹ���� c)");
		while(!isOk) {
			count++;
			if(count > 5) {
				break;
			}
			System.out.print("�Է� : ");
			input = scan.next().trim().toLowerCase();

			//��ҽ�
			if(input.equals("c")){
				if(orderFunctions.askOrderCancel(scan)){
					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
					break;
				}
				count = 0;
				continue;
			}

			//�Է°� Ȯ��
			int index = BeverageInfo.KIND.values().length;
			if(orderFunctions.checkInputRange(input, index)){
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~%d)\n", BeverageInfo.KIND.values().length);
			}
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}
package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.Scanner;

//���� ������ �Է¹޴� ���� ����
public class OrderOperation0_kind implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

		boolean isCanceled = false;        //���� ��ü
		int count = 0;

		boolean isOk = false;
		while(!isOk) {
			count++;
			if(count > 5) {
				break;
			}

			String input = getScanInput(scan);
			if(input.equals("c")){
				isCanceled = askOrderCancel(scan);
			}

			if(checkScanInput(input)){
				int num = Integer.parseInt(input);
				String str1 = UnitChange.toString_kind(num);
				System.out.printf("%s\n", str1);
				isOk = true;
			} else{
				System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~6)");
			}
		}
		return isCanceled;
	}

	//��ĳ�� �Է¹ޱ�
	private String getScanInput(Scanner scan){
		System.out.print("\n����(��ȣ)�� �������ּ��� (�ֹ���� c): ");
		return scan.next().trim().toLowerCase();
	}

	//������ ���� �Է¿��� Ȯ��
	private boolean checkScanInput(String input){
		boolean inputCheck = false;
		if(orderFunctions.isNumber(input)){
			int num = Integer.parseInt(input);
			int count = BeverKind.values().length;

			//���ڰ� ������ �ش��ϴ��� Ȯ��
			if(0<num && num<count+1) {
				inputCheck = true;
			}
		}
		return inputCheck;
	}

	//��� ��Ʈ ���
	private boolean askOrderCancel(Scanner scan){
		System.out.println("\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ");
		String input;
		boolean isCanceled = false;
		//y or n �Է� Ȯ��
		input = scan.next().trim().toLowerCase();
		boolean isYesOrNo = orderFunctions.isYesOrNo(input);

		if(isYesOrNo && input.equals("y")) {
			System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
			isCanceled = true;
		}
		return isCanceled;
	}
}
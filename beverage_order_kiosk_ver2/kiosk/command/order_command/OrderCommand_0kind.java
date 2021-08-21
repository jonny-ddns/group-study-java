package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverKind;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverKind_ko;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.Pricing;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;
import java.util.Scanner;

//���� ������ �Է¹޴� ���� ����
//��ҿ��� ����
public class OrderCommand_0kind implements OrderCommand {
	private final OrderFunctions orderFunctions = new OrderFunctions();

	@Override
	public boolean execute(Scanner scan) {
		boolean isCanceled = false;
		boolean isOk = false;
		int count = 0;
		printMenu();

		while(!isOk) {
			count++;
			if(count > 5) {
				isCanceled = true;
				break;
			}
			String input = getScanInput(scan);

			//��ҽ�
			if(input.equals("c")){
				if(askOrderCancel(scan)){
					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
					break;
				}
				count = 0;
				continue;
			}

			//�Է°� Ȯ��
			if(checkScanInput(input)){
				check_beverageChoose(input);
				isOk = true;
			} else{
				System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~6)");
			}
		}
		return isCanceled;
	}

	/*-------------------------*/

	//�޴� ���
	private void printMenu() {
		BeverKind_ko[] beverKind_ko = BeverKind_ko.values();
		Pricing p		= new Pricing();
		int[] priceArr	= p.getBeveragePrice();
		String line     = "----------------------";

		System.out.println(line);
		System.out.println("�޴�");
		for(int i = 0; i< BeverKind.values().length; i++) {
			System.out.printf(" %d. %s\t%d��\n", i+1, beverKind_ko[i], priceArr[i]);
		}
		System.out.println(line);
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

	//�ݺ��� ���鼭 ��ҿ��� �����
	private boolean askOrderCancel(Scanner scan){
		System.out.println("\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ");
		boolean wantToCancel = false;
		int count = 0;
		while( count<3 ){
			count++;
			System.out.print("�Է� : ");
			String cancelAnswer = scan.next().trim().toLowerCase();

			if(!orderFunctions.isYesOrNo(cancelAnswer)){
				System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
				continue;
			}
			if(cancelAnswer.equals("y")){
				wantToCancel = true;
			}
			break;
		}
		return wantToCancel;
	}

	//������ȯ
	private void check_beverageChoose(String input){
		int num = Integer.parseInt(input);
		String str1 = UnitChange.toString_kind(num);
		System.out.printf("%s\n", str1);
	}
}
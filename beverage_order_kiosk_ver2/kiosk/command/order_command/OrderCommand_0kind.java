package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverKind;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;
import java.util.Scanner;

//���� ������ �Է¹޴� ���� ����
//��ҿ��� ����
public class OrderOperation0_kind implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();
		boolean isCanceled = false;
		int count = 0;

		boolean isOk = false;
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
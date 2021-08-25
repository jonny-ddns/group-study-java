package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;

import java.util.Scanner;

//���� ������Ҹ� �Է¹޴� ���� ����
public class OrderCommand_5where implements OrderCommand {

	OrderFunctions orderFunctions;
	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();
		Order order = OrderCollection.get_orderData();
		boolean isCanceled = false;
		int count = 0;
		String input = "0";
		boolean isOk = false;

		while(!isOk) {
			count++;
			if(count > 5) {
				isCanceled = true;
				break;
			}
			input = getScanInput(scan);

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
				System.out.printf("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~%d)\n", BeverageInfo.WHERE.values().length);
			}
		}
		order.setBeverWhere(Integer.parseInt(input));
		return isCanceled;
	}

	//��ĳ�� �Է¹ޱ�
	private String getScanInput(Scanner scan){
		System.out.print("\n1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ���� c): ");
		return scan.next().trim().toLowerCase();
	}

	//������ ���� �Է¿��� Ȯ��
	private boolean checkScanInput(String input){
		boolean inputCheck = false;
		if(orderFunctions.isNumber(input)){
			int num = Integer.parseInt(input);
			int count = BeverageInfo.WHERE.values().length;

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
		String str = UnitChange.toString_temper(num);
		System.out.printf("%s\n", str);
	}
}
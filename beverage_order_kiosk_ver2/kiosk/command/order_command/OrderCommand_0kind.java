package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import java.util.Map;
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
		String input = "0";
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
				System.out.printf("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~%d)\n", BeverageInfo.KIND.values().length);
			}
		}
		setOrderData(Integer.parseInt(input));
		return isCanceled;
	}

	/*-------------------------*/
	//�޴� ���
	private void printMenu() {
		Map<String, Integer> menuMap = new BeverageInfo().getBeverageMap();
		BeverageInfo.KIND[] beverages = BeverageInfo.KIND.values();

		String line     = "-------------------------";
		System.out.println(line);
		System.out.println("�޴�");

		String beverKind;
		int price;
		for(int i = 0; i< beverages.length; i++){
			beverKind = beverages[i].toString();
			price = menuMap.get(beverKind);
			System.out.printf(" %d. %s\t%d��\n", i+1, beverKind, price);
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
			int count = BeverageInfo.KIND.values().length;

			//���ڰ� ������ �ش��ϴ��� Ȯ��
			if(0<num && num<count+1) {
				inputCheck = true;
			}
		}
		return inputCheck;
	}

	//��ҿ��� �����
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

	private void setOrderData(int num){
		Order order = OrderCollection.get_orderData();
		order.setBeverKind(num);
	}
}
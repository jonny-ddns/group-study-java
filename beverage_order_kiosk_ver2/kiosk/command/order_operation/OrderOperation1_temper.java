package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.Order;
import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverTemper;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.Scanner;

//���� �µ��� �Է¹޴� ���� ����
public class OrderOperation1_temper implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		Order order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			 boolean tmp = true;
		}

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
				System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~2)");
			}
		}
		order.setBeverTemper(input);
		return isCanceled;
	}

//    @Override
//    public boolean execute(Scanner scan) {
//    	orderFunctions = new OrderFunctions();
//
//		//Ŀ�� ������ �ֹ����� �ʾҴٸ� �Ʒ� while �� ������� ����
//		Order order = OrderCollection.get_orderData();
//		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
//			goToNext = true;
//		}
//
//        while(!goToNext) {
//			System.out.print("\n1.ice 2.hot ���� (�ֹ���� c): ");
//	    	String request = scan.next().trim().toLowerCase();
//      		boolean isNumber = orderFunctions.isNumber(request);
//
//            if(isNumber){
//              	int num = Integer.parseInt(request);
//                int count = BeverTemper.values().length;
//
//                if(0<num && num<count+1) {
//                	input = num;
//
//                	int kind = order.getBeverKind();
//                	String str1 = UnitChange.toString_kind(kind);
//                	String str2 = UnitChange.toString_temper(num);
//
//                	System.out.printf("%s(%s)\n", str1, str2);
//            		goToNext = true;
//            	} else {
//            		System.out.println("��ȣ�� �ٽ� �Է¹ٶ��ϴ� (1~2)");
//            	}
//            }
//            else if(request.equals("c")) {
//            	System.out.println("\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ");
//
//            	request = scan.next().trim().toLowerCase();
//            	boolean isYesOrNo = orderFunctions.isYesOrNo(request);
//
//            	if(isYesOrNo && request.equals("y")) {
//					System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���");
//                	isCanceled = true;
//                	break;
//            	}
//            }
//            else {
//				System.out.println("���ڸ� �Է¹ٶ��ϴ�");
//            }
//    	}
//        order.setBeverTemper(input);
//    	return isCanceled;
//    }




	/*-------------------------*/
	//��ĳ�� �Է¹ޱ�
	private String getScanInput(Scanner scan){
		System.out.print("\n1.ice 2.hot ���� (�ֹ���� c): ");
		return scan.next().trim().toLowerCase();
	}

	//������ ���� �Է¿��� Ȯ��
	private boolean checkScanInput(String input){
		boolean inputCheck = false;
		if(orderFunctions.isNumber(input)){
			int num = Integer.parseInt(input);
			int count = BeverTemper.values().length;

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
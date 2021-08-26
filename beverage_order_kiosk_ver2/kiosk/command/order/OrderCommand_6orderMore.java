package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Scanner;

//추가주문 여부를 입력받기
public class OrderCommand_6orderMore implements OrderCommand {
	private final OrderFunctions orderFunctions = new OrderFunctions();
	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		System.out.println("\n추가주문 하시겠습니까? (y/n): ");
		while(!isOk) {
			count++;
			if(count > 5) {
				break;
			}
			System.out.print("입력 : ");
			input = scan.next().trim().toLowerCase();

			//취소시
			if(input.equals("c")){
				if(orderFunctions.askOrderCancel(scan)){
//					System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
					break;
				}
				count = 0;
				continue;
			}

			//입력값 확인
			int index = BeverageInfo.SHOT.values().length;
			if(orderFunctions.checkInputRange(input, index)){
//				check_beverageChoose(input);
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("번호를 다시 입력바랍니다 (1~%d)\n", BeverageInfo.WHERE.values().length);
			}
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}

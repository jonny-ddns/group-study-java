package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Scanner;

//음료 샷 개수를 입력받는 역할 수행
public class OrderCommand_3_shot implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();
	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		System.out.println("\n1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소 c)");
		while(!isOk) {
			count++;
			if(count > 5) {
				break;
			}
			System.out.print("입력 : ");
			input = scan.next().trim().toLowerCase();

			//취소시
			if(input.equals("c")){
				if(commandFunctions.askOrderCancel(scan)){
					System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
					break;
				}
				count = 0;
				continue;
			}

			//입력값 확인
			int index = BeverageInfo.SHOT.values().length;
			if(commandFunctions.checkInputRange(input, index)){
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("번호를 다시 입력바랍니다 (1~%d)\n", BeverageInfo.SHOT.values().length);
			}
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}
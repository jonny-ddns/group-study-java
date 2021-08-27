package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Scanner;

//음료 종류를 입력받는 역할 수행
//취소여부 리턴
public class OrderCommand_0_kind implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();

	@Override
	public int[] execute(Scanner scan) {
		int isCanceled = 1;
		int answer;
		int count = 0;
		boolean isOk = false;
		String input = "0";

		commandFunctions.printMenu();
		System.out.println("\n음료(번호)를 선택해주세요 (주문취소 c)");
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
			int index = BeverageInfo.KIND.values().length;
			if(commandFunctions.checkInputRange(input, index)){
				isCanceled = 0;
				isOk = true;
			} else{
				System.out.printf("번호를 다시 입력바랍니다 (1~%d)\n", BeverageInfo.KIND.values().length);
			}
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}
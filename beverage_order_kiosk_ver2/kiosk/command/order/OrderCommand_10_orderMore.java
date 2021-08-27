package beverage_order_kiosk_ver2.kiosk.command.order;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;
import java.util.Scanner;

//추가주문 여부를 입력받기
//리턴 - 취소여부/추가주문여부
public class OrderCommand_10_orderMore implements OrderCommand {
	private final CommandFunctions commandFunctions = new CommandFunctions();
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
				if(commandFunctions.askOrderCancel(scan)){
//					System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
					break;
				}
				count = 0;
				continue;
			}

			//입력값 확인
			if(!commandFunctions.isYesOrNo(input)){
				System.out.println("y 혹은 n을 입력바랍니다");
				continue;
			}

			if(input.equals("y")){
				System.out.println("추가주문 YES");
				input = "1";
			} else {
				System.out.println("추가주문 NO");
				input = "0";
			}
			isCanceled = 0;
			isOk = true;
		}
		answer = Integer.parseInt(input);
		return new int[]{isCanceled, answer};
	}
}

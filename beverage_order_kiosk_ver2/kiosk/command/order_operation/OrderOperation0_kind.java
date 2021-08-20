package beverage_order_kiosk_ver2.kiosk.command.order_operation;

import beverage_order_kiosk_ver2.kiosk.menu_enum.BeverKind;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;
import java.util.Scanner;

//음료 종류를 입력받는 역할 수행
public class OrderOperation0_kind implements OrderOperation {
	OrderFunctions orderFunctions;

	@Override
	public boolean execute(Scanner scan) {
		orderFunctions = new OrderFunctions();

		boolean isCanceled = false;        //리턴 객체
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
				System.out.println("번호를 다시 입력바랍니다 (1~6)");
			}
		}
		return isCanceled;
	}

	//스캐너 입력받기
	private String getScanInput(Scanner scan){
		System.out.print("\n음료(번호)를 선택해주세요 (주문취소 c): ");
		return scan.next().trim().toLowerCase();
	}

	//적절한 숫자 입력여부 확인
	private boolean checkScanInput(String input){
		boolean inputCheck = false;
		if(orderFunctions.isNumber(input)){
			int num = Integer.parseInt(input);
			int count = BeverKind.values().length;

			//숫자가 범위에 해당하는지 확인
			if(0<num && num<count+1) {
				inputCheck = true;
			}
		}
		return inputCheck;
	}

	//취소 멘트 출력
	private boolean askOrderCancel(Scanner scan){
		System.out.println("\n주문을 취소하시겠습니까? (y/n): ");
		String input;
		boolean isCanceled = false;
		//y or n 입력 확인
		input = scan.next().trim().toLowerCase();
		boolean isYesOrNo = orderFunctions.isYesOrNo(input);

		if(isYesOrNo && input.equals("y")) {
			System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
			isCanceled = true;
		}
		return isCanceled;
	}
}
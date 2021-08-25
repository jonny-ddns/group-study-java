package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.receipt.UnitChange;

import java.util.Scanner;

//음료 섭취장소를 입력받는 역할 수행
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

			//취소시
			if(input.equals("c")){
				if(askOrderCancel(scan)){
					System.out.println("주문이 취소되었습니다. 다시 입력해주세요");
					break;
				}
				count = 0;
				continue;
			}

			//입력값 확인
			if(checkScanInput(input)){
				check_beverageChoose(input);
				isOk = true;
			} else{
				System.out.printf("번호를 다시 입력바랍니다 (1~%d)\n", BeverageInfo.WHERE.values().length);
			}
		}
		order.setBeverWhere(Integer.parseInt(input));
		return isCanceled;
	}

	//스캐너 입력받기
	private String getScanInput(Scanner scan){
		System.out.print("\n1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소 c): ");
		return scan.next().trim().toLowerCase();
	}

	//적절한 숫자 입력여부 확인
	private boolean checkScanInput(String input){
		boolean inputCheck = false;
		if(orderFunctions.isNumber(input)){
			int num = Integer.parseInt(input);
			int count = BeverageInfo.WHERE.values().length;

			//숫자가 범위에 해당하는지 확인
			if(0<num && num<count+1) {
				inputCheck = true;
			}
		}
		return inputCheck;
	}

	//반복문 돌면서 취소여부 물어보기
	private boolean askOrderCancel(Scanner scan){
		System.out.println("\n주문을 취소하시겠습니까? (y/n): ");
		boolean wantToCancel = false;
		int count = 0;
		while( count<3 ){
			count++;
			System.out.print("입력 : ");
			String cancelAnswer = scan.next().trim().toLowerCase();

			if(!orderFunctions.isYesOrNo(cancelAnswer)){
				System.out.println("y 혹은 n을 입력바랍니다");
				continue;
			}
			if(cancelAnswer.equals("y")){
				wantToCancel = true;
			}
			break;
		}
		return wantToCancel;
	}

	//단위변환
	private void check_beverageChoose(String input){
		int num = Integer.parseInt(input);
		String str = UnitChange.toString_temper(num);
		System.out.printf("%s\n", str);
	}
}
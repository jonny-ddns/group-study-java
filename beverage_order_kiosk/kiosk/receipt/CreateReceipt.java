package beverage_order_kiosk.kiosk.receipt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.Order_specifications;

public class CreateReceipt {
	int count;

	public CreateReceipt(int count) {

		receiptTemplate(count);
	}
	
   public void receiptTemplate(int count) {
  	
		//주문번호 생성
	  SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
	   String customerNum = sdf.format(new Date())+ count;

		//출력내용 생성
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n============================\n");
		sb.append("\t\t\t"+ customerNum+ "\n");
		sb.append("===========결제내역==========\n");
	   sb.append("품목\t\t\t\t\t금액\n");
	   sb.append("----------------------------\n");

	   //항목 + 금액 내용 생성하기
		List<Orders> orders = Order_specifications.get_orderList();
		int sum = 0;

		for(Orders order: orders) {

			ReceiptOrderInfo rc = new ReceiptOrderInfo();
			String[] items = rc.receiptItem(order);
			int[] moneys = rc.receiptMoney(order);

			String itemToPay = "";
			int moneyToPay =0;

			for(int i=0; i< items.length; i++){
				itemToPay = items[i];
				moneyToPay = moneys[i];
				sum += moneyToPay;

				sb.append(itemToPay);

				//탭 간격 조정 123
				if(i==0){
					sb.append("\t\t\t");
				}
				else if(0<i || i<4){
					sb.append("\t\t\t\t\t\t");
				}
				else if(i==4){
//					sb.append(" ");
				}

				sb.append(moneyToPay);
				sb.append("\n");
			}
			sb.append("----------------------------\n");
		}
		sb.append("합계\t\t\t\t\t"+ sum+ "\n");
		sb.append("============================\n\n");
	   sb.append("--영수증을 챙겨주세요--");
		
		System.out.println(sb.toString());
   }
}

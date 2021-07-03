package beverage_order_kiosk.kiosk.receipt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import beverage_order_kiosk.kiosk.customerOrder.Orders;
import beverage_order_kiosk.kiosk.customerOrder.OrderCollection;

public class CreateReceipt {
	int count;

	public CreateReceipt(int count) {
		receiptTemplate(count);
	}
	
   private void receiptTemplate(int count) {
  	
		//�ֹ���ȣ ����
	  SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
	   String customerNum = sdf.format(new Date())+ count;

		//��³��� ����
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n=====================\n");
		sb.append("\t"+ customerNum+ "\n");
		sb.append("========��������=======\n");
	   sb.append("ǰ��\t\t�ݾ�\n");
	   sb.append("---------------------\n");

	   //�׸� + �ݾ� ���� �����ϱ�
		List<Orders> orders = OrderCollection.get_orderList();
		int sum = 0;

		for(Orders order: orders) {

			ReceiptOrderInfo rc = new ReceiptOrderInfo();
			String[] items = rc.receiptItem(order);
			int[] moneys = rc.receiptMoney(order);
			
			String itemToPay = "";
			int moneyToPay =0;

			for(int i=0; i<items.length; i++){
				itemToPay = items[i];
				moneyToPay = moneys[i];
				sum += moneyToPay;

				sb.append(itemToPay);

				//�� ���� ���� 123
//				if(i<4){
					sb.append("\t\t");
//				}
//				else if(i==4){
//					sb.append("\t\t\t");
//				}

				sb.append(moneyToPay);
				sb.append("\n");
			}
			sb.append("---------------------\n");
		}
		sb.append("�հ�\t\t"+ sum+ "\n");
		sb.append("=====================\n\n");
	   sb.append("--�������� ì���ּ���--");
		
		System.out.println(sb.toString());
   }
}

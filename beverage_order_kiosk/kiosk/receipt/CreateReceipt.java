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
    
    //영수증의 기본뼈대를 구성하는 메서드
    private void receiptTemplate(int count) {

    	//주문번호 생성. 오늘날짜
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        String customerNum = sdf.format(new Date()) + count;
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n=====================\n");
        sb.append("\t" + customerNum + "\n");
        sb.append("========결제내역=======\n");
        sb.append("품목\t\t금액\n");
        sb.append("---------------------\n");
        
        //항목별 금액 생성하기
        List < Orders > orders = OrderCollection.get_orderList();
        int sum = 0;
        for (Orders order : orders) {
        	
        	//ReceiptOrderInfo 클래스 인스턴스로 값 변환하기
            ReceiptOrderInfo rc = new ReceiptOrderInfo();
            String[] items		= rc.receiptItem(order);
            int[] moneys		= rc.receiptMoney(order);
            
            String itemToPay = "";
            int moneyToPay = 0;
            
            for (int i = 0; i < items.length; i ++) {
                itemToPay = items[i];
                moneyToPay = moneys[i];
                sum += moneyToPay;
                sb.append(itemToPay);
                sb.append("\t\t");
                sb.append(moneyToPay);
                sb.append("\n");
            }
            sb.append("---------------------\n");
        }
        sb.append("합계\t\t" + sum + "\n");
        sb.append("=====================\n\n");
        sb.append("--영수증을 챙겨주세요--");
        System.out.println(sb.toString());
    }
}
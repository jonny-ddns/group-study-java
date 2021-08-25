package beverage_order_kiosk_ver2.kiosk.data.receipt;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {
    StringBuilder sb = new StringBuilder();

    public void receiptPrint(int count){
        System.out.println(receiptTemplate(count));
        sb.setLength(0);
    }

    //영수증의 기본뼈대를 구성하는 메서드
    private String receiptTemplate(int count) {
        //주문번호
        String customerNum = receiptNum(count);

        sb.append("\n\n=====================\n");
        sb.append("\t").append(customerNum).append("\n");
        sb.append("========결제내역=======\n");
        sb.append("품목\t\t금액\n");
        sb.append("---------------------\n");
        
        //항목별 금액 생성하기
        List <Order> orders = OrderCollection.get_orderList();
        int sum = 0;
        for (Order order : orders) {
        	
        	//ReceiptOrderInfo 클래스 인스턴스로 값 변환하기
            ReceiptOrderInfo receiptOrderInfo = new ReceiptOrderInfo();
            String[] items	= receiptOrderInfo.receiptItem(order);
            int[] moneys	= receiptOrderInfo.receiptMoney(order);
            
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
        sb.append("합계\t\t").append(sum).append("\n");
        sb.append("=====================\n\n");
        sb.append("--영수증을 챙겨주세요--");

        return sb.toString();
    }
    
    //주문번호 생성: 오늘날짜 + 주문개수
    private String receiptNum(int count){
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        return sdf.format(new Date()) + count;
    }

    //주문내역을 담은 Orders클래스의 각 항목이 int 이므로 값을 적절히 변경된 값을 가져오는 역할 수행
    //UnitChange 클래스의 메서드를 사용하여 값을 변경함
    private static class ReceiptOrderInfo {

        //create bill items. 영수증 품목생성
        String[] receiptItem(Order order){
            String[] billCategory = new String[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            String kindString = UnitChange.toString_kind(kindInt);
            String temperString = UnitChange.toString_temper(temperInt);
            String shotString = UnitChange.toString_shot(shotInt);
            String sizeString = UnitChange.toString_size(sizeInt);
            String whereString = UnitChange.toString_where(whereInt);

            billCategory[0] = kindString;
            billCategory[1] = temperString;
            billCategory[2] = shotString;
            billCategory[3] = sizeString;
            billCategory[4] = whereString;

            return billCategory;
        }

        //create bill money. 영수증 금액 생성
        int[] receiptMoney(Order order){
            UnitChange cu = new UnitChange();
            int[] billMoney = new int[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            int kindString = cu.toMoney_kind(kindInt);
            int temperString = cu.toMoney_temper(temperInt);
            int shotString = cu.toMoney_shot(shotInt);
            int sizeString = cu.toMoney_size(sizeInt);
            int whereString = cu.toMoney_where(whereInt);

            billMoney[0] = kindString;
            billMoney[1] = temperString;
            billMoney[2] = shotString;
            billMoney[3] = sizeString;
            billMoney[4] = whereString;

            return billMoney;
        }
    }
}
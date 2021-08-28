package beverage_order_kiosk_ver2.kiosk.command.payment.receipt;

import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Receipt {
    StringBuilder sb = new StringBuilder();

    public void receiptPrint(int count) {
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
        Collection<Order> orders = OrderInfos.getOrderCollection();
        int sum = 0;
        for (Order order : orders) {

            //ReceiptOrderInfo 클래스 인스턴스로 값 변환하기
            ReceiptOrderInfo receiptOrderInfo = new ReceiptOrderInfo();
            String[] items = receiptOrderInfo.receiptItem(order);
            int[] moneys = receiptOrderInfo.receiptMoney(order);

            String itemToPay;
            int moneyToPay;

            for (int i = 0; i < items.length; i++) {
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
    private String receiptNum(int count) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        return sdf.format(new Date()) + count;
    }

    //주문내역을 담은 Orders클래스의 각 항목이 int 이므로 값을 적절히 변경된 값을 가져오는 역할 수행
    //UnitChange 클래스의 메서드를 사용하여 값을 변경함
    private class ReceiptOrderInfo {
        UnitChange unitChange = new UnitChange();

        //create bill items. 영수증 품목생성
        String[] receiptItem(Order order) {
            String[] billCategory = new String[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            String kindString = unitChange.toString_kind(kindInt);
            String temperString = unitChange.toString_temper(temperInt);
            String shotString = unitChange.toString_shot(shotInt);
            String sizeString = unitChange.toString_size(sizeInt);
            String whereString = unitChange.toString_where(whereInt);

            billCategory[0] = kindString;
            billCategory[1] = temperString;
            billCategory[2] = shotString;
            billCategory[3] = sizeString;
            billCategory[4] = whereString;

            return billCategory;
        }

        //create bill money. 영수증 금액 생성
        int[] receiptMoney(Order order) {
            int[] billMoney = new int[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            int kindString = toMoney_kind(kindInt);
            int temperString = toMoney_temper(temperInt);
            int shotString = toMoney_shot(shotInt);
            int sizeString = toMoney_size(sizeInt);
            int whereString = toMoney_where(whereInt);

            billMoney[0] = kindString;
            billMoney[1] = temperString;
            billMoney[2] = shotString;
            billMoney[3] = sizeString;
            billMoney[4] = whereString;

            return billMoney;
        }
    }

//    private static class UnitChange {
//
//        /*------------------------------------------*/
//        //int -> 금액(int)으로 변경
        public int toMoney_kind(int i) {
//		Pricing p = new Pricing();
//		return p.getBeveragePrice()[i-1];
            return 999 * i;
        }

        public int toMoney_temper(int i) {
            return 0;
        }

        public int toMoney_shot(int i) {
            int money = 0;
            if (i == 2) {
                money = 500;
            }
            return money;
        }

        public int toMoney_size(int i) {
            return 500 * --i;
        }

        public int toMoney_where(int i) {
            int money = 0;
            if (i == 1) {
                money = 500;
            }
            return money;
        }
//    }
}




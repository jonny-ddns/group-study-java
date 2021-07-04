package beverage_order_kiosk.kiosk.receipt;

import beverage_order_kiosk.kiosk.customerOrder.Orders;

//주문내역을 담은 Orders클래스의 각 항목이 int 이므로 값을 적절히 변경된 값을 가져오는 역할 수행
//UnitChange 클래스의 메서드를 사용하여 값을 변경함
public class ReceiptOrderInfo {

    //create bill items. 영수증 품목생성
    String[] receiptItem(Orders order){
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
    int[] receiptMoney(Orders order){
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

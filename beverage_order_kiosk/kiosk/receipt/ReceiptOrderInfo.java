package beverage_order_kiosk.kiosk.receipt;

import beverage_order_kiosk.kiosk.customerOrder.Orders;

public class ReceiptOrderInfo {

    //create bill items
    public String[] receiptItem(Orders order){
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

    //create bill money
    public int[] receiptMoney(Orders order){
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

package beverage_order_kiosk_ver2.kiosk.command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.KIND;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.SHOT;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.SIZE;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.TEMPER;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.WHERE;

public class UnitChange {
    //int -> 요청사항(String)으로 변경
    public String toString_kind(int i) {
//        System.out.println("UnitChange - toString_kind : "+ BeverageInfo.KIND.values()[--i].toString()); //디버깅
//        return BeverageInfo.KIND.values()[--i].toString();
//        String tmp = ;
        return KIND.values()[i].toString();
    }

    public String toString_temper(int i) {
        if (i == 0) {
            return "";
        }
        return TEMPER.values()[i].toString();
    }

    public String toString_shot(int i) {
        if (i == 0) {
            return "";
        } else if (SHOT.values()[i].toString().equals(SHOT.ONE_SHOT.toString())) {
            return "1샷";
        }
        return "2샷";
    }

    public String toString_size(int i) {
        return SIZE.values()[i].toString();
    }

    public String toString_where(int i) {
        if (WHERE.values()[i].toString().equals(WHERE.STORE.toString())) {
            return "매장이용";
        }
        return "테이크아웃";
    }
}
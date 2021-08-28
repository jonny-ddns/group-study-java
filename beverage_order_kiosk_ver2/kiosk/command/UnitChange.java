package beverage_order_kiosk_ver2.kiosk.command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;

public class UnitChange {
    //int -> 요청사항(String)으로 변경
    public String toString_kind(int i) {
//        System.out.println("UnitChange - toString_kind : "+ BeverageInfo.KIND.values()[--i].toString()); //디버깅
//        return BeverageInfo.KIND.values()[--i].toString();
//        String tmp = ;
        return BeverageInfo.KIND.values()[--i].toString();
    }

    public String toString_temper(int i) {
        if(i == 0){
            return "";
        }
        return BeverageInfo.TEMPER.values()[--i].toString();
    }

    public String toString_shot(int i) {
        if(i == 0){
            return "";
        }
        else if(BeverageInfo.SHOT.values()[--i].toString().equals(BeverageInfo.SHOT.ONE_SHOT.toString())) {
            return "1샷";
        }
        return "2샷";
    }

    public String toString_size(int i) {
        return BeverageInfo.SIZE.values()[--i].toString();
    }

    public String toString_where(int i) {
        if(BeverageInfo.WHERE.values()[--i].toString().equals(BeverageInfo.WHERE.STORE.toString())) {
            return "매장이용";
        }
        return "테이크아웃";
    }

    public int price_kind(int i){
        String kind = BeverageInfo.KIND.values()[i].toString();

        return 0;
    }
    public int price_temper(int i){
        return 0;
    }
    public int price_shot(int i){
        return 0;
    }
    public int price_kize(int i){
        return 0;
    }
    public int price_where(int i){
        return 0;
    }
}

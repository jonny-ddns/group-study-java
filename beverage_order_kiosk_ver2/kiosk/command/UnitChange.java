package beverage_order_kiosk_ver2.kiosk.command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;

public class UnitChange {
    //int -> ��û����(String)���� ����
    public String toString_kind(int i) {
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
            return "1��";
        }
        return "2��";
    }

    public String toString_size(int i) {
        return BeverageInfo.SIZE.values()[--i].toString();
    }

    public String toString_where(int i) {
        if(BeverageInfo.WHERE.values()[--i].toString().equals(BeverageInfo.WHERE.STORE.toString())) {
            return "�����̿�";
        }
        return "����ũ�ƿ�";
    }
}

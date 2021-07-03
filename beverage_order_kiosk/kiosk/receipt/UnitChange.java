package beverage_order_kiosk.kiosk.receipt;

import beverage_order_kiosk.kiosk.menu_enums.*;

public class UnitChange {
	
	public static String toString_kind(int i) {
		return ����.values()[--i].toString();
	}
	
	public static String toString_temper(int i) {
		return BeverTemper.values()[--i].toString();
	}
	
	public static String toString_shot(int i) {
		if(BeverShot.values()[--i].toString().equals(BeverShot.ONE_SHOT.toString())) {
			return "1��";
		}
		return "2��";
	}
	
	public static String toString_size(int i) {
		return BeverSize.values()[--i].toString();
	}
	
	public static String toString_where(int i) {
		if(BeverWhere.values()[--i].toString().equals(BeverWhere.STORE.toString())) {
			return "�����̿�";
		}
		return "����ũ�ƿ�";
	}

	/*------------------------------------------*/

	public int toMoney_kind(int i){
		Pricing p = new Pricing();
		return p.getBeveragePrice()[i-1];
	}
	public int toMoney_temper(int i){
		return 0;
	}
	public int toMoney_shot(int i){
		int money = 0;
		if(i == 2){
			money = 500;
		}
		return money;
	}
	public int toMoney_size(int i){
		return 500*--i;
	}
	public int toMoney_where(int i){
		int money = 0;
		if(i==1){
			money = 500;
		}
		return money;
	}
}

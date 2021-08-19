package beverage_order_kiosk_ver2.kiosk.receipt;

import beverage_order_kiosk_ver2.kiosk.menu_enum.*;

public class UnitChange {
	
	//int -> ��û����(String)���� ����
	public static String toString_kind(int i) {
		return BeverKind_ko.values()[--i].toString();
	}
	
	public static String toString_temper(int i) {
		if(i == 0){
			return "";
		}
		return BeverTemper.values()[--i].toString();
	}
	
	public static String toString_shot(int i) {
		if(i == 0){
			return "";
		}
		else if(BeverShot.values()[--i].toString().equals(BeverShot.ONE_SHOT.toString())) {
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
	//int -> �ݾ�(int)���� ����
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

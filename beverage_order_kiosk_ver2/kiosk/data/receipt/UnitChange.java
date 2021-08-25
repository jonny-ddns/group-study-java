package beverage_order_kiosk_ver2.kiosk.data.receipt;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;

public class UnitChange {
	BeverageInfo beverageInfo = new BeverageInfo();

	//int -> ��û����(String)���� ����
	public static String toString_kind(int i) {
		return BeverageInfo.KIND.values()[--i].toString();
	}
	
	public static String toString_temper(int i) {
		if(i == 0){
			return "";
		}
		return BeverageInfo.TEMPER.values()[--i].toString();
	}
	
	public static String toString_shot(int i) {
		if(i == 0){
			return "";
		}
		else if(BeverageInfo.SHOT.values()[--i].toString().equals(BeverageInfo.SHOT.ONE_SHOT.toString())) {
			return "1��";
		}
		return "2��";
	}
	
	public static String toString_size(int i) {
		return BeverageInfo.SIZE.values()[--i].toString();
	}
	
	public static String toString_where(int i) {
		if(BeverageInfo.WHERE.values()[--i].toString().equals(BeverageInfo.WHERE.STORE.toString())) {
			return "�����̿�";
		}
		return "����ũ�ƿ�";
	}

	/*------------------------------------------*/
	//int -> �ݾ�(int)���� ����
	public int toMoney_kind(int i){
//		Pricing p = new Pricing();
//		return p.getBeveragePrice()[i-1];
		return 999*i;
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

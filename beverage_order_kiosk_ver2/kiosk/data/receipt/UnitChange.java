package beverage_order_kiosk_ver2.kiosk.data.receipt;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;

public class UnitChange {
	BeverageInfo beverageInfo = new BeverageInfo();

	//int -> 요청사항(String)으로 변경
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
			return "1샷";
		}
		return "2샷";
	}
	
	public static String toString_size(int i) {
		return BeverageInfo.SIZE.values()[--i].toString();
	}
	
	public static String toString_where(int i) {
		if(BeverageInfo.WHERE.values()[--i].toString().equals(BeverageInfo.WHERE.STORE.toString())) {
			return "매장이용";
		}
		return "테이크아웃";
	}

	/*------------------------------------------*/
	//int -> 금액(int)으로 변경
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

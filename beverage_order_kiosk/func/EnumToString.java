package beverage_order_kiosk.func;

import beverage_order_kiosk.menu_enums.BeverShot;
import beverage_order_kiosk.menu_enums.BeverSize;
import beverage_order_kiosk.menu_enums.BeverTemper;
import beverage_order_kiosk.menu_enums.BeverWhere;
import beverage_order_kiosk.menu_enums.����;

public class EnumToString {
	
	public static String strKind(int i) {
		return ����.values()[--i].toString();
	}
	
	public static String strTemper(int i) {
		return BeverTemper.values()[--i].toString();
	}
	
	public static String strShot(int i) {
		if(BeverShot.values()[--i].toString().equals(BeverShot.ONE_SHOT.toString())) {
			return "1��";
		}
		return "2��";
	}
	
	public static String strSize(int i) {
		return BeverSize.values()[--i].toString();
	}
	
	public static String strWhere(int i) {
		if(BeverWhere.values()[--i].toString().equals(BeverWhere.STORE.toString())) {
			return "����";
		}
		return "����ũ�ƿ�";
	}
}

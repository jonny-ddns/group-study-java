package beverage_order_kiosk.kiosk.menu_enum;

public class Pricing {
    private final int PRICE01 = 1000;
    private final int PRICE02 = 2500;
    private final int PRICE03 = 3000;
    private final int PRICE04 = 3000;
    private final int PRICE05 = 4000;
    private final int PRICE06 = 4000;
    
    public int[] getBeveragePrice() {    	
    	int[] priceArr = {PRICE01, PRICE02, PRICE03, PRICE04, PRICE05, PRICE06};
    	return priceArr;
    }
}

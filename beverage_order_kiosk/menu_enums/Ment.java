package beverage_order_kiosk.menu_enums;

public class Ment {
    private static final String MENT0_CHOOSE = "음료를 선택해주세요 :";
    private static final String MENT1_TEMPER = "1.ice 2.hot 선택 (주문취소c) :";
    private static final String MENT2_SHOT = "1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소c) :";
    private static final String MENT3_SIZE = "1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소c) :";
    private static final String MENT4_WHERE = "1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소c) :";
    private static final String MENT5_orderMore = "추가주문 하시겠습니까?(y/n) :";
    private static final String MENT6_CANCEL = "주문을 취소하시겠습니까?(y/n) :";
    
    public static String getMent0Choose() {
		return MENT0_CHOOSE;
	}
	public static String getMent1Temper() {
		return MENT1_TEMPER;
	}
	public static String getMent2Shot() {
		return MENT2_SHOT;
	}
	public static String getMent3Size() {
		return MENT3_SIZE;
	}
	public static String getMent4Where() {
		return MENT4_WHERE;
	}
	public static String getMent5Ordermore() {
		return MENT5_orderMore;
	}
	public static String getMent6Cancel() {
		return MENT6_CANCEL;
	}
	
    public static void printOrderCheck() {
    	System.out.println("ORDER CHECK");
    }
}

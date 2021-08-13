package beverage_order_kiosk_ver2.kiosk.operation;

public class Mention {
    private final String MENT0_CHOOSE		= "\n음료(번호)를 선택해주세요 (주문취소 c): ";
    private final String MENT1_TEMPER		= "\n1.ice 2.hot 선택 (주문취소 c): ";
    private final String MENT2_SHOT 		= "\n1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소 c): ";
    private final String MENT3_SIZE			= "\n1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소 c): ";
    private final String MENT4_WHERE		= "\n1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소 c): ";
    private final String MENT5_ORDER_MORE 	= "\n추가주문 하시겠습니까? (y/n): ";
    private final String MENT6_CANCEL		= "\n주문을 취소하시겠습니까? (y/n): ";
	private final String MENT7_ORDER_AGAIN 	= "주문이 취소되었습니다. 다시 입력해주세요";
	private final String MENT8_NUMBER_ONLY 	= "숫자를 입력바랍니다";
	private final String MENT9_YN_ONLY		= "y 혹은 n을 입력바랍니다";

    public String getMent0_choose() { return MENT0_CHOOSE; }
	public String getMent1_temper() {
		return MENT1_TEMPER;
	}
	public String getMent2_shot() {
		return MENT2_SHOT;
	}
	public String getMent3_size() {
		return MENT3_SIZE;
	}
	public String getMent4_where() {
		return MENT4_WHERE;
	}
	public String getMent5_orderMore() {
		return MENT5_ORDER_MORE;
	}
	public String getMent6_cancel() {
		return MENT6_CANCEL;
	}
	public String getMent7_orderAgain(){ return MENT7_ORDER_AGAIN; }
	public String getMent8_numberOnly() { return MENT8_NUMBER_ONLY; }
	public String getMent9_yn_only() { return MENT9_YN_ONLY; }
}
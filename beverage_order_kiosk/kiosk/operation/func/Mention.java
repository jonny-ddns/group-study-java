package beverage_order_kiosk.kiosk.operation.func;

public class Mention {
    private final String MENT0_CHOOSE		= "\n음료(번호)를 선택해주세요 (주문취소 c): ";
    private final String MENT1_TEMPER		= "\n1.ice 2.hot 선택 (주문취소 c): ";
    private final String MENT2_SHOT 		= "\n1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소 c): ";
    private final String MENT3_SIZE			= "\n1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소 c): ";
    private final String MENT4_WHERE		= "\n1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소 c): ";
    private final String MENT5_orderMore 	= "\n추가주문 하시겠습니까? (y/n): ";
    private final String MENT6_CANCEL		= "\n주문을 취소하시겠습니까? (y/n): ";
	private final String MENT7_OrderAgain	= "주문이 취소되었습니다. 다시 입력해주세요";
	private final String MENT_NUMBER_ONLY	= "숫자를 입력바랍니다";

    public String getMent0Choose() { return MENT0_CHOOSE; }
	public String getMent1Temper() {
		return MENT1_TEMPER;
	}
	public String getMent2Shot() {
		return MENT2_SHOT;
	}
	public String getMent3Size() {
		return MENT3_SIZE;
	}
	public String getMent4Where() {
		return MENT4_WHERE;
	}
	public String getMent5Ordermore() {
		return MENT5_orderMore;
	}
	public String getMent6Cancel() {
		return MENT6_CANCEL;
	}
	public String getMent7OrderAgain(){ return MENT7_OrderAgain; }
	public String getMent_NumberOnly() { return MENT_NUMBER_ONLY; }
}
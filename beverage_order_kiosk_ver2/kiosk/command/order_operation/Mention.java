package beverage_order_kiosk_ver2.kiosk.command.order_operation;

public class Mention {
	public String getMent0_choose() { return "\n음료(번호)를 선택해주세요 (주문취소 c): "; }
	public String getMent1_temper() { return "\n1.ice 2.hot 선택 (주문취소 c): "; }
	public String getMent2_shot() { return "\n1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소 c): "; }
	public String getMent3_size() { return "\n1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소 c): "; }
	public String getMent4_where() { return "\n1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소 c): "; }
	public String getMent5_orderMore() { return "\n추가주문 하시겠습니까? (y/n): "; }
	public String getMent6_cancel() { return "\n주문을 취소하시겠습니까? (y/n): "; }
	public String getMent7_orderAgain(){ return "주문이 취소되었습니다. 다시 입력해주세요"; }
	public String getMent8_numberOnly() { return "숫자를 입력바랍니다"; }
	public String getMent9_yn_only() { return "y 혹은 n을 입력바랍니다"; }
}
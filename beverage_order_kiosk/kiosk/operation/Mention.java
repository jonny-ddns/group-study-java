package beverage_order_kiosk.kiosk.operation;

public class Mention {
    private final String MENT0_CHOOSE		= "\n����(��ȣ)�� �������ּ��� (�ֹ���� c): ";
    private final String MENT1_TEMPER		= "\n1.ice 2.hot ���� (�ֹ���� c): ";
    private final String MENT2_SHOT 		= "\n1.1��(+0��) 2.2��(+500��) ���� (�ֹ���� c): ";
    private final String MENT3_SIZE			= "\n1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ���� c): ";
    private final String MENT4_WHERE		= "\n1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ���� c): ";
    private final String MENT5_ORDER_MORE 	= "\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): ";
    private final String MENT6_CANCEL		= "\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ";
	private final String MENT7_ORDER_AGAIN 	= "�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���";
	private final String MENT8_NUMBER_ONLY 	= "���ڸ� �Է¹ٶ��ϴ�";
	private final String MENT9_YN_ONLY		= "y Ȥ�� n�� �Է¹ٶ��ϴ�";

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
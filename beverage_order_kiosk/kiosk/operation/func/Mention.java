package beverage_order_kiosk.kiosk.operation.func;

public class Mention {
    private final String MENT0_CHOOSE		= "\n����(��ȣ)�� �������ּ��� (�ֹ���� c): ";
    private final String MENT1_TEMPER		= "\n1.ice 2.hot ���� (�ֹ���� c): ";
    private final String MENT2_SHOT 		= "\n1.1��(+0��) 2.2��(+500��) ���� (�ֹ���� c): ";
    private final String MENT3_SIZE			= "\n1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ���� c): ";
    private final String MENT4_WHERE		= "\n1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ���� c): ";
    private final String MENT5_orderMore 	= "\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): ";
    private final String MENT6_CANCEL		= "\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ";
	private final String MENT7_OrderAgain	= "�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���";
	private final String MENT_NUMBER_ONLY	= "���ڸ� �Է¹ٶ��ϴ�";

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
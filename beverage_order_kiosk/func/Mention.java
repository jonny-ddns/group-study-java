package beverage_order_kiosk.func;

public class Mention {
    private static final String MENT0_CHOOSE = "���Ḧ �������ּ��� :";
    private static final String MENT1_TEMPER = "1.ice 2.hot ���� (�ֹ����c) :";
    private static final String MENT2_SHOT = "1.1��(+0��) 2.2��(+500��) ���� (�ֹ����c) :";
    private static final String MENT3_SIZE = "1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ����c) :";
    private static final String MENT4_WHERE = "1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ����c) :";
    private static final String MENT5_orderMore = "�߰��ֹ� �Ͻðڽ��ϱ�?(y/n) :";
    private static final String MENT6_CANCEL = "�ֹ��� ����Ͻðڽ��ϱ�?(y/n) :";
    
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
}

package beverage_order_kiosk.kiosk;

public class Ment {
    private static final String MENT0_choose = "���Ḧ �������ּ��� :";
    private static final String MENT1_iceHot = "1.ice 2.hot ���� (�ֹ����c) :";
    private static final String MENT2_SHOT = "1.1��(+0��) 2.2��(+500��) ���� (�ֹ����c) :";
    private static final String MENT3_SIZE = "1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ����c) :";
    private static final String MENT4_WHERE = "1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ����c) :";
    private static final String MENT5_orderMore = "�߰��ֹ� �Ͻðڽ��ϱ�?(y/n) :";
    private static final String MENT6_CANCEL = "�ֹ��� ����Ͻðڽ��ϱ�?(y/n) :";

    public static String[] getMents(){
        String[] ments = new String[7];

        ments[0] = Ment.MENT0_choose;
        ments[1] = Ment.MENT1_iceHot;
        ments[2] = Ment.MENT2_SHOT;
        ments[3] = Ment.MENT3_SIZE;
        ments[4] = Ment.MENT4_WHERE;
        ments[5] = Ment.MENT5_orderMore;
        ments[6] = Ment.MENT6_CANCEL;

        return ments;
    }
}

package beverage_order_kiosk.kiosk;

public class Ment {
    private static final String MENT0_choose = "음료를 선택해주세요 :";
    private static final String MENT1_iceHot = "1.ice 2.hot 선택 (주문취소c) :";
    private static final String MENT2_SHOT = "1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소c) :";
    private static final String MENT3_SIZE = "1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소c) :";
    private static final String MENT4_WHERE = "1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소c) :";
    private static final String MENT5_orderMore = "추가주문 하시겠습니까?(y/n) :";
    private static final String MENT6_CANCEL = "주문을 취소하시겠습니까?(y/n) :";

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

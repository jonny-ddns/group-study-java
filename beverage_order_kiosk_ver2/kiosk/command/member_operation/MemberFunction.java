package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;

public class MemberFunction {
    //���ڰ��� �������� Ȯ���ϱ�
    public boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }
}

package beverage_order_kiosk_ver2.kiosk.operation;

import beverage_order_kiosk_ver2.kiosk.customerOrder.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.customerOrder.Orders;
import beverage_order_kiosk_ver2.kiosk.receipt.UnitChange;

import java.util.List;
import java.util.Scanner;

//�ֹ����� Ȯ�ΰ���� �Է¹޴� ���� ����
public class Operation6_orderCheck implements Operation {
    @Override
    public boolean execute(Scanner scan) {
        boolean goToNext 	= false;	//�ݺ� �÷��� ����
        boolean OrderCheck	= false;	//�ֹ� Ȯ�ΰ�� ����

        //�ֹ����� ����ϱ�
        List<Orders> orderList = OrderCollection.get_orderList();

        //OrderCollection �����ؼ� List�� ��� ��û���� ����ϱ�
        System.out.println();
        for(Orders order: orderList) {
	        int kind = order.getBeverKind();
	        int temper = order.getBeverTemper();
	        int shot = order.getBeverShot();
	        int size = order.getBeverSize();
	        int where = order.getBeverWhere();
	        String str1 = UnitChange.toString_kind(kind);
	        String str2 = UnitChange.toString_temper(temper);
	        String str3 = UnitChange.toString_shot(shot);
	        String str4 = UnitChange.toString_size(size);
	        String str5 = UnitChange.toString_where(where);
	
	        System.out.printf("%s(%s/%s/%s/%s)\n", str1, str2, str3, str4, str5);
        }
        System.out.print("�ֹ��Ͻðڽ��ϱ�? (y/n): ");
        
		//�ֹ�Ȯ�� ����� �ޱ����� �ݺ���
        while(!goToNext) {
            Mention m = new Mention();
            String request = scan.next().trim().toLowerCase();
            boolean isYesOrNo = CheckRequest.isYesOrNo(request);

            if(isYesOrNo) {
                if(request.equals("y")){
                    goToNext = true;
                    OrderCheck = true;
                    break;
                } else if(request.equals("n")){
                    System.out.println(m.getMent7_orderAgain());
                    goToNext = true;
                    break;
                }
            } else {
                System.out.println(m.getMent9_yn_only());
            }
        }
        return OrderCheck;
    }
}

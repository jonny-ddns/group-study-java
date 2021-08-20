package beverage_order_kiosk_ver2.kiosk.data.receipt;

import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderCollection;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {
    StringBuilder sb = new StringBuilder();

    public void receiptPrint(int count){
        System.out.println(receiptTemplate(count));
        sb.setLength(0);
    }

    //�������� �⺻���븦 �����ϴ� �޼���
    private String receiptTemplate(int count) {
        //�ֹ���ȣ
        String customerNum = receiptNum(count);

        sb.append("\n\n=====================\n");
        sb.append("\t").append(customerNum).append("\n");
        sb.append("========��������=======\n");
        sb.append("ǰ��\t\t�ݾ�\n");
        sb.append("---------------------\n");
        
        //�׸� �ݾ� �����ϱ�
        List <Order> orders = OrderCollection.get_orderList();
        int sum = 0;
        for (Order order : orders) {
        	
        	//ReceiptOrderInfo Ŭ���� �ν��Ͻ��� �� ��ȯ�ϱ�
            ReceiptOrderInfo receiptOrderInfo = new ReceiptOrderInfo();
            String[] items	= receiptOrderInfo.receiptItem(order);
            int[] moneys	= receiptOrderInfo.receiptMoney(order);
            
            String itemToPay = "";
            int moneyToPay = 0;
            
            for (int i = 0; i < items.length; i ++) {
                itemToPay = items[i];
                moneyToPay = moneys[i];
                sum += moneyToPay;
                sb.append(itemToPay);
                sb.append("\t\t");
                sb.append(moneyToPay);
                sb.append("\n");
            }
            sb.append("---------------------\n");
        }
        sb.append("�հ�\t\t").append(sum).append("\n");
        sb.append("=====================\n\n");
        sb.append("--�������� ì���ּ���--");

        return sb.toString();
    }
    
    //�ֹ���ȣ ����: ���ó�¥ + �ֹ�����
    private String receiptNum(int count){
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        return sdf.format(new Date()) + count;
    }

    //�ֹ������� ���� OrdersŬ������ �� �׸��� int �̹Ƿ� ���� ������ ����� ���� �������� ���� ����
    //UnitChange Ŭ������ �޼��带 ����Ͽ� ���� ������
    private class ReceiptOrderInfo {

        //create bill items. ������ ǰ�����
        String[] receiptItem(Order order){
            String[] billCategory = new String[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            String kindString = UnitChange.toString_kind(kindInt);
            String temperString = UnitChange.toString_temper(temperInt);
            String shotString = UnitChange.toString_shot(shotInt);
            String sizeString = UnitChange.toString_size(sizeInt);
            String whereString = UnitChange.toString_where(whereInt);

            billCategory[0] = kindString;
            billCategory[1] = temperString;
            billCategory[2] = shotString;
            billCategory[3] = sizeString;
            billCategory[4] = whereString;

            return billCategory;
        }

        //create bill money. ������ �ݾ� ����
        int[] receiptMoney(Order order){
            UnitChange cu = new UnitChange();
            int[] billMoney = new int[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            int kindString = cu.toMoney_kind(kindInt);
            int temperString = cu.toMoney_temper(temperInt);
            int shotString = cu.toMoney_shot(shotInt);
            int sizeString = cu.toMoney_size(sizeInt);
            int whereString = cu.toMoney_where(whereInt);

            billMoney[0] = kindString;
            billMoney[1] = temperString;
            billMoney[2] = shotString;
            billMoney[3] = sizeString;
            billMoney[4] = whereString;

            return billMoney;
        }
    }
}
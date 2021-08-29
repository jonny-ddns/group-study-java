package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class PaymentCommand_30_receipt implements PaymentCommand {

    private int paymentWay;
    private int receivedMoney;
    private final StringBuilder sb = new StringBuilder();

    public int getPaymentWay() {
        return paymentWay;
    }
    public PaymentCommand_30_receipt setPaymentWay(int paymentWay) {
        this.paymentWay = paymentWay;
        return this;
    }
    public int getReceivedMoney() {
        return receivedMoney;
    }
    public PaymentCommand_30_receipt setReceivedMoney(int receivedMoney) {
        this.receivedMoney = receivedMoney;
        return this;
    }

    @Override
    public int[] execute(Scanner scan) {
        String receipt = receiptTemplate();
        System.out.println(receipt);
        sb.setLength(0);
        return new int[0];
    }

    //�������� �⺻���븦 �����ϴ� �޼���
    private String receiptTemplate() {
        int paymentWay = getPaymentWay();
        int receivedMoney = getReceivedMoney();

        //�ֹ���ȣ
        String receiptNum = receiptNum();

        sb.append("\n\n=====================\n");
        sb.append("\t").append(receiptNum).append("\n");
        sb.append("========��������=======\n");
        sb.append("ǰ��\t\t�ݾ�\n");
        sb.append("---------------------\n");

        //�׸� �ݾ� �����ϱ�
        Collection<Order> orders = OrderInfos.getOrderCollection();
        int sum = 0;
        for (Order order : orders) {
            //ReceiptOrderInfo Ŭ���� �ν��Ͻ��� �� ��ȯ�ϱ�
            ReceiptOrderInfo receiptOrderInfo = new ReceiptOrderInfo();
            String[] items = receiptOrderInfo.receiptItem(order);
            int[] moneys = receiptOrderInfo.receiptMoney(order);

            String itemToPay;
            int moneyToPay;

            for (int i = 0; i < items.length; i++) {
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

    //�ֹ���ȣ ����
    //ex. 210901131312 - 00000000
    private String receiptNum() {
        return createReceiptNum_timeNow()+ "-"+ createReceiptNum_memberNum();
    }

    //�����Ͻ���(12)
    private String createReceiptNum_timeNow(){
        return new SimpleDateFormat("yyMMddHHmmss").format(new Date());
    }

    //ȸ����ȣ�� �޴���ȭ ���ڸ� * ���ڸ� -
    private String createReceiptNum_memberNum(){
        return "00000001";
    }

    //�ֹ������� ���� OrdersŬ������ �� �׸��� int �̹Ƿ� ���� ������ ����� ���� �������� ���� ����
    //UnitChange Ŭ������ �޼��带 ����Ͽ� ���� ������
    private class ReceiptOrderInfo {
        UnitChange unitChange = new UnitChange();

        //create bill items. ������ ǰ�����
        String[] receiptItem(Order order) {
            String[] billCategory = new String[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            String kindString = unitChange.toString_kind(kindInt);
            String temperString = unitChange.toString_temper(temperInt);
            String shotString = unitChange.toString_shot(shotInt);
            String sizeString = unitChange.toString_size(sizeInt);
            String whereString = unitChange.toString_where(whereInt);

            billCategory[0] = kindString;
            billCategory[1] = temperString;
            billCategory[2] = shotString;
            billCategory[3] = sizeString;
            billCategory[4] = whereString;

            return billCategory;
        }

        //create bill money. ������ �ݾ� ����
        int[] receiptMoney(Order order) {
            int[] billMoney = new int[5];

            int kindInt = order.getBeverKind();
            int temperInt = order.getBeverTemper();
            int shotInt = order.getBeverShot();
            int sizeInt = order.getBeverSize();
            int whereInt = order.getBeverWhere();

            int kindString = toMoney_kind(kindInt);
            int temperString = toMoney_temper(temperInt);
            int shotString = toMoney_shot(shotInt);
            int sizeString = toMoney_size(sizeInt);
            int whereString = toMoney_where(whereInt);

            billMoney[0] = kindString;
            billMoney[1] = temperString;
            billMoney[2] = shotString;
            billMoney[3] = sizeString;
            billMoney[4] = whereString;

            return billMoney;
        }
    }

    public int toMoney_kind(int i) {
        return 999 * i;
    }

    public int toMoney_temper(int i) {
        return 0;
    }

    public int toMoney_shot(int i) {
        int money = 0;
        if (i == 2) {
            money = 500;
        }
        return money;
    }

    public int toMoney_size(int i) {
        return 500 * --i;
    }

    public int toMoney_where(int i) {
        int money = 0;
        if (i == 1) {
            money = 500;
        }
        return money;
    }
}




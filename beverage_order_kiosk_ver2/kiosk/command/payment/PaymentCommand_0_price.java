package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.OrderPriceMap;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

//������ ���� �ȳ��ϱ�
public class PaymentCommand_0_price implements PaymentCommand {
    private final OrderPriceMap priceMap = new OrderPriceMap();

    @Override
    public int[] execute(Scanner scan) {
        StringBuilder sb = new StringBuilder();
        String line = "------------------------";

        //�ֹ����� ����
        sb.append(line).append("\n");
        sb.append("�ֹ��ݾ� Ȯ���ϼ��� (�Ʒ�)").append("\n");

        int priceTotal = getCategoryInfo(sb);

        //�ѱݾ� ����
        sb.append(line).append("\n");
        sb.append("\t").append("total : ").append(priceTotal);

        System.out.println(sb);
        sb.setLength(0);
        return new int[]{ priceTotal };
    }

    //�� �ֹ��� �ݾ� �����ϱ�
    private int getCategoryInfo(StringBuilder sb){
        Collection<Order> orderCollection = OrderInfos.getOrderCollection();
        int countIndividual;    //��������
        int priceIndividual;    //��������
        int priceCategory;
        int priceTotal = 0;

        //order������ ������ -> ī�װ��� ������ ��������
        for (Order order : orderCollection) {
            String line = "------------------------";
            priceIndividual = getData(sb, order);
            countIndividual = order.getBeverCount();
            sb.append("count : ").append(countIndividual).append("\n");
            sb.append(line).append("\n");

            //���� ���� �ݿ��� ���� ����
            priceCategory = countIndividual * priceIndividual;
            sb.append("\t").append("sum : ").append(priceCategory).append("\n");
            priceTotal += priceCategory;
        }
        return priceTotal;
    }

    //�� order�� �ش��ϴ� ����. ���پ� ���븸��� StringBuilder�� �߰�
    private int getData(StringBuilder sb, Order order) {
        String[] categoryName = {"KIND", "TEMPER", "SHOT", "SIZE", "WHERE"};
        String category;
        String[] resultData;
        int pricePartial;
        int priceWhole = 0;

        for (String enumName : categoryName) {
            resultData = getData_row(order, enumName);
            category = resultData[0];
            pricePartial = Integer.parseInt(resultData[1]);
            priceWhole += pricePartial;
            sb.append(category).append("\t")
                    .append(pricePartial)
                    .append("\n");
        }
        return priceWhole;
    }

    //�ֹ�����-���پ� �迭�� ��������
    private String[] getData_row(Order order, String enumName) {
        Map<String, Integer> map;
        String category = "";
        int price = 0;
        int index;
        switch (enumName){
            case "KIND":
                map = priceMap.getBeverageMapKind();
                index = order.getBeverKind();
                category = KIND.values()[index].toString();
                price = map.get(category);
                break;
            case "TEMPER":
                map = priceMap.getBeverageMapTemper();
                index = order.getBeverTemper();
                category = TEMPER.values()[index].toString();
                price = map.get(category);
                break;
            case "SHOT":
                map = priceMap.getBeverageMapShot();
                index = order.getBeverShot();
                category = SHOT.values()[index].toString();
                price = map.get(category);
                break;
            case "SIZE":
                map = priceMap.getBeverageMapSize();
                index = order.getBeverSize();
                category = SIZE.values()[index].toString();
                price = map.get(category);
                break;
            case "WHERE":
                map = priceMap.getBeverageMapWhere();
                index = order.getBeverWhere();
                category = WHERE.values()[index].toString();
                price = map.get(category);
                break;
        }
        return new String[]{category, Integer.toString(price)};
    }
}


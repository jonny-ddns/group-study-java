package beverage_order_kiosk_ver2.kiosk.command.payment;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.OrderPriceMap;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.*;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.Order;
import beverage_order_kiosk_ver2.kiosk.data.orderInfo.OrderInfos;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

//결제할 가격 안내하기
public class PaymentCommand_0_price implements PaymentCommand {
    private final OrderPriceMap priceMap = new OrderPriceMap();

    @Override
    public int[] execute(Scanner scan) {
        StringBuilder sb = new StringBuilder();
        String line = "------------------------";

        //주문내역 생성
        sb.append(line).append("\n");
        sb.append("주문금액 확인하세요 (아래)").append("\n");

        int priceTotal = getCategoryInfo(sb);

        //총금액 생성
        sb.append(line).append("\n");
        sb.append("\t").append("total : ").append(priceTotal);

        System.out.println(sb);
        sb.setLength(0);
        return new int[]{ priceTotal };
    }

    //각 주문별 금액 리턴하기
    private int getCategoryInfo(StringBuilder sb){
        Collection<Order> orderCollection = OrderInfos.getOrderCollection();
        int countIndividual;    //종류개수
        int priceIndividual;    //종류가격
        int priceCategory;
        int priceTotal = 0;

        //order정보를 넣으면 -> 카테고리와 가격을 가져오기
        for (Order order : orderCollection) {
            String line = "------------------------";
            priceIndividual = getData(sb, order);
            countIndividual = order.getBeverCount();
            sb.append("count : ").append(countIndividual).append("\n");
            sb.append(line).append("\n");

            //음료 개수 반영한 정보 생성
            priceCategory = countIndividual * priceIndividual;
            sb.append("\t").append("sum : ").append(priceCategory).append("\n");
            priceTotal += priceCategory;
        }
        return priceTotal;
    }

    //각 order에 해당하는 내용. 한줄씩 내용만들어 StringBuilder에 추가
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

    //주문정보-한줄씩 배열로 가져오기
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


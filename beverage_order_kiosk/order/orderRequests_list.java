package beverage_order_kiosk.order;

import java.util.ArrayList;
import java.util.List;

public class orderRequests_list {
    private static orderRequests_list orderRequests = null;
    private static List<orderRequests> orderinfo = null;

    private orderRequests_list(){   }

    public static orderRequests_list dfd(){
        if(orderRequests == null){
            orderRequests = new orderRequests_list();
        }
        return orderRequests;
    }

    public static List<orderRequests> get_orderInfo(){
        if(orderinfo == null){
            orderinfo = new ArrayList<>();
        }
        return orderinfo;
    }
}

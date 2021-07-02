package beverage_order_kiosk.customerOrder;

import java.util.ArrayList;
import java.util.List;

public class Order_specifications {
    private static Order_specifications orderSpec = null;
    private static List<Order_data> orderList = null;

    private Order_specifications(){	}

    public static Order_specifications get_orderSpec(){
        if(orderSpec == null){
        	orderSpec = new Order_specifications();
        }
        return orderSpec;
    }

    public static List<Order_data> get_orderList(){
        if(orderList == null){
        	orderList = new ArrayList<>();
        }
        return orderList;
    }

	public List<Order_data> add_orderInfo(String beverKind, String beverTemper, String beverShot, String beverSize, String beverWhere) {
		orderList = get_orderList();		
		
		Order_data orderData = new Order_data();
		orderData.setBeverKind(beverKind)
				 .setBever_iceHot(beverTemper)
				 .setBeverShot(beverShot)
				 .setBeverSize(beverSize)
				 .setBeverWhere(beverWhere);
		orderList.add(orderData);
		
		return orderList;
	}	
}

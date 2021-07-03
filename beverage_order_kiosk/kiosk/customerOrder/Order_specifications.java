package beverage_order_kiosk.kiosk.customerOrder;

import java.util.ArrayList;
import java.util.List;

public class Order_specifications {
    private static Order_specifications orderSpec = null;
    private static List<Orders> orderList = null;
    private static Orders order = null;

    private Order_specifications(){	}

    public static Order_specifications getInstance(){
        if(orderSpec == null){
        	orderSpec = new Order_specifications();
        }
        return orderSpec;
    }

    public static List<Orders> get_orderList(){
        if(orderList == null){
        	orderList = new ArrayList<>();
        }
        return orderList;
    }
    
    public static Orders get_orderData() {
    	if(order == null) {
    		order = new Orders();
    	}
    	return order;
    }
    
    /*-------------------------------------------------*/

	public List<Orders> add_orderInfo(Orders data) {
		orderList = get_orderList();		
		
		Orders orderData = new Orders();
		orderData.setBeverKind(data.getBeverKind())
				 .setBeverTemper(data.getBeverTemper())
				 .setBeverShot(data.getBeverShot())
				 .setBeverSize(data.getBeverSize())
				 .setBeverWhere(data.getBeverWhere());
		orderList.add(orderData);
		
		return orderList;
	}	
}

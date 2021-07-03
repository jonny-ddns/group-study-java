package beverage_order_kiosk.kiosk.customerOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderCollection {
    private static OrderCollection orderSpec = null;
    private static List<Orders> orderList = null;
    private static Orders order = null;

    private OrderCollection(){	}
	private void resetData(){
		orderList = null;
	}

    public static OrderCollection getInstance(){
        if(orderSpec == null){
        	orderSpec = new OrderCollection();
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

	public void reset_orderInfo() {
		resetData();
	}
}

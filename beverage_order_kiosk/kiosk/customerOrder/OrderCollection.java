package beverage_order_kiosk.kiosk.customerOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderCollection {
	/*
	 * singleton 으로 구성
	 * -OrderCollection(클래스)
	 * -orderList(List)
	 * -order(Orders)
	 */
    private static OrderCollection orderSpec = null;
    private static List<Orders> orderList = null;
    private static Orders order = null;
    
    private OrderCollection(){	}

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
    
	private void resetData(){
		orderList = null;
	}

    //List에 데이터 추가하기
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

	//List에 담긴 정보 초기화
	public void reset_orderInfo() {
		resetData();
	}
}

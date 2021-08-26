package beverage_order_kiosk_ver2.kiosk.data.orderInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderInfos {
    private static OrderInfos orderInfos = null;
    private static Collection<Order> orderCollection = null;
    private static Order order = null;

    private OrderInfos(){	}

    public static OrderInfos getInstance(){
        if(orderInfos == null){
        	orderInfos = new OrderInfos();
        }
        return orderInfos;
    }

    public static Collection<Order> getOrderCollection(){
        if(orderCollection == null){
			orderCollection = new ArrayList<>();
        }
        return orderCollection;
    }

    public static Order get_orderData() {
    	if(order == null) {
    		order = new Order();
    	}
    	return order;
    }

    //List에 데이터 추가하기
	public Collection<Order> add_orderInfo(Order data) {
		orderCollection = getOrderCollection();
		Order orderData = new Order();
		orderData.setBeverKind(data.getBeverKind())
				 .setBeverTemper(data.getBeverTemper())
				 .setBeverShot(data.getBeverShot())
				 .setBeverSize(data.getBeverSize())
				 .setBeverWhere(data.getBeverWhere());
		orderCollection.add(orderData);
		return orderCollection;
	}

	//List에 담긴 정보 초기화
	public void reset_orderInfo() { resetData(); }
	private void resetData(){ orderCollection.clear(); }
}

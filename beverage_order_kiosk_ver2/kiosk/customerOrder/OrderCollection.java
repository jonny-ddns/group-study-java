package beverage_order_kiosk_ver2.kiosk.customerOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderCollection {
    private static OrderCollection orderCollection = null;
    private static List<Order> orderList = null;
    private static Order order = null;

    private OrderCollection(){	}

    public static OrderCollection getInstance(){
        if(orderCollection == null){
        	orderCollection = new OrderCollection();
        }
        return orderCollection;
    }

    public static List<Order> get_orderList(){
        if(orderList == null){
        	orderList = new ArrayList<>();
        }
        return orderList;
    }

    public static Order get_orderData() {
    	if(order == null) {
    		order = new Order();
    	}
    	return order;
    }

    //List�� ������ �߰��ϱ�
	public List<Order> add_orderInfo(Order data) {
		orderList = get_orderList();
		Order orderData = new Order();
		orderData.setBeverKind(data.getBeverKind())
				 .setBeverTemper(data.getBeverTemper())
				 .setBeverShot(data.getBeverShot())
				 .setBeverSize(data.getBeverSize())
				 .setBeverWhere(data.getBeverWhere());
		orderList.add(orderData);
		return orderList;
	}

	//List�� ��� ���� �ʱ�ȭ
	public void reset_orderInfo() { resetData(); }
	private void resetData(){ orderList.clear(); }
}

package beverage_order_kiosk.operation;

import beverage_order_kiosk.customerOrder.Order_specifications;

public class Operation9_insertData {
	public void execute(String beverKind, String beverIceHot, String beverShot, String beverSize, String beverWhere) {
		Order_specifications orderSpec = Order_specifications.get_orderSpec();
		orderSpec.add_orderInfo(beverKind, beverIceHot, beverShot, beverSize, beverWhere);
	}
}

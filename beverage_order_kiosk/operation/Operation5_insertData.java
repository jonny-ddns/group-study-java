package beverage_order_kiosk.operation;

import beverage_order_kiosk.customerOrder.Order_specifications;

public class Operation5_insertData implements Operation{
	
    String beverKind;
    String beverTemper;
    String beverShot;
    String beverSize;
    String beverWhere;  
	
	public Operation5_insertData(String beverKind, String beverTemper, String beverShot, String beverSize, String beverWhere){
		this.beverKind = beverKind;
		this.beverTemper = beverTemper;
		this.beverShot = beverShot;
		this.beverSize = beverSize;
		this.beverWhere = beverWhere;
	}
	
	@Override
	public String execute() {
		Order_specifications spec = Order_specifications.get_orderSpec();
		spec.add_orderInfo(beverKind, beverTemper, beverShot, beverSize, beverWhere);
		return null;
	}
}

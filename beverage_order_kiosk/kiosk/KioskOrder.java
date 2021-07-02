package beverage_order_kiosk.kiosk;

import beverage_order_kiosk.menu_enums.Menu;
import beverage_order_kiosk.operation.Operation;
import beverage_order_kiosk.operation.Operation0_kind;
import beverage_order_kiosk.operation.Operation1_temper;
import beverage_order_kiosk.operation.Operation2_shot;
import beverage_order_kiosk.operation.Operation3_size;
import beverage_order_kiosk.operation.Operation4_where;
import beverage_order_kiosk.operation.Operation5_insertData;

public class KioskOrder {
    String[] ments = null;
    
    KioskOrder() {
    	System.out.println("ORDER START!\n");
        Menu beverage = new Menu();
        beverage.printMenu();
        start();
    }
    
    private void start() {
        Operation oper = null;
        boolean wantToCancel = false;
        
        String beverKind = "";
        String beverTemper = "";
        String beverShot = "";
        String beverSize = "";
        String beverWhere = "";       

        while (!wantToCancel) {
            for (int index=0; index<6; index ++) {
                switch (index) {
                    case 0:
                    {
                        System.out.println("swich - 0");
                        oper = new Operation0_kind();
                        beverKind = oper.execute();
                    }   
                        break;
                    case 1:
                    {
                        System.out.println("swich - 1");
                        oper = new Operation1_temper();
                        beverTemper = oper.execute();
                    }
                        break;
                    case 2:
                    {
                        System.out.println("swich - 2");
                        oper = new Operation2_shot();
                        beverShot = oper.execute();
                    }
                        break;
                    case 3:
                    {
                        System.out.println("swich - 3");
                        oper = new Operation3_size();
                        beverSize = oper.execute();
                    }
                        break;
                    case 4:
                    {
                        System.out.println("swich - 4");
                        oper = new Operation4_where();
                        beverWhere = oper.execute();
                    }
                        break;
                    case 5:
                    {
                        System.out.println("swich - 5");
                        oper = new Operation5_insertData(beverKind, beverTemper, beverShot, beverSize, beverWhere);
                    }
                        break; 
                    default:
                        System.out.println("swich - default");
                        break;
                }
                System.out.println("주문확인 : ");
            }
        }
        System.out.println("주문이 취소되었습니다. 다시 주문해주세요");
    }
//    private void exit() {
//    	System.out.println("exit()");
//        System.exit(0);
//    }
}
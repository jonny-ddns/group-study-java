package beverage_order_kiosk.kiosk;

import beverage_order_kiosk.operation.Operation;
import beverage_order_kiosk.operation.Operation1_kind;

import java.util.Scanner;

public class KioskOrder {

    String[] ments = null;
    public KioskOrder(){
        System.out.println("ORDER START!\n");
        Beverage beverage = new Beverage();
        beverage.printMenu();

        start();
    }

    private void start(){
        ments = Ment.getMents();
        Operation oper = null;
        String orderInfo = "";
        

        Scanner scan = new Scanner(System.in);

        boolean wantToCancel = false;

//        String beverKind;
//        String beverIceHot;
//        String beverShot;
//        String beverSize;
//        String beverTakeout;
//        String orderMore;
//        String orderCancel;

        try {
            while(!wantToCancel) {


                for(int i=0; i<6; i++){
                    int orderProcess = i;
                    System.out.println(ments[i]);
                    String orderReceived = scan.next().trim().toLowerCase();
                    if(orderReceived.equals("c")){
                        System.out.println("c를 눌렀네");
                        wantToCancel = true;
                        break;
                    } else{
                        System.out.println("--swich");
                        switch (orderProcess){
                            case 0:
                                System.out.println("swich - 0");
                                oper = new Operation1_kind();
                                oper.execute(orderReceived);

                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;


                            default:
                                break;
                        }


                        System.out.println("주문확인 : ");
                    }
                }
            }
        } catch(NullPointerException npe){
            npe.getMessage();
            npe.printStackTrace();
        } catch (NumberFormatException nfe){
            nfe.getMessage();
            nfe.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        System.out.println("주문이 취소되었습니다. 다시 주문해주세요");
    }
}
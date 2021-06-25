package beverage_order_kiosk.kiosk;

import java.util.Scanner;

import beverage_order_kiosk.operation.*;

public class KioskOrder {

    public KioskOrder(){
        System.out.println("ORDER START!\n");
        Beverage beverage = new Beverage();
        beverage.printMenu();
        start();
    }

    private void start(){
        Scanner scan = new Scanner(System.in);

        boolean wantToCancel = false;

        String beverKind;
        String beverIceHot;
        String beverShot;
        String beverSize;
        String beverTakeout;
        String orderMore;
        String orderCancel;


            try {
                while(!wantToCancel) {
                    System.out.print("\n음료를 선택해주세요 : ");
                    beverKind = scan.next().trim();

                    {
                        Operation operation = new Operation1_kind();
                        operation.execute(beverKind);
                    }

                    System.out.print("1.ice 2.hot 선택 (주문취소c) : ");
                    beverIceHot = scan.next().trim().toLowerCase();
                    if (beverIceHot.equals("c")) {
                        System.out.println("취소를 입력하셨네요");
                    } else {
                        {
                            Operation operation = new Operation2_iceHot();
                            operation.execute(beverIceHot);
                        }

                        System.out.print("1.1샷(+0원) 2.2샷(+500원) 선택 (주문취소c) : ");
                        beverShot = scan.next().trim();

                        {
                            Operation operation = new Operation3_shot();
                            operation.execute(beverShot);
                        }

                        System.out.print("1.S(+0원) 2.M(+500원) 3.L(+1000원) 선택 (주문취소c) : ");
                        beverSize = scan.next().trim();
                        {
                            Operation operation = new Operation4_size();
                            operation.execute(beverSize);
                        }

                        System.out.print("1.매장이용(+500원) 2.테이크아웃(+0원) 선택 (주문취소c) : ");
                        beverTakeout = scan.next().trim();
                        {
                            Operation operation = new Operation5_takeout();
                            operation.execute(beverTakeout);
                        }

                        System.out.print("추가주문 하시겠습니까?(y/n) : ");
                        orderMore = scan.next().trim();


                        System.out.print("주문을 취소하시겠습니까?(y/n) : ");
                        orderCancel = scan.next().trim();
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
}

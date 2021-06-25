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
                    System.out.print("\n���Ḧ �������ּ��� : ");
                    beverKind = scan.next().trim();

                    {
                        Operation operation = new Operation1_kind();
                        operation.execute(beverKind);
                    }

                    System.out.print("1.ice 2.hot ���� (�ֹ����c) : ");
                    beverIceHot = scan.next().trim().toLowerCase();
                    if (beverIceHot.equals("c")) {
                        System.out.println("��Ҹ� �Է��ϼ̳׿�");
                    } else {
                        {
                            Operation operation = new Operation2_iceHot();
                            operation.execute(beverIceHot);
                        }

                        System.out.print("1.1��(+0��) 2.2��(+500��) ���� (�ֹ����c) : ");
                        beverShot = scan.next().trim();

                        {
                            Operation operation = new Operation3_shot();
                            operation.execute(beverShot);
                        }

                        System.out.print("1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ����c) : ");
                        beverSize = scan.next().trim();
                        {
                            Operation operation = new Operation4_size();
                            operation.execute(beverSize);
                        }

                        System.out.print("1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ����c) : ");
                        beverTakeout = scan.next().trim();
                        {
                            Operation operation = new Operation5_takeout();
                            operation.execute(beverTakeout);
                        }

                        System.out.print("�߰��ֹ� �Ͻðڽ��ϱ�?(y/n) : ");
                        orderMore = scan.next().trim();


                        System.out.print("�ֹ��� ����Ͻðڽ��ϱ�?(y/n) : ");
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
            System.out.println("�ֹ��� ��ҵǾ����ϴ�. �ٽ� �ֹ����ּ���");
        }
    }
}

package beverage_order_kiosk.kiosk;

public class Beverage {
    private String beverage01 = "�Ƹ޸�ī��";
    private String beverage02 = "�ٴҶ��";
    private String beverage03 = "�����̵�";
    private String beverage04 = "�ڸ����̵�";
    private String beverage05 = "�����ֽ�";
    private String beverage06 = "�丶���ֽ�";

    private int price01 = 1000;
    private int price02 = 2500;
    private int price03 = 3000;
    private int price04 = 3000;
    private int price05 = 4000;
    private int price06 = 4000;

    private String menuElement(String beverage, int price){
        String menuElement = beverage+ " " + String.valueOf(price)+"��";
        return menuElement;
    }

    public void printMenu() {
        System.out.println("�޴�");
        System.out.println(" 1."+ menuElement(beverage01, price01));
        System.out.println(" 2."+ menuElement(beverage02, price02));
        System.out.println(" 3."+ menuElement(beverage03, price03));
        System.out.println(" 4."+ menuElement(beverage04, price04));
        System.out.println(" 5."+ menuElement(beverage05, price05));
        System.out.println(" 6."+ menuElement(beverage06, price06));
        System.out.println("---------------------");
    }
}

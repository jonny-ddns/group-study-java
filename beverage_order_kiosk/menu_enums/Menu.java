package beverage_order_kiosk.menu_enums;

public class Menu {
    private String beverage01 = ����.�Ƹ޸�ī��.name();
    private String beverage02 = ����.�ٴҶ��.name();
    private String beverage03 = ����.�����̵�.name();
    private String beverage04 = ����.�ڸ����̵�.name();
    private String beverage05 = ����.�����ֽ�.name();
    private String beverage06 = ����.�丶���ֽ�.name();

    private int price01 = Pricing.getPrice01();
    private int price02 = Pricing.getPrice02();
    private int price03 = Pricing.getPrice03();
    private int price04 = Pricing.getPrice04();
    private int price05 = Pricing.getPrice05();
    private int price06 = Pricing.getPrice06();

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

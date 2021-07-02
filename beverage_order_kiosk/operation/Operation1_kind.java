package beverage_order_kiosk.operation;

import beverage_order_kiosk.customerOrder.Order_specifications;

public class Operation1_kind implements Operation {
    @Override
    public void execute(String request) {
    	System.out.println("Operation1_kind");
        System.out.println("�Է°� : "+ request);
        
        Order_specifications orderSpec = Order_specifications.get_orderSpec();
       
        boolean isNumber = isNumber(request);
        if(isNumber){
            int a = Integer.parseInt(request);         
            
            switch(a) {
            
            
            case 1:
            	System.out.println("request : 1");
            	System.out.println("�Ƹ޸�ī��");            	
            	break;
            case 2:
            	System.out.println("request : 2");
            	System.out.println("�ٴҶ��");
            	break;
            case 3:
            	System.out.println("request : 3");
            	System.out.println("�����̵�");
            	break;
            case 4:
            	System.out.println("request : 4");
            	System.out.println("�ڸ����̵�");
            	break;
            case 5:
            	System.out.println("request : 5");
            	System.out.println("�����ֽ�");
            	break;
            case 6:
            	System.out.println("request : 6");
            	System.out.println("�丶���ֽ�");
            	break;
            default:
            	System.out.println("request : ��ȣ�� �ʰ��Ͽ���. �׷� �޴��� ����");
            	break;
            	
            }

        } else {
        	System.out.println("���ڸ� �Է¹ٶ��ϴ�");
        }
    }
    
    boolean isNumber(String request){
        boolean isNum = false;
        try{
          Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException nfe){
            nfe.getMessage();
        } catch (Exception e){
            e.getMessage();
        }
        return isNum;
    }
}

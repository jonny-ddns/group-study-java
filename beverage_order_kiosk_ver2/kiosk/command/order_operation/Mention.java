package beverage_order_kiosk_ver2.kiosk.command.order_operation;

public class Mention {
	public String getMent0_choose() { return "\n����(��ȣ)�� �������ּ��� (�ֹ���� c): "; }
	public String getMent1_temper() { return "\n1.ice 2.hot ���� (�ֹ���� c): "; }
	public String getMent2_shot() { return "\n1.1��(+0��) 2.2��(+500��) ���� (�ֹ���� c): "; }
	public String getMent3_size() { return "\n1.S(+0��) 2.M(+500��) 3.L(+1000��) ���� (�ֹ���� c): "; }
	public String getMent4_where() { return "\n1.�����̿�(+500��) 2.����ũ�ƿ�(+0��) ���� (�ֹ���� c): "; }
	public String getMent5_orderMore() { return "\n�߰��ֹ� �Ͻðڽ��ϱ�? (y/n): "; }
	public String getMent6_cancel() { return "\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): "; }
	public String getMent7_orderAgain(){ return "�ֹ��� ��ҵǾ����ϴ�. �ٽ� �Է����ּ���"; }
	public String getMent8_numberOnly() { return "���ڸ� �Է¹ٶ��ϴ�"; }
	public String getMent9_yn_only() { return "y Ȥ�� n�� �Է¹ٶ��ϴ�"; }
}
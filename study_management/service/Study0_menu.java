package study_management.service;

public class Study0_menu implements StudyManage {
	@Override
	public void manage() {	
		StringBuilder sb = new StringBuilder();		
		sb.append("\n==================="+ "\n");
		sb.append("�޴�(0)"+ "\n");
		sb.append("  1. ���͵� ����\n");
		sb.append("  2. ���� �Է�\n");
		sb.append("  3. ���� ����\n");
		sb.append("  4. ���͵� Ż��\n");
		sb.append("  5. ���� ��Ȳ\n");
		sb.append("  6. ���͵� ��������\n");
		sb.append("  7. ���� ����\n");		
		sb.append("===================\n");
		System.out.print(sb.toString());
		sb.setLength(0);		
	}
}

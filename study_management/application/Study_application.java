package study_management.application;

import java.util.Scanner;
import study_management.service.StudyManage;
import study_management.service.Study0_menu;
import study_management.service.Study1_join;
import study_management.service.Study2_insertInfo;
import study_management.service.Study3_editInfo;
import study_management.service.Study4_quit;
import study_management.service.Study5_fineStatus;
import study_management.service.Study6_overView;

public class Study_application {
		Study_application() {
		System.out.println("STUDY MANAGEMENT START!");
		
		StudyManage studymanage = new Study0_menu();
		studymanage.manage();

		appStart();
	}
	
	private void appStart() {
		boolean programRun	= true;		//flag ����
		Scanner scan		= new Scanner(System.in);

		while(programRun) {					
			please_enterService();			
			
			//�Էµ� ���� 0~7�� ���ϴ� �������� Ȯ���ϴ� �ڵ�
			//�Է� ������ ���޽��� ��µǰ� �ٽ� �ݺ�
			int num = 8;
			try {
				num = Integer.parseInt(scan.next());
				if(num<0 || 7<num) {
					num = 8;
				}
			} catch (Exception e) { }				
			
			/*-----------------------------------------------------*/
			//Java - Enum�� ����Ͽ� ���ŵ� ���� switch ���ڰ����� �Ҵ�ǵ��� ����
			switch (App_button.values()[num]) {
			case MENU:			//�޴� ���
			{
				StudyManage studymanage = new Study0_menu();
				studymanage.manage();
			}					
				break;
				
			case JOIN:			//���͵� ����					
			{
					StudyManage studymanage = new Study1_join();
					studymanage.manage();
			}
				break;
				
			case INSERT_INFO: 	//���� �Է�
			{
					StudyManage studymanage = new Study2_insertInfo();
					studymanage.manage();
			}
				break;
				
			case EDIT_INFO:		//���� ����
			{
					StudyManage studymanage = new Study3_editInfo();
					studymanage.manage();
			}				
				break;
			
			case QUIT:			//���͵� Ż��
			{
				StudyManage studymanage = new Study4_quit();
				studymanage.manage();
			}				
				break;
			
			case FINE_STATUS:	//���� ��Ȳ
			{
				StudyManage studymanage = new Study5_fineStatus();
				studymanage.manage();
			}
				break;

			case OVER_VIEW:		//���͵� ����
			{
				StudyManage studymanage = new Study6_overView();
				studymanage.manage();
			}
				break;	
				
			case PROGRAM_FINISH: //���α׷� ����
				System.out.println("STUDY MANAGEMENT FINISH!");
				programRun = false;
				System.exit(0);		
				break;
				
			case ERROR:	//���� ����ڵ�
				System.out.println("[0���� 7������ ���ڸ� �Է����ּ���]");
			}			
		}
		scan.close();
	}
			
	private void please_enterService() {
		System.out.print("\n���� �Է�>>");
	}
}
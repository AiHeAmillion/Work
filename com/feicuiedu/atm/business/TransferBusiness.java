package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TransferBusiness{			//ת��ҵ�� 
	Scanner sc = new Scanner(System.in);
	public void transfer(User user,User[] account){			//ת�˷���	����Ϊuser���һ������													//ת�˷���

		System.out.println("*****ת��ҵ��*****");
		System.out.println("������Է����п��ţ�");		
		String number = sc.nextLine();				//�Է�����
		System.out.println("������ת�˽�");	
		double temp = Double.valueOf(sc.nextLine());		//ת�˵Ľ��

		int idx = -5;
		Login lin = new Login();
		idx = lin.verifyExist(number,account);	//������֤�˺Ŵ��ڷ���
		if (idx==-1) {		//�ҵ�ת���˻��������е��±�
			transfer(user,account);		
		}else{

		}

		if (user.getBalance()<temp) {					//�������Ƿ��㹻ת��
			System.out.println("�������������룡");
			transfer(user,account);
		}else{

		}
		
		aa:
		do{
			System.out.println("     1.ȷ��");
			System.out.println("     2.��������");
			System.out.println("     3.���ز˵�");
			int temp2 = Integer.valueOf(sc.nextLine());
			if (temp2 == 1) {				// 1 ȷ��
				if ( !(number.equals(account[idx].getNumber())) ) {		//�ж����뿨���Ƿ���ȷ
					System.out.println("*****ת��ҵ�� - ��ʾ�Է���Ϣ*****");
					System.out.println("�����˺��������������룡");
					transfer(user,account);													//����ȷ����ת�˽���
				}

					showInformation(user,account[idx],account,temp);		//������ʾ�Է���Ϣ����
	
			}else if (temp2 == 2) {			// 2 ��������
				transfer(user,account);				//���µ���ת�˽���
			}else if (temp2 == 3) {
				Ui ui = new Ui();
				ui.menu(user,account);				// 3 ���ز˵�
			}else{
				System.out.println("����������������룡");
				continue aa;
			}
		}
		while(true);
	}	

	public void	showInformation(User user,User user2,User[] account,double temp){	
	//��ʾ�Է�������Ϣ���� ����Ϊuser������������ 1Ϊ�������� 2Ϊת�˶��� 3���˺��������� 4��ת�˽��
		
		aa:
		do{	
			System.out.println("�Է����ţ�"+user2.getNumber());
			System.out.println("�Է�������"+user2.getName());
			System.out.println("ת�˽�"+temp);	
			System.out.println("     1.ȷ��ת��");
			System.out.println("     2.������һ��");
			System.out.println("     3.�˿�");
			int temp5 = Integer.valueOf(sc.nextLine());
			if (temp5 == 1) {								// 1ȷ��ת��
				user.setBalance(user.getBalance()-temp);	//1�����Ϊ���-ת�˽��
				user2.setBalance(user2.getBalance()+temp);	//ת���˻���Ǯ
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");	//ʱ���ʽ
				String str = sdf.format(new Date());	//��ȡ��ǰʱ�䰴��ʽ���
				DealFlow df = new DealFlow();
				String s_temp = Double.toString(temp);
				df.buildFlow(user,"ת��ҵ��"+" "+"��"+user2.getNumber()+"ת"+s_temp+"Ԫ"+" "+str);	//���ô�����ˮ  �������ˮ����
				
				Ui ui = new Ui();
				ui.succed(user,account);	//��ת�����ɹ�����
			}else if (temp5 == 2) {		// 2������һ��
				transfer(user,account);		//����ת�˽���
			}else if (temp5 == 3) {		// 3���ز˵�
				Ui ui = new Ui();
				ui.menu(user,account);	//��ת���˵�����
			}else{
				System.out.println("����������������룡");	//���� 1 2 3֮��Ķ���������ʾ����
				showInformation(user,user2,account,temp);
			}
		}
		while(true);
	}

}
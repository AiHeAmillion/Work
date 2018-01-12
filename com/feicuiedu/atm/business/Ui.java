package feicuiedu.atm.business;
import feicuiedu.atm.control.*;
import java.util.Scanner;
public class Ui{
	Scanner sc = new Scanner(System.in);

	public void menu(User user,User[] account){					//�˵����� ����Ϊ����������user����
		System.out.println("*****************************");
		System.out.println("�˵���ѡ�����ҵ��");
		System.out.println("     1.��ѯ");
		System.out.println("     2.ת��");
		System.out.println("     3.���");
		System.out.println("     4.ȡ��");
		System.out.println("     5.��ˮ");
		System.out.println("     6.�˿�");
		System.out.println("*****************************");
		int input = Integer.valueOf(sc.nextLine());
		if (input == 1) {			//��ѯ
			Query query = new Query();
			query.showUserInfo(user);
			menu(user,account);
		}else if (input == 2) {		//ת��
			TransferBusiness tb = new TransferBusiness();
			tb.transfer(user,account);
			//menu(user,account);
		}else if (input == 3) {		//���
			SaveMoney sMoney = new SaveMoney();
			sMoney.save(user,account);
			//menu(user,account);
		}else if (input == 4) {		//ȡ��
			DrawMoney dMoney = new DrawMoney();
			dMoney.draw(user,account);
			//menu(user,account);
		}else if (input == 5) {		//��ˮ
			DealFlow df = new DealFlow();
			df.flow(user);
			menu(user,account);	
		}else if (input == 6) {		//�˿�
			UserControl uc = new UserControl();
			user = uc.loginControl(account);
			menu(user,account);
		}else {
			System.out.println("��������������룡");
			menu(user,account);
		}
		
	}

	public void option(){		//ѡ�����
		System.out.println("     1.ȷ��");
		System.out.println("     2.��������");
		System.out.println("     3.���ز˵�");
	}
	
	public void succed(User user,User[] account){		//�����ɹ�����															//�����ɹ�����
		System.out.println("  �����ɹ�������");		
		menu(user,account);//�����ɹ��Զ����ز˵�										
	}
}
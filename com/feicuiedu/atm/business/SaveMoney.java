package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SaveMoney{		//���ҵ��
	public void save(User user,User[] account){		//���� �޷���ֵ ����ΪҪ������User����
		System.out.println("*****���ҵ��*****");
		System.out.println("���������");	
		Scanner sc = new Scanner(System.in);
		double input = Double.valueOf(sc.nextLine()); //��������Ĵ�Ǯ��
		
		aa:
		do{		//do whileѭ��+��ǩ ���� ���� 1 2 3֮����������ʱ��������
			System.out.println("     1.ȷ��");
			System.out.println("     2.��������");
			System.out.println("     3.���ز˵�");
			int temp = Integer.valueOf(sc.nextLine());
			if (temp == 1) {
				user.setBalance(user.getBalance()+input);	//���ΪǮ�� + ��Ǯ��

				String s_temp = Double.toString(input);	//��ȡǮ��ת���ַ���
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");	//ʱ���ʽ
				String str = sdf.format(new Date());	//��ȡ��ǰʱ�䰴��ʽ���
				DealFlow df = new DealFlow();
				df.buildFlow(user,"���ҵ��"+" "+"���"+s_temp+"Ԫ"+" "+str);	//���ô�����ˮ  �������ˮ����

				Ui ui = new Ui();
				ui.succed(user,account);
			}else if (temp == 2) {
				save(user,account);
			}else if (temp == 3) {
				break;
			}else{
					System.out.println("����������������룡");
					continue aa;
			}
		}
		while(true);
	}
}
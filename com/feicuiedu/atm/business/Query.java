package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Query{		//��ѯҵ��
	public int showUserInfo(User user){   			// ��ʾ�û���Ϣ ����ֵΪ�û��ڴ�����ֵ ����Ϊuser���һ������ 
		System.out.println("�˻�����:"+user.getName());
		System.out.println("�˻����:"+user.getBalance());
		System.out.println("1.������һ��");
		//Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");	//ʱ���ʽ
		String str = sdf.format(new Date());	//��ȡ��ǰʱ�䰴��ʽ���
		DealFlow df = new DealFlow();
		df.buildFlow(user,"��ѯҵ��"+" "+str);	//���ô�����ˮ  �������ˮ����

		Scanner sc = new Scanner(System.in);
		int input = Integer.valueOf(sc.nextLine());
		if (input !=1 ) {	//�ж�������ǲ��� 1
			System.out.println("���������������");
			showUserInfo(user);
		}
		return input;
	}
}
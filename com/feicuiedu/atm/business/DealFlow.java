package feicuiedu.atm.business;	//������ˮ����ҵ���
import java.util.Scanner;
public class DealFlow{	//������ˮ
	Scanner sc = new Scanner(System.in);
	
	public void buildFlow(User user,String str){	//������ˮ
		user.setFlow(user.getFlow().append(str).append("\n"));		//stringBuffer ������\r
	}

	public int flow(User user){	//��ʾ��ˮ
		System.out.println("������ˮ");
		System.out.println(user.getFlow());
		System.out.println("1.������һ��");
		Scanner sc = new Scanner(System.in);
		int input = Integer.valueOf(sc.nextLine());
		if (input !=1 ) {	//�ж�������ǲ��� 1
			System.out.println("���������������");
			flow(user);
		}
		return input;
	}


}
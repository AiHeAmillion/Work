package feicuiedu.atm.business;
import java.util.regex.*;
import java.util.Scanner;
public class Login{
	Scanner sc = new Scanner(System.in);
/*	public void login(User[] account){	//��¼���淽�� ����Ϊuser���user���� ��ʱuser����ΪҪ������    ���� ��η�������ֵ
		
		System.out.println("*****************************");
		System.out.println("�����˺ţ�");
		String number = sc.nextLine();		//���������˺�
		

		System.out.println("�������룺");
		String password = sc.nextLine();	//������������
		verifyCard(password,account,idx);	//������֤�˺ŵķ���  ����������˺š�����
	}	*/

	public String verifyLength(User[] account){		//��֤�˺ų���  ����Ϊ�˺���������
		System.out.println("*****************************");
		System.out.println("�����˺ţ�");
		String number = sc.nextLine();		//���������˺�
		
		Pattern pattern = Pattern.compile("[0-9]{3}");		//������ʽ  0-9������� 3λ
		Matcher matcher = pattern.matcher(number);
		if (matcher.matches() == false) {	//��֤�˺ų���
			System.out.println("�˺Ŵ�����������");
			//verifyLength(account);
			return "-1";
		}else{
			//verifyExist(number,account);	//������֤�˺Ŵ��ڷ���
			return number;
		}
	}
	
	public int verifyExist(String number,User[] account){	//��֤�˺Ŵ��� ���� ������˺� �� �˺���������
		
		boolean bln = false;
		int idx = -1; 
		
		for (int i = 0 ; i<account.length ; i++) {	//�����˺�����
			bln = number.equals(account[i].getNumber());//�Ƚ������˺ź��˺������������ÿ���˺ţ�substring��ȡ��0-12���ַ���
			if (bln) {	//blnΪtrueʱ �ı�idx��ֵ
				idx = i;	//��ȷ�˺����˺������е��±�
			}
		}
		
		if (idx == -1) {	//���idx��ֵһֱΪ -1 ��ô�˺Ų�����
			System.out.println("�˺Ų����ڣ����������룡");
			return -1; //�˺Ų����ڷ���-1
		}else{
			return idx;  //�˺Ŵ��ڷ����±�
		}
	}
	
	public boolean verifyCard(User[] account,int idx){		//��֤����  ����Ϊ�˺�����������Ѿ���֤�����˺��������е��±�
		
		System.out.println("�������룺");
		String password = sc.nextLine();	//������������
		
		boolean temp = password.equals(account[idx].getPassword());  // ��password �Ƚ��˺�����������±�Ϊidx���������ֵ
		
		if(temp == false){		//tempΪfalse �������
			System.out.println("���������������");
			return false;		//������󷵻�false
		}else{
			return true;	//������ȷ����true
		}
		
	}
	
}
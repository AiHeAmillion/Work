package feicuiedu.atm.control;
import 	feicuiedu.atm.business.*;
public class UserControl{ 	//�û�������  �����û��˺� �������鴴�� ��¼���̿���
	
	public User[] buildArray(){

		User[] account;	//����һ��User������洢user����
		account = new User[2];	//���鶯̬��ʼ��
		
		User user = new User();		//1 �û�
		User user2 = new User();	//2 �û�

		user.setNumber("111");	//���� ����
		user.setName("�����");
		user.setBalance(1000);
		user.setPassword("123456");
		
		user2.setNumber("222");	//���� ����
		user2.setName("�� *");
		user2.setBalance(0);
		user2.setPassword("654321");
		
		account[0] = user;
		account[1] = user2;

		return account;
		/*loginControl(account);	//���õ�¼���̿���*/
	}

	public User loginControl(User[] account){	//��¼���̿���
		Login lin = new Login();
		boolean temp = false;
		int idx = -5;

		aa:
		do{	
			String number = lin.verifyLength(account); //����Login��¼��֤�˺ų��ȷ���  �������� ����һ����ǰ������н������Ĳ���
			
			if (number.equals("-1")) {		//���յķ���ֵΪ -1 ʱ�˺ų��Ȳ���
				continue aa;	//�˺ų��Ȳ���  ��ת�� aa: ������
			}else {
				temp = true;		//�˺ų�����ȷ�ı�temp��ֵΪtrue
			}

			if (temp == true) {
				idx=lin.verifyExist(number,account);
				if (idx == -1) {		//���idx���յ���֤�˺Ŵ��ڵķ����ķ���ֵ���˺�����������±꣩Ϊ-1ʱ���˺Ų����ڣ���������ѭ��
					temp = false;		//�˺Ų����� ���뻹�Ǵ��� tempֵ��Ϊfalse
					continue aa;	//�˺ų��Ȳ���  ��ת�� aa: ������
				}else{
					temp = true;		//�˺Ŵ���temp��ֵ��Ϊtrue
				}
			}else{

			}

			if (temp == true) {
				temp = lin.verifyCard(account,idx); //temp������֤���뷽���ķ���ֵ falseʱ���� trueʱ��ȷ
			}
			
		}while(temp == false);		//temp = false ִ���´�ѭ�� ��������
		return account[idx];	//����idx�±�Ķ���  ���������Ĳ�������
	}
}
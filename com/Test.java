import feicuiedu.atm.business.*;
import feicuiedu.atm.control.*;
import java.util.Scanner;
public class Test{
	public static void main(String[] args) {
		
		UserControl uc = new UserControl();	//�½���һ���û����̿��ƶ���
		User[] account;	//�½����û�����
		account = uc.buildArray();	//���� �������鷽��
		User user = uc.loginControl(account);
		Ui ui = new Ui();	//�½�һ���������
		ui.menu(user,account);	//���ò˵�����
	}
}
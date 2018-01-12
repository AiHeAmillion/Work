import feicuiedu.atm.business.*;
import feicuiedu.atm.control.*;
import java.util.Scanner;
public class Test{
	public static void main(String[] args) {
		
		UserControl uc = new UserControl();	//新建建一个用户流程控制对象
		User[] account;	//新建建用户数组
		account = uc.buildArray();	//调用 创建数组方法
		User user = uc.loginControl(account);
		Ui ui = new Ui();	//新建一个界面对象
		ui.menu(user,account);	//调用菜单方法
	}
}
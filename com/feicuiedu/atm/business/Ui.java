package feicuiedu.atm.business;
import feicuiedu.atm.control.*;
import java.util.Scanner;
public class Ui{
	Scanner sc = new Scanner(System.in);

	public void menu(User user,User[] account){					//菜单界面 参数为传入两个个user对象
		System.out.println("*****************************");
		System.out.println("菜单—选择办理业务");
		System.out.println("     1.查询");
		System.out.println("     2.转账");
		System.out.println("     3.存款");
		System.out.println("     4.取款");
		System.out.println("     5.流水");
		System.out.println("     6.退卡");
		System.out.println("*****************************");
		int input = Integer.valueOf(sc.nextLine());
		if (input == 1) {			//查询
			Query query = new Query();
			query.showUserInfo(user);
			menu(user,account);
		}else if (input == 2) {		//转账
			TransferBusiness tb = new TransferBusiness();
			tb.transfer(user,account);
			//menu(user,account);
		}else if (input == 3) {		//存款
			SaveMoney sMoney = new SaveMoney();
			sMoney.save(user,account);
			//menu(user,account);
		}else if (input == 4) {		//取款
			DrawMoney dMoney = new DrawMoney();
			dMoney.draw(user,account);
			//menu(user,account);
		}else if (input == 5) {		//流水
			DealFlow df = new DealFlow();
			df.flow(user);
			menu(user,account);	
		}else if (input == 6) {		//退卡
			UserControl uc = new UserControl();
			user = uc.loginControl(account);
			menu(user,account);
		}else {
			System.out.println("输入错误，重新输入！");
			menu(user,account);
		}
		
	}

	public void option(){		//选项界面
		System.out.println("     1.确认");
		System.out.println("     2.重新输入");
		System.out.println("     3.返回菜单");
	}
	
	public void succed(User user,User[] account){		//操作成功界面															//操作成功界面
		System.out.println("  操作成功！！！");		
		menu(user,account);//操作成功自动返回菜单										
	}
}
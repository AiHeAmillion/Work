package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TransferBusiness{			//转账业务 
	Scanner sc = new Scanner(System.in);
	public void transfer(User user,User[] account){			//转账方法	参数为user类的一个对象													//转账方法

		System.out.println("*****转账业务*****");
		System.out.println("请输入对方银行卡号：");		
		String number = sc.nextLine();				//对方卡号
		System.out.println("请输入转账金额：");	
		double temp = Double.valueOf(sc.nextLine());		//转账的金额

		int idx = -5;
		Login lin = new Login();
		idx = lin.verifyExist(number,account);	//调用验证账号存在方法
		if (idx==-1) {		//找到转账账户在数组中的下标
			transfer(user,account);		
		}else{

		}

		if (user.getBalance()<temp) {					//检测余额是否足够转账
			System.out.println("余额不足请重新输入！");
			transfer(user,account);
		}else{

		}
		
		aa:
		do{
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp2 = Integer.valueOf(sc.nextLine());
			if (temp2 == 1) {				// 1 确认
				if ( !(number.equals(account[idx].getNumber())) ) {		//判断输入卡号是否正确
					System.out.println("*****转账业务 - 显示对方信息*****");
					System.out.println("输入账号有误请重新输入！");
					transfer(user,account);													//不正确返回转账界面
				}

					showInformation(user,account[idx],account,temp);		//弹出显示对方信息界面
	
			}else if (temp2 == 2) {			// 2 重新输入
				transfer(user,account);				//重新调用转账界面
			}else if (temp2 == 3) {
				Ui ui = new Ui();
				ui.menu(user,account);				// 3 返回菜单
			}else{
				System.out.println("输入错误，请重新输入！");
				continue aa;
			}
		}
		while(true);
	}	

	public void	showInformation(User user,User user2,User[] account,double temp){	
	//显示对方卡号信息方法 参数为user类两个个对象 1为操作对象 2为转账对象 3是账号密码数组 4是转账金额
		
		aa:
		do{	
			System.out.println("对方卡号："+user2.getNumber());
			System.out.println("对方姓名："+user2.getName());
			System.out.println("转账金额："+temp);	
			System.out.println("     1.确认转账");
			System.out.println("     2.返回上一级");
			System.out.println("     3.退卡");
			int temp5 = Integer.valueOf(sc.nextLine());
			if (temp5 == 1) {								// 1确认转账
				user.setBalance(user.getBalance()-temp);	//1卡余额为余额-转账金额
				user2.setBalance(user2.getBalance()+temp);	//转账账户加钱
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				DealFlow df = new DealFlow();
				String s_temp = Double.toString(temp);
				df.buildFlow(user,"转账业务"+" "+"向"+user2.getNumber()+"转"+s_temp+"元"+" "+str);	//调用创建流水  把这次流水存入
				
				Ui ui = new Ui();
				ui.succed(user,account);	//跳转操作成功界面
			}else if (temp5 == 2) {		// 2返回上一级
				transfer(user,account);		//返回转账界面
			}else if (temp5 == 3) {		// 3返回菜单
				Ui ui = new Ui();
				ui.menu(user,account);	//跳转到菜单界面
			}else{
				System.out.println("输入错误，请重新输入！");	//输入 1 2 3之外的东西还在显示界面
				showInformation(user,user2,account,temp);
			}
		}
		while(true);
	}

}
package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DrawMoney{  //取钱业务
	Scanner sc = new Scanner(System.in);
	public void draw(User user,User[] account){		//取钱方法 返回值 参数为 User类的一个user对象
		System.out.println("*****取款业务*****");
		System.out.println("请输入取款金额：");	
		double input = Double.valueOf(sc.nextLine()); //接受输入的取钱数

		if (user.getBalance()<input) {		//判断余额是否足够 不足的话调用取钱方法重新输入
			System.out.println("余额不足！");
			Ui ui = new Ui();
			ui.menu(user,account);
		}

		aa:
		do{			//do while循环+标签 处理 输入 1 2 3之外其他东西时重新输入
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp = Integer.valueOf(sc.nextLine());
			if (temp == 1) {
				user.setBalance(user.getBalance()-input);	// 余额为 钱数 - 取钱数

				String s_temp = Double.toString(input);	//把取钱数转成字符串
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				DealFlow df = new DealFlow();
				df.buildFlow(user,"存款业务"+" "+"取款款"+s_temp+"元"+" "+str);	//调用创建流水  把这次流水存入

				Ui ui = new Ui();
				ui.succed(user,account);
			}else if (temp == 2) {
				draw(user,account);
			}else if (temp == 3) {
				break;
			}else{
				System.out.println("输入错误，请重新输入！");
				continue aa;
			}
		}
		while(true);
	}
}
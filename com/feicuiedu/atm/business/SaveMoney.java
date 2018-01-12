package feicuiedu.atm.business;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SaveMoney{		//存款业务
	public void save(User user,User[] account){		//存款方法 无返回值 参数为要操作的User对象
		System.out.println("*****存款业务*****");
		System.out.println("请输入存款金额：");	
		Scanner sc = new Scanner(System.in);
		double input = Double.valueOf(sc.nextLine()); //接受输入的存钱数
		
		aa:
		do{		//do while循环+标签 处理 输入 1 2 3之外其他东西时重新输入
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp = Integer.valueOf(sc.nextLine());
			if (temp == 1) {
				user.setBalance(user.getBalance()+input);	//余额为钱数 + 存钱数

				String s_temp = Double.toString(input);	//把取钱数转成字符串
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				DealFlow df = new DealFlow();
				df.buildFlow(user,"存款业务"+" "+"存款"+s_temp+"元"+" "+str);	//调用创建流水  把这次流水存入

				Ui ui = new Ui();
				ui.succed(user,account);
			}else if (temp == 2) {
				save(user,account);
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
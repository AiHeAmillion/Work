package feicuiedu.atm.business;	//交易流水打在业务包
import java.util.Scanner;
public class DealFlow{	//交易流水
	Scanner sc = new Scanner(System.in);
	
	public void buildFlow(User user,String str){	//创建流水
		user.setFlow(user.getFlow().append(str).append("\n"));		//stringBuffer 换行用\r
	}

	public int flow(User user){	//显示流水
		System.out.println("交易流水");
		System.out.println(user.getFlow());
		System.out.println("1.返回上一级");
		Scanner sc = new Scanner(System.in);
		int input = Integer.valueOf(sc.nextLine());
		if (input !=1 ) {	//判断输入的是不是 1
			System.out.println("输入错误！重新输入");
			flow(user);
		}
		return input;
	}


}
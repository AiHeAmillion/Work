package feicuiedu.atm.business;
import java.util.regex.*;
import java.util.Scanner;
public class Login{
	Scanner sc = new Scanner(System.in);
/*	public void login(User[] account){	//登录界面方法 参数为user类的user对象 此时user对象为要操作的    这里 如何返回两个值
		
		System.out.println("*****************************");
		System.out.println("输入账号：");
		String number = sc.nextLine();		//接受输入账号
		

		System.out.println("输入密码：");
		String password = sc.nextLine();	//接受输入密码
		verifyCard(password,account,idx);	//调用验证账号的方法  传入输入的账号、密码
	}	*/

	public String verifyLength(User[] account){		//验证账号长度  参数为账号密码数组
		System.out.println("*****************************");
		System.out.println("输入账号：");
		String number = sc.nextLine();		//接受输入账号
		
		Pattern pattern = Pattern.compile("[0-9]{3}");		//正则表达式  0-9数字组成 3位
		Matcher matcher = pattern.matcher(number);
		if (matcher.matches() == false) {	//验证账号长度
			System.out.println("账号错误！重新输入");
			//verifyLength(account);
			return "-1";
		}else{
			//verifyExist(number,account);	//调用验证账号存在方法
			return number;
		}
	}
	
	public int verifyExist(String number,User[] account){	//验证账号存在 参数 输入的账号 和 账号密码数组
		
		boolean bln = false;
		int idx = -1; 
		
		for (int i = 0 ; i<account.length ; i++) {	//遍历账号数组
			bln = number.equals(account[i].getNumber());//比较输入账号和账号密码数组里的每个账号（substring截取第0-12个字符）
			if (bln) {	//bln为true时 改变idx的值
				idx = i;	//正确账号在账号数组中的下标
			}
		}
		
		if (idx == -1) {	//如果idx的值一直为 -1 那么账号不存在
			System.out.println("账号不存在，请重新输入！");
			return -1; //账号不存在返回-1
		}else{
			return idx;  //账号存在返回下标
		}
	}
	
	public boolean verifyCard(User[] account,int idx){		//验证密码  参数为账号密码数组和已经验证出的账号在数组中的下标
		
		System.out.println("输入密码：");
		String password = sc.nextLine();	//接受输入密码
		
		boolean temp = password.equals(account[idx].getPassword());  // 用password 比较账号密码数组的下标为idx对象的密码值
		
		if(temp == false){		//temp为false 密码错误
			System.out.println("密码错误！重新输入");
			return false;		//密码错误返回false
		}else{
			return true;	//密码正确返回true
		}
		
	}
	
}
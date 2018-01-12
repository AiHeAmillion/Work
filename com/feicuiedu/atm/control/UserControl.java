package feicuiedu.atm.control;
import 	feicuiedu.atm.business.*;
public class UserControl{ 	//用户控制类  包含用户账号 密码数组创建 登录流程控制
	
	public User[] buildArray(){

		User[] account;	//定义一个User类数组存储user对象
		account = new User[2];	//数组动态初始化
		
		User user = new User();		//1 用户
		User user2 = new User();	//2 用户

		user.setNumber("111");	//设置 变量
		user.setName("翡翠侠");
		user.setBalance(1000);
		user.setPassword("123456");
		
		user2.setNumber("222");	//设置 变量
		user2.setName("国 *");
		user2.setBalance(0);
		user2.setPassword("654321");
		
		account[0] = user;
		account[1] = user2;

		return account;
		/*loginControl(account);	//调用登录流程控制*/
	}

	public User loginControl(User[] account){	//登录流程控制
		Login lin = new Login();
		boolean temp = false;
		int idx = -5;

		aa:
		do{	
			String number = lin.verifyLength(account); //调用Login登录验证账号长度方法  最后层层调用 返回一个当前对象进行接下来的操作
			
			if (number.equals("-1")) {		//接收的返回值为 -1 时账号长度不对
				continue aa;	//账号长度不对  跳转到 aa: 重新来
			}else {
				temp = true;		//账号长度正确改变temp的值为true
			}

			if (temp == true) {
				idx=lin.verifyExist(number,account);
				if (idx == -1) {		//如果idx接收的验证账号存在的方法的返回值（账号密码数组的下标）为-1时，账号不存在，跳出重新循环
					temp = false;		//账号不存在 输入还是错误 temp值变为false
					continue aa;	//账号长度不对  跳转到 aa: 重新来
				}else{
					temp = true;		//账号存在temp的值还为true
				}
			}else{

			}

			if (temp == true) {
				temp = lin.verifyCard(account,idx); //temp接受验证密码方法的返回值 false时错误 true时正确
			}
			
		}while(temp == false);		//temp = false 执行下次循环 重新输入
		return account[idx];	//返回idx下标的对象  即接下来的操作对象
	}
}
package feicuiedu.atm.business;
public class User{
	private String number;
	private double balance;
	private String password;
	private String name;
	private StringBuffer flow = new StringBuffer("无交易信息\n");	//流水信息 这里新建StringBuffer类型时 不同于string要先new开辟空间

	public void setNumber(String number){	//设置账号
		this.number = number;
	}
	public String getNumber(){
		return number;
	}

	public void setPassword(String password){	//设置账号
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setName(String name){	//设置姓名
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setBalance(double balance){	//设置余额
		this.balance = balance;
	}
	public double getBalance(){
		return balance;
	}

	public void setFlow(StringBuffer flow){	//设置流水信息
		this.flow = flow;
	}
	public StringBuffer getFlow(){
		return flow;
	}

}
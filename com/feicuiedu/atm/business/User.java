package feicuiedu.atm.business;
public class User{
	private String number;
	private double balance;
	private String password;
	private String name;
	private StringBuffer flow = new StringBuffer("�޽�����Ϣ\n");	//��ˮ��Ϣ �����½�StringBuffer����ʱ ��ͬ��stringҪ��new���ٿռ�

	public void setNumber(String number){	//�����˺�
		this.number = number;
	}
	public String getNumber(){
		return number;
	}

	public void setPassword(String password){	//�����˺�
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setName(String name){	//��������
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setBalance(double balance){	//�������
		this.balance = balance;
	}
	public double getBalance(){
		return balance;
	}

	public void setFlow(StringBuffer flow){	//������ˮ��Ϣ
		this.flow = flow;
	}
	public StringBuffer getFlow(){
		return flow;
	}

}
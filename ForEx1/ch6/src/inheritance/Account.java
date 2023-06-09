package inheritance;

public class Account {
	private String ano;
	private String owner;
	private int balance;
	
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	
	//예금하다
	//deposit(int amount): 잔액=잔액+입금액
	void deposit(int amount) {
		this.balance += amount;
	}
	//출금하다
	//withdraw(int ampunt): 잔액=잔액-출금액
	int withdraw(int amount) {
		if (this.balance>=amount) {
			balance-=amount;
		}return balance;
	}
	
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
}


// SavingAccount.java
// 저축예금 계좌를 모델한다

public class Account {
	
	// 객체 변수
	private int accountNumber;
	private static double balance;
	
	// 클래스 변수
	public static double interestRate = 0.1;
	public static int numberOfAccounts = 0;
	
	// 생성자 메소드
	// 계좌 번호를 매개변수 값으로 초기화 하면서 새로운 SavingAccount 객체를 생성한다
	
	public Account(int number)
	{
		accountNumber = number;
		balance = 0;
		numberOfAccounts++;
	}
	
	// 접근자 메소드
	// 클래스 메소드: 이자율을 반환한다
	public static double getInterestRate()
	{
		return interestRate;
	}
	// 클래스 메소드: 저축예금 계좌들의 수를 반환한다
	public static int getNumberOfAccounts()
	{
		return numberOfAccounts;
	}
	
	// 클래스 메소드: 매개변수 account가 가리키는 SavingAccount 객체의 잔고를 출력한다
	public static void showBalance(Account account)
	{
		System.out.println(account.getAccountNumber() + "의 잔고: " + account.getBalance());
	}
	
	// 객체 메소드: 계좌 번호를 반환한다
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	// 객체 메소드: 객체 변수들의 값들을 문자열의 형태로 반환한다
	public String toString()
	{
		float ac_num = (float) Math.random();
		int ac_realnum = (int) (ac_num*100000000);
		int realnum = ac_realnum;
		String resultString = "";
		resultString = resultString + "계좌번호 : " + realnum + "\n";
		resultString = resultString + "잔고 : " + getBalance();
		return resultString;
 	}
	
	// 변경자 메소드
	// 클래스 메소드: 이자율을 주어진 값으로 변경한다
	public static void setInterestRate(double newRate)
	{
		interestRate = newRate;
		balance = balance * interestRate;	
	}
	
	
	// 객체 메소드: 계좌에 이자를 더한다
	public void addInterest()
	{
		balance = balance * (1 + getInterestRate());
	}
	
	// 객체 메소드: 계좌 번호를 주어진 값으로 변경한다
	public void setAccountNumber(int number)
	{
		accountNumber = number;
	}
	
	// 객체 메소드: 잔고를 주어진 값으로 변경한다
	public void deposit(int amount)
	{
		balance += amount;
	}
	
	// 객체 메소드: 잔고를 주어진 출금액만큼 감소시킨다
	public void withdraw(int amount)
	{
		if (amount > balance)
			System.out.println("잔고가 부족합니다");
		else
			balance -= amount;
	}

	
}

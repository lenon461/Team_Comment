package new_account_manager_6;

// SavingAccount.java
// ���࿹�� ���¸� ���Ѵ�

import java.util.*; // Scanner(), GragorianCalendar()

public class MakeAccount {
	
	// ��ü ����
	private int accountNumber;
	private double balance;
	
	
	// Ŭ���� ����
	public static double interestRate = 0;
	public static int numberOfAccounts = 0;
	
	// ������ �޼ҵ�
	// ���� ��ȣ�� �Ű����� ������ �ʱ�ȭ �ϸ鼭 ���ο� SavingAccount ��ü�� �����Ѵ�
	
	public MakeAccount(int number)
	{
		accountNumber = number;
		balance = 0;
		numberOfAccounts++;
	}
	
	// ������ �޼ҵ�
	// Ŭ���� �޼ҵ�: �������� ��ȯ�Ѵ�
	public static double getInterestRate()
	{
		return interestRate;
	}
	// Ŭ���� �޼ҵ�: ���࿹�� ���µ��� ���� ��ȯ�Ѵ�
	public static int getNumberOfAccounts()
	{
		return numberOfAccounts;
	}
	
	// Ŭ���� �޼ҵ�: �Ű����� account�� ����Ű�� SavingAccount ��ü�� �ܰ� ����Ѵ�
	public static void showBalance(MakeAccount account)
	{
		System.out.println(account.getAccountNumber() + "�� �ܰ�: " + account.getBalance());
	}
	
	// ��ü �޼ҵ�: ���� ��ȣ�� ��ȯ�Ѵ�
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	// ��ü �޼ҵ�: ��ü �������� ������ ���ڿ��� ���·� ��ȯ�Ѵ�
	public String toString()
	{
		String resultString = "";
		resultString += "���¹�ȣ : " + getAccountNumber() + "\n";
		resultString += "�ܰ� : " + getBalance();
		return resultString;
 	}
	
	// ������ �޼ҵ�
	// Ŭ���� �޼ҵ�: �������� �־��� ������ �����Ѵ�
	public static void setInterestRate(double newRate)
	{
		interestRate = newRate;
	}
	
	// ��ü �޼ҵ�: ���¿� ���ڸ� ���Ѵ�
	public void addInterest()
	{
		balance = balance * (1 + getInterestRate());
	}
	
	// ��ü �޼ҵ�: ���� ��ȣ�� �־��� ������ �����Ѵ�
	public void setAccountNumber(int number)
	{
		accountNumber = number;
	}
	
	// ��ü �޼ҵ�: �ܰ� �־��� ������ �����Ѵ�
	public void deposit(int amount)
	{
		balance += amount;
	}
	
	// ��ü �޼ҵ�: �ܰ� �־��� ��ݾ׸�ŭ ���ҽ�Ų��
	public void withdraw(int amount)
	{
		if (amount > balance)
			System.out.println("�ܰ� �����մϴ�");
		else
			balance -= amount;
	}
	
}

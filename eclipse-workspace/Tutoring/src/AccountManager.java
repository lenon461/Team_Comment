/*
 * 아래는 수업시간에 다룬 두d 계좌를 관리하는 프로그램 입니다. 유일한 차이점은 
javax.swing 을 이용한 그래픽 유저인터페이스를 사용하지 않고 콘솔 입출력을 
 * 사용하고 있다는 점입니다.

아래 코드에는 다음 클래스들의 정의가 이미 되어있습니다.

BankAccount
BankReader
BankWriter
AccountController2
AccountManger2
이 두 계좌 관리 프로그램에 다음 기능을 추가하세요.

"T 금액" 을 명령어로 입력받아서 현재 활성화 된 계좌에서 비활성 계좌로 금액만큼 이체
참고로, 이체는 영어로 transfer 이다.
"I 이율" 을 명령어로 입력받아서, 현재 활성화 된 계좌의 금액을 이율만큼 증가
이율은 0~1 범위의 실수이다.
이율은 소수점 두자리까지만 인정한다. 예, 0.055 => 0.05
이율만큼 증가한다는 것은 (금액 * 이율) 만큼 증가시킨다는 뜻이다.
참고로, 이율은 영어로 interest 이다.
아래 코드를 코드온웹 인터페이스에서 바로 돌려볼 수 있고, 전체 코드를 파일 "AccountManager.java"에 붙여넣고 실행하면 돌려볼 수 있습니다 (아래 코드를 보시면 main 메소드가 있는 AccountManager 클래스만 public 으로 정의해주고 있고 나머지 클래스는 public 없이 정의하고 있다는 것을 아실 수 있습니다. 이렇게 여러개의 클래스를 파일 하나에 정의하는 것도 가능합니다).
 * 
 * */

import java.text.DecimalFormat;
import java.util.Scanner;

class BankAccount 
{
    protected int balance;

    public BankAccount(int initial_amount) {
         if (initial_amount >= 0)
             balance = initial_amount;
         else
             balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        boolean result = false;
        if (amount < 0)
             System.out.println("invalid deposit amount");
         else {
             balance = balance + amount;
             result = true;
         }
         return result;
    }
    public boolean withdraw(int amount) {
        boolean result = false;
        if (amount < 0)
            System.out.println("invalid withdraw amount");
        else if (amount > balance)
            System.out.println("not enough balance");
        else {
            balance = balance - amount;
            result = true;
        }
        return result;
    }
    public boolean transfer(int amount) {
    	 boolean result = false;
         if (amount < 0)
             System.out.println("invalid transfer amount");
         else if (amount > balance)
             System.out.println("not enough balance");
         else {
             balance = balance - amount;
             result = true;
         }
         return result;
    }
}


class BankReader 
{
    private String input_line = "";

    public char readCommand(String message) {
        Scanner scan = new Scanner(System.in);  // Reading from System.in
        System.out.println(message);
        input_line = scan.nextLine().toUpperCase();
        return input_line.charAt(0);
    }

    public int readAmount()
    {
        int answer = 0;
        String s = input_line.substring(1, input_line.length());

        if(s.length() > 0) {
            double dollars_cents = new Double(s).doubleValue();
            answer = (int)(dollars_cents*100);
            System.out.println(dollars_cents);
        } else
            System.out.println("invalid command - input amount: 0");
        return answer;
    }
    public double readInterest()
    {
    	double answer = 0;
        String s = input_line.substring(1, input_line.length());

        if(s.length() > 0) {
            double dollars_cents = new Double(s).doubleValue();
            answer = (dollars_cents);
        } else
            System.out.println("invalid command - input amount: 0");
        return answer;
    }
}

class BankWriter 
{
    private BankAccount bank;
    private String last_transaction = "";

    public BankWriter(BankAccount b) {
        bank = b;
    }

    public String unconvert(int i) {
        return new DecimalFormat("0.00").format(i/100.0);
    }

    public void setTransaction(String message, int amount)
    { 
        last_transaction = message + " " + unconvert(amount);
        System.out.println("transaction: " + last_transaction);
    }

    public void setTransaction(String message)
    { 
        last_transaction = message;
        System.out.println("transaction: " + last_transaction);
    }

}

class AccountController
{
    private BankReader reader; // input view
    private BankAccount primary_account, secondary_account, account;
    private BankWriter primary_writer, secondary_writer, writer;

    public AccountController (BankReader r, BankAccount a1,BankWriter w1, BankAccount a2, BankWriter w2)
    {
        reader = r;
        primary_account = a1;
        primary_writer = w1;
        secondary_account = a2;
        secondary_writer = w2;
        account = primary_account;
        writer = primary_writer;
    }

    public void resetAccount (BankAccount new_account,BankWriter new_writer) {
        account = new_account;
        writer = new_writer;
    }

    public void processTransactions()
    {
        char command = reader.readCommand("명령 P/S/D/W/Q/T/I와 금액을 입력하세요.");

        switch (command) {
            case 'P':
                resetAccount(primary_account, primary_writer);
                break;
            case 'S':
                resetAccount(secondary_account, secondary_writer);
                break;
            case 'Q':
                System.out.println("Quit");
                return;
            case 'D':
                { 
                    System.out.println("Deposit");
                    int amount = reader.readAmount();
                    if (account.deposit(amount)) writer.setTransaction("deposit $", amount);
                    else writer.setTransaction("deposit error ", amount);
                    break;
                }
            case 'W':
                { 
                    System.out.println("Withdraw");
                    int amount = reader.readAmount();
                    if (account.withdraw(amount)) writer.setTransaction("withdraw $", amount);
                    else writer.setTransaction("withdraw error ", amount);
                    break;
                }
                /*
                 * "T 금액" 을 명령어로 입력받아서 현재 활성화 된 계좌에서 비활성 계좌로 금액만큼 이체
참고로, 이체는 영어로 transfer 이다.
"I 이율" 을 명령어로 입력받아서, 현재 활성화 된 계좌의 금액을 이율만큼 증가
이율은 0~1 범위의 실수이다.
이율은 소수점 두자리까지만 인정한다. 예, 0.055 => 0.05
이율만큼 증가한다는 것은 (금액 * 이율) 만큼 증가시킨다는 뜻이다.
참고로, 이율은 영어로 interest 이다.
아래 코드를 코드온웹 인터페이스에서 바로 돌려볼 수 있고, 전체 코드를 파일 "AccountManager.java"에 붙여넣고 실행하면 돌려볼 수 있습니다 (아래 코드를 보시면 main 메소드가 있는 AccountManager 클래스만 public 으로 정의해주고 있고 나머지 클래스는 public 없이 정의하고 있다는 것을 아실 수 있습니다. 이렇게 여러개의 클래스를 파일 하나에 정의하는 것도 가능합니다).
 * 
 * */
            case 'T':
                // 'T 금액', 활성 계좌에서 비활성 계좌로 금액만큼 이체
            	System.out.println("transfer");
            	int amount = reader.readAmount();
            	if (account.withdraw(amount)) writer.setTransaction("withdraw $", amount);
                else writer.setTransaction("withdraw error ", amount);
            	
            	resetAccount(secondary_account, secondary_writer);
            	
            	if (account.deposit(amount)) writer.setTransaction("deposit $", amount);
                else writer.setTransaction("deposit error ", amount);
            	
            	resetAccount(primary_account, primary_writer);
            	
            	break;
            case 'I':
                // 'I 이율', 활성 계좌의 금액을 이율만큼 증가
            	
            	double amount1 = reader.readInterest();
            	int cur_balance = account.getBalance();
            	double interest = amount1 * cur_balance;
            	if (account.deposit((int)interest)) writer.setTransaction("interest $", (int)interest);
                else writer.setTransaction("interest error ", (int)interest);
            	
                break;
            default:
                writer.setTransaction("invalid commpand: " + command);
        }
        // 모든 계좌의 정보를 출력합니다.
        System.out.println("=======================");
        System.out.println("== currently active : " + ((account == primary_account) ? "primary" : "secondary"));
        System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
        System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
        System.out.println("=======================");

        this.processTransactions();
    }
}


public class AccountManager {
    public static void main(String[] args) { 

        BankReader reader = new BankReader();
        BankAccount primary_account = new BankAccount(0);
//        BankVIPAccount primary_account = new BankVIPAccount(0, 100);
        BankWriter primary_writer = new BankWriter(primary_account);
        BankAccount secondary_account = new BankAccount(0);
        BankWriter secondary_writer = new BankWriter(secondary_account);
        AccountController controller = new AccountController(reader,
                primary_account, primary_writer, secondary_account,
                secondary_writer);
        controller.processTransactions();
    }
}
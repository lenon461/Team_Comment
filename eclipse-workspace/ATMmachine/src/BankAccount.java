
public class BankAccount {
    protected int balance;
    public String name;
    public int id;
    public int password;
    

    public BankAccount(int initial_amount, String name, int id, int password) {
    	
    	this.name = name;
    	this.id = id;
    	this.password = password;
    	
         if (initial_amount >= 0)
             this.balance = initial_amount;
         else
             this.balance = 0;
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

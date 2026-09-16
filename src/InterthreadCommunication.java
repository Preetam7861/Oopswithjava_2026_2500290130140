
class BankAccount {
    private int balance = 500;

    synchronized void withdraw(int amount) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()
                + " wants to withdraw ₹" + amount);

        while (balance < amount) {
            System.out.println(Thread.currentThread().getName()
                    + " : Insufficient balance. Waiting...");

            wait();
        }

        balance -= amount;

        System.out.println(Thread.currentThread().getName()
                + " successfully withdrew ₹" + amount);

        System.out.println("Remaining balance: ₹" + balance);
    }

    // Deposit method
    synchronized void deposit(int amount) {

        System.out.println(Thread.currentThread().getName()
                + " is depositing ₹" + amount);

        balance += amount;

        System.out.println("New balance after deposit: ₹" + balance);

        notify();
    }
}

class WithdrawThread implements Runnable {

    private BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        try {
            account.withdraw(700);
        } catch (InterruptedException e) {
            System.out.println("Withdrawal interrupted.");
        }
    }
}

class DepositThread implements Runnable {

    private BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(500);
    }
}

// Driver Class
public class InterthreadCommunication {

    public static void main(String[] args)
            throws InterruptedException {

        BankAccount account = new BankAccount();

        WithdrawThread w = new WithdrawThread(account);
        DepositThread d = new DepositThread(account);

        Thread thread1 = new Thread(w, "Customer");
        Thread thread2 = new Thread(d, "Bank");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All transactions completed.");
    }
}

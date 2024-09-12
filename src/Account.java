public abstract class Account {
    private int id;
    protected int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }
    public Account(int id) {
        // this.id = id;
        // this.balance = 0;
        this(id, 0);
    }

    public int getId() {
        return id;
    }
    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
    public void withdraw(int amount) throws Exception {
        if (this.balance < amount) {
            throw new Exception("Insufficient funds");
        }
        this.balance -= amount;
    }
}

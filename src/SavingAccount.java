public class SavingAccount extends Account {
    private int limit;
    public SavingAccount(int id, int balance) {
        super(id, balance);
        this.limit = 500;
    }
    public SavingAccount(int id) {
        this(id, 0);
    }

    @Override
    public void withdraw(int amount) throws Exception {
        if (amount > this.limit) {
            throw new Exception("Withdrawal exceeds limit");
        }
        super.withdraw(amount);
    }
    public void increaseLimit() {
        this.limit+=100;
    }
}

public class CheckAccount extends Account{
    private float interestRate = 2;
    public CheckAccount(int id, int balance) {
        super(id, balance);
    }
    public CheckAccount(int id) {
        this(id, 0);
    }

    @Override
    public void deposit(int amount) {
        super.deposit(amount);
        this.balance = (int)Math.ceil( this.balance * this.interestRate/100);
    }
    
}

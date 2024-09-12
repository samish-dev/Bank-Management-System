public class Client {
    private String name;
    private int accountNumber;

    public Client(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }
    public Client(String name) {
        this(name, -1);
    }
    public String getName() {
        return this.name;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        System.out.println("Account number is being changed");
        this.accountNumber = accountNumber;
    }

}

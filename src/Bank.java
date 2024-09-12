enum AccountType {
    SAVINGS_ACCOUNT,
    CHECK_ACCOUNT
}

public class Bank implements BankService{
    public String name;
    private Account accounts[];
    private int accountIndex;

    public Bank(String name) {
        this.name = name;
        this.accounts = new Account[5];
        this.accountIndex = 0;
    }

    public void greet(Client client) {
        System.out.println("Hello Mr. "+client.getName()+", welcome to bank " + this.name);
    }

    private void createAccount(Client client, AccountType accountType) throws Exception {
        if (this.accountIndex < 5) {
            Account newAccount = null;
            if (accountType.equals(AccountType.SAVINGS_ACCOUNT)) {
                newAccount = new SavingAccount(this.accountIndex);
            } else if (accountType.equals(AccountType.CHECK_ACCOUNT)) {
                newAccount = new CheckAccount(this.accountIndex);
            } else {
                throw new Exception("Unknown Account Type");
            }
            this.accounts[this.accountIndex] = newAccount;
            this.accountIndex++;
            client.setAccountNumber(newAccount.getId());
            System.out.println("Successfully created an account for client "+ client.getName());
        } else {
            System.out.println("Faield to create account, max number of accounts in bank has been reached");
        }
    }
    public void createSavingAccount(Client client) {
        try {
            this.createAccount(client, AccountType.SAVINGS_ACCOUNT);
        } catch (Exception e) {
            System.out.println("Error creating saving account reason: "+ e.getMessage());
        }
    }
    public void createCheckAccount(Client client) {
        try {
            this.createAccount(client, AccountType.CHECK_ACCOUNT);
        } catch (Exception e) {
            System.out.println("Error creating check account reason: "+ e.getMessage());
        }
    }

    public int checkBalance(Client client) {
        try {
            int accountNumber = client.getAccountNumber();
            Account account = this.accounts[accountNumber];
            return account.getBalance();
        } catch(Exception error) {
            System.out.println("Error getting acount balance, reason: "+ error.getMessage());
        }
        return 0;
    }

    public void withdraw(Client client, int amount){
        try {
            Account clientAccount = this.getAccount(client.getAccountNumber());
            clientAccount.withdraw(amount);
            System.out.println("Withdrawal operation succeed");
        } catch (Exception error) {
            System.out.println("Error withdrawing, reason: " + error.getMessage());
        }
    }
    public void deposit(Client client, int amount){
        Account clientAccount = this.getAccount(client.getAccountNumber());
        clientAccount.deposit(amount);
        System.out.println("Deposit operation succeed");
    }

    private Account getAccount(int accountNumber){
        return this.accounts[accountNumber];
    }

    @Override
    public void provideLoan() {
        System.out.println("Comming soon");
    }
}

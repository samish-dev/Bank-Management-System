public interface BankService {
    void withdraw(Client client, int amount);
    void deposit(Client client, int amount);
    int checkBalance(Client client);
    void createSavingAccount(Client client);
    void createCheckAccount(Client client);
    void provideLoan();
}

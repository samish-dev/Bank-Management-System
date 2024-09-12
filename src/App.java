public class App {
    public static void main(String[] args) throws Exception {
        BankService bank1 = new Bank("Audi");

        Client c1 = new Client("Sami1");
        Client c2 = new Client("Sami2");
        Client c3 = new Client("Sami3");
        Client c4 = new Client("Sami4");
        Client c5 = new Client("Sami5");
        Client c6 = new Client("Sami6");

        System.out.println("Client name: "+c1.getName()+" account id="+c1.getAccountNumber());

        bank1.createCheckAccount(c1);
        bank1.createSavingAccount(c2);
        bank1.createSavingAccount(c3);
        bank1.createCheckAccount(c4);
        bank1.createSavingAccount(c5);
        bank1.createCheckAccount(c6);

        System.out.println("Client name: "+c1.getName()+" account id="+c1.getAccountNumber());

        int balance = bank1.checkBalance(c1);
        System.out.println("The balance is "+ balance);

        int balance2 = bank1.checkBalance(c6);
        System.out.println("The balance is "+ balance2);

        bank1.deposit(c1, 100);
        balance = bank1.checkBalance(c1);
        System.out.println("The balance for "+c1.getName()+" is "+ balance);
        bank1.withdraw(c1, 36);
        balance = bank1.checkBalance(c1);
        System.out.println("The balance for "+c1.getName()+" is "+ balance);
        bank1.withdraw(c1, 360);
        bank1.withdraw(c2, 600);

    }
}

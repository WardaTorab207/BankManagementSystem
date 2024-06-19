package New;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private String AcType;
    private String AcId;
    private String ClientId;

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    private double Current_Balance;
    private Client client;
    public static ArrayList<Account> account_list;
    Scanner sc = new Scanner(System.in);
    private static int Acc_Id = 1;

    // Constructors
    public Account() {
        account_list = new ArrayList<>();
    }


    public Account(String acType, String acId, double current_Balance, String clientId) {
        AcType = acType;
        AcId = acId;
        Current_Balance = current_Balance;
        this.ClientId = clientId;
    }

    // Methods
    public void StoreIntoFile(){
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\AccountFile.txt");
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Account acc : account_list) {
                String line = acc.getAcId() + "," + acc.getAcType() + "," + acc.getCurrent_Balance() + "," + acc.ClientId;
                writer.write(line + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetDataFromFile(){
        account_list = new ArrayList<>();
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\AccountFile.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] data  = line.split(",");
                Account acc = new Account(data[1],data[0],Double.parseDouble(data[2]),data[3]);
                account_list.add(acc);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {

        }
    }
    public String generateAccountId() {
        if (!account_list.isEmpty()) {
            int lastIndex = account_list.size() - 1;
            String lastClientId = account_list.get(lastIndex).getAcId();
            int lastId = Integer.parseInt(lastClientId.substring(2));
            Acc_Id = lastId + 1;
        }

        String formattedCounter = String.format("%03d", Acc_Id);
        String AccId = "AC" + formattedCounter;
        Acc_Id++;
        return AccId;
    }

    public void AddAccount(Account obj) {
        account_list.add(obj);
        System.out.println("Account has been added Successfully !");
    }

    public Account SearchAccount(String accountId) {
        for (Account temp : account_list) {
            if (temp.AcId.equals(accountId)) {
                System.out.println("\n\u001B[1mYour Account has been found successfully\u001B[0m");
                return temp;
            }
        }
        return null;
    }

    public void UpdateAccount(String accountId) {
        Account acc = SearchAccount(accountId);
        if (acc == null) {
            System.out.println("Account not Found");
        } else {
            System.out.println("""
                    Select the Account Type
                    1 - \u001B[1mSavings Account\u001B[0m: For saving money with potential interest earnings.
                    2 - \u001B[1mChecking Account\u001B[0m: For day-to-day transactions.
                    3 - \u001B[1mCredit Card Account\u001B[0m: For credit transactions with a predefined credit limit.
                    4 - \u001B[1mInvestment Account\u001B[0m: For managing investments such as stocks, bonds, etc.
                    5 - \u001B[1mLoan Account\u001B[0m: If the client has taken a loan
                    """);
            String Acc_type = null;
            int option = sc.nextInt();
            if (option == 1) {
                Acc_type = "Saving";
            } else if (option == 2) {
                Acc_type = "checking";
            } else if (option == 3) {
                Acc_type = "Credit";
            } else if (option == 4) {
                Acc_type = "Investment";
            } else if (option == 5) {
                Acc_type = "loan";
            } else {
                Acc_type = "General";
            }
            acc.setAcType(Acc_type);
            int index = account_list.indexOf(acc);
            account_list.set(index, acc);
            System.out.println("\n\u001B[1mInformation updated successfully\u001B[0m");
        }
    }

    public void DeleteAccount(String AcId) {
        Account acc = this.SearchAccount(AcId);
        if (acc != null) {
            System.out.println("Are you really want to delete the " + acc.AcId + "Y/N");
            String ans = sc.next();
            if (ans.toLowerCase().equals("y")) {
                account_list.remove(acc);
                System.out.println("\n\u001B[1mAccount Deleted Successsfully !\u001B[0m");
            }
        } else {
            System.out.println("SORRY . Account not found !");
        }
    }

    public void ViewAccountHolders() {
        ArrayList<String> names = new ArrayList<>();
        System.out.println("List of account holders are :");
        for (Account temp : account_list) {
            Client cli = GetClientByClientId(temp.ClientId);
            String clientName = cli.getClientName(cli);
            if (!names.contains(clientName))
            {
                names.add(clientName);
            }
        }
        for (String temp :names
             ) {
            System.out.println(temp);
        }
    }
    public Client GetClientByClientId(String clientId)
    {
        ArrayList<Client> cli_list = Client.getClientList();
        for (Client temp : cli_list) {
            if (temp.getClientId().equals(clientId)) {
                return temp;
            }
        }
        return null;
    }
    public void ShowAllAccount() {
        for (Account temp : account_list) {
            System.out.println(temp);
        }
    }

    public void GetAccountBalance(String accId) {
        Account acc = this.SearchAccount(accId);
        if (acc == null) {
            System.out.println("SORRY . Account not found !");
        } else {
            System.out.println("Total balance in your account is" + acc.Current_Balance);
        }

    }

    public void deposit(String accountId, double amount) {
        Account acc = SearchAccount(accountId);
        if (acc != null) {
            if (amount > 0) {
                acc.setCurrent_Balance(acc.getCurrent_Balance() + amount);
                System.out.println(
                        "\n\u001B[1mDeposit successful. New balance: " + acc.getCurrent_Balance() + "\n\u001B[0m");
            } else {
                System.out.println("\n\u001B[1mInvalid deposit amount. Please enter a positive amount.\u001B[0m");
            }
        } else {
            System.out.println("\n\u001B[1mAccount not Found\n\u001B[0m");
        }
    }

    public void withdraw(String accountId, double amount) {
        Account acc = SearchAccount(accountId);
        if (acc != null) {
            if (amount > 0) {
                if (acc.getCurrent_Balance() >= amount) {
                    acc.setCurrent_Balance(acc.getCurrent_Balance() - amount);
                    System.out.println("\n\u001B[1mWithdrawal successful. New balance: " + acc.getCurrent_Balance()
                            + "\n\u001B[0m");
                } else {
                    System.out.println("\n\u001B[1mInsufficient funds. Cannot withdraw.\u001B[0m");
                }
            } else {
                System.out.println("\n\u001B[1mInvalid withdrawal amount. Please enter a positive amount.\u001B[0m");
            }
        } else {
            System.out.println("\n\u001B[1mAccount not Found\u001B[0m");
        }
    }

    // Getters and Setters

    public String getAcType() {
        return AcType;
    }


    public void setAcType(String acType) {
        AcType = acType;
    }


    public String getAcId() {
        return AcId;
    }


    public void setAcId(String acId) {
        AcId = acId;
    }


    public double getCurrent_Balance() {
        return Current_Balance;
    }


    public void setCurrent_Balance(double current_Balance) {
        Current_Balance = current_Balance;
    }
    
    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Account Id : " + AcId +
                "\nAccount Type='" + AcType +
                "\nClient Id='" + ClientId +
                "\nCurrent Balance=" + Current_Balance +
                 GetClientByClientId(ClientId) +"\n" ;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

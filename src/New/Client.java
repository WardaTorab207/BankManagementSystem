package New;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static ArrayList<Client> clientList = new ArrayList<>();
    private static int nextId = 1;

    private Person person = new Person();
    private String clientId;    
    public Account acc = new Account();
    Scanner sc = new Scanner(System.in);    

    
    // Constructors
    public Client() {
        clientList = new ArrayList<>();
    }

    public Client(Person person, String clientId) {
        this.person = person;
        this.clientId = clientId;
    }
    public void StoreIntoFile(){
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\ClientFile.txt");
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Client cli : clientList) {
                String line = cli.clientId +","+ cli.person.getName()+","+cli.person.getCNIC()+","+cli.person.getAge()+","+cli.person.getGender();
                writer.write(line + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetDataFromFile(){
        clientList = new ArrayList<>();
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\ClientFile.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] data  = line.split(",");
                Person per = new Person(data[1], data[2], Integer.parseInt(data[3]), data[4]);
                Client cli = new Client(per,data[0]);
                clientList.add(cli);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {

        }
    }

    public static ArrayList<Client> getClientList()
    {return clientList;}

    public String generateClientId() {
        if (!clientList.isEmpty()) {
            int lastIndex = clientList.size() - 1;
            String lastClientId = clientList.get(lastIndex).getClientId();
            int lastId = Integer.parseInt(lastClientId.substring(2)); // Extract numeric part
            nextId = lastId + 1;
        }

        String formattedCounter = String.format("%03d", nextId);
        String clientId = "CL" + formattedCounter;
        nextId++;
        return clientId;
    }


    public Client SearchClient(String clientId) {
        for (Client temp : clientList) {
            if (temp.clientId.equals(clientId)) {
                System.out.println("\n\u001B[1mYour Client has been found successfully\u001B[0m");
                return temp;
            }
        }
        return null;
    }

    public void DeleteClient(String id) {
        Client client = SearchClient(id);
        if (client != null) {
            System.out.println("Are you really want to delete the " + client.person.getName() + " Y/N ?");
            String ans = sc.next();
            if (ans.toLowerCase().equals("y")) {
                clientList.remove(client);
                System.out.println("\n\u001B[1mClient Deleted Successsfully !\u001B[0m");
            }
        } 

    }
    public String GetClientIdByCnic(String cnic) {
        for (Client cli:clientList) {
            if(cli.person.getCNIC().equals(cnic))
            {
                return cli.clientId;
            }
        }
        return null;
    }
    public String GetCnicByClientId(String clientId) {
        String cnic = "";
        Client temp = this.SearchClient(clientId);
        if (temp != null) {
            cnic = temp.person.getCNIC();
        }
        return cnic;
    }

    public int GetTotalClient() {
        int totalClients = 0;
        for (Client temp : clientList) {
            System.out.println(temp);
            totalClients++;
        }
        return totalClients;
    }

    public void updateClient(String clientId, String updatedField, String newValue) {
        Client client = this.SearchClient(clientId);
        if (client == null) {
            System.out.println("Client not Found");
        } else {
            switch (updatedField.toLowerCase()) {
                case "cnic":
                    client.person.setCNIC(newValue);
                    break;
                case "name":
                    client.person.setName(newValue);
                    break;
                case "age":
                    try {
                        int newAge = Integer.parseInt(newValue);
                        client.person.setAge(newAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age format. Please enter a valid integer for age.");
                        return;
                    }
                    break;
                case "gender":
                    client.person.setGender(newValue);
                    break;
                default:
                    System.out.println("Invalid field to update. Please choose from CNIC, Name, Age, or Gender.");
                    return;
            }

            int index = clientList.indexOf(client);
            clientList.set(index, client);
            System.out.println("\n\u001B[1mInformation updated successfully\n\u001B[0m");
        }
    }

    public void ShowAllClient() {
        for (Client temp : clientList) {
            System.out.println(temp);
        }
    }

    public void AddClient(Client obj) {
        clientList.add(obj);
        System.out.println("Your Client Id " + obj.clientId);

        System.out.println("\n\u001B[1mClient has been Added Successfully !\n\u001B[0m");
    }

    public void GetAllClientAccount(String clientId) {
        ArrayList<Account> account_list = Account.account_list;
        for (Account temp : account_list) {
            if (temp.getClientId().equals(clientId)) {
                System.out.println(temp);
            }
        }
    }
    public ArrayList<String> GetAllAccountId(String clientId) {
        ArrayList<String> accIdList = new ArrayList<>();
        ArrayList<Account> account_list = Account.account_list;
        for (Account temp : account_list) {
            if (temp.getClientId().equals(clientId)) {
                accIdList.add(temp.getAcId());
            }
        }
        return accIdList;
    }
    public double GetTotalBalance(String clientId) {
        double balance = 0;
        ArrayList<Account> account_list = Account.account_list;
        for (Account temp : account_list) {
            if (temp.getClientId().equals(clientId)) {
                balance += temp.getCurrent_Balance();
            }
        }
        return balance;
    }

    @Override
    public String toString() {
        return person + "\nClient Id : " + clientId;
    }




    // Getters and Setters

    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }


    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName(Client obj) {
        return obj.person.getName();
    }

    
    
}

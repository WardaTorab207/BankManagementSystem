package New;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Container;

public class Bank  {

    // Global Variables
    static Person global_person = new Person();
    static Client global_client= new Client();
    static Account global_account = new Account();
    private ImageIcon backgroundImage;
    JFrame frame;
    JLabel l1, l2, l3;
    Container container;
    TextField t1, t2, t3;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    int a, b, result;


    public Bank() {
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.setTitle("Mirza Bank System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 700, 600);
        container = frame.getContentPane();

        // Set a light background color
        container.setBackground(new Color(193,154,107));  // Light gray

        container.setLayout(null);
        frame.setResizable(false);

        JLabel label_Heading = new JLabel("Mirza Bank Management System");
        label_Heading.setBounds(100, 50, 900, 50);
        container.add(label_Heading);
        label_Heading.setForeground(Color.black);
        label_Heading.setFont(new Font("Serif", Font.BOLD, 35));

        JPanel personsPanel = createSectionPanel("Persons Section", new Color(100,65,23),"C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\person.png");  // Light red
        personsPanel.setBounds(80, 170, 250, 150);
        container.add(personsPanel);

        JPanel clientsPanel = createSectionPanel("Clients Section", new Color(100,65,23),"C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\client.png");  // Light blue
        clientsPanel.setBounds(350, 170, 250, 150);
        container.add(clientsPanel);

        JPanel accountsPanel = createSectionPanel("Accounts Section", new Color(100,65,23),"C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\account.png");  // Light green
        accountsPanel.setBounds(80, 350, 250, 150);
        container.add(accountsPanel);

        JPanel exitPanel = createSectionPanel("Exit", new Color(100,65,23),"C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.png");  // Light orange
        exitPanel.setBounds(350, 350, 250, 150);
        container.add(exitPanel);

        frame.setVisible(true);
    }

    private JPanel createSectionPanel(String heading, Color borderColor,String path) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BorderLayout());
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

        Border border = BorderFactory.createLineBorder(borderColor, 5, true);
        sectionPanel.setBorder(border);

        JLabel headingLabel = new JLabel(heading);
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        headingLabel.setFont(new Font("Serif", Font.BOLD, 18));
        sectionPanel.add(headingLabel, BorderLayout.NORTH);
        sectionPanel.setCursor(handCursor);

        // Use an image path accessible from your project
        ImageIcon imageIcon = new ImageIcon(path);
        JLabel imageLabel = new JLabel(imageIcon);
        sectionPanel.add(imageLabel, BorderLayout.CENTER);

        JButton button = new JButton("OPEN");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(sectionPanel, "Button clicked in " + heading);
            }
        });
        sectionPanel.add(button, BorderLayout.SOUTH);

        return sectionPanel;
    }

//        frame = new JFrame();
//        frame.setTitle("Mirza Bank System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1000, 700);
//        frame.setLocationRelativeTo(null);
//
//        // Create the main content pane with a white background
//        JPanel mainPanel = new JPanel();
//        mainPanel.setBackground(Color.WHITE);
//        mainPanel.setLayout(new GridLayout(2, 2, 20, 20));
//
//        // Section 1: Persons
//        JPanel personsPanel = createSectionPanel("Persons", "C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.jpg", Color.RED, 5);
//        mainPanel.add(personsPanel);
//
//        // Section 2: Clients
//        JPanel clientsPanel = createSectionPanel("Clients", "C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.jpg", Color.BLUE, 5);
//        mainPanel.add(clientsPanel);
//
//        // Section 3: Accounts
//        JPanel accountsPanel = createSectionPanel("Accounts", "C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.jpg", Color.GREEN, 5);
//        mainPanel.add(accountsPanel);
//
//        // Section 4: Exit
//        JPanel exitPanel = createSectionPanel("Exit", "C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.jpg", Color.ORANGE, 5);
//        mainPanel.add(exitPanel);
//
//        // Set up the main frame
//        frame.getContentPane().add(mainPanel);
//        frame.setVisible(true);
//    }
//
//    private JPanel createSectionPanel(String heading, String imagePath, Color borderColor, int borderThickness) {
//        JPanel sectionPanel = new JPanel();
//        sectionPanel.setLayout(new BorderLayout());
//
//        // Border with specified color and thickness
//        Border border = BorderFactory.createLineBorder(borderColor, borderThickness);
//
//        // Apply the border to the panel
//        sectionPanel.setBorder(border);
//
//        // Heading Label
//        JLabel headingLabel = new JLabel(heading);
//        headingLabel.setHorizontalAlignment(JLabel.CENTER);
//        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        sectionPanel.add(headingLabel, BorderLayout.NORTH);
//
//        // Image Label (replace the placeholder image path)
//        ImageIcon imageIcon = new ImageIcon(imagePath);
//        JLabel imageLabel = new JLabel(imageIcon);
//        sectionPanel.add(imageLabel, BorderLayout.CENTER);
//
//        return sectionPanel;
//    }

//        frame = new JFrame();
//        frame.setTitle("Mirza Bank System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(150, 50, 1000, 600);
//        backgroundImage = new ImageIcon("C:\\Users\\HP G6\\OneDrive\\Pictures\\Screenshots\\bank.png");
//        container = frame.getContentPane();
//        Color col = Color.gray;
//        container.setBackground(col);
//        container.setLayout(null);
//        frame.setResizable(false);
//        // Set layout to null for absolute positioning
//        container.setLayout(null);
//
//        // Create a JLabel with the background image
//        JLabel backgroundLabel = new JLabel(backgroundImage);
//        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
//
//        // Make the JLabel non-opaque
//        backgroundLabel.setOpaque(false);
//
//        // Add the JLabel to the content pane
//        container.add(backgroundLabel);
//        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
//
//        JLabel label_Heading = new JLabel("WELCOME TO MIRZA BANK MANAGEMENT SYSTEM");
//        label_Heading.setBounds(50, 50, 900, 50);
//        container.add(label_Heading);
//        label_Heading.setForeground(Color.WHITE);
//        label_Heading.setFont(new Font("Arial", Font.BOLD, 35));
//
//        JButton PersonButton = new JButton("Persons");
//        PersonButton.setBounds(400, 200, 200, 75);
//        PersonButton.setFont(new Font("Arial", Font.BOLD, 22));
//        PersonButton.setCursor(handCursor);
//        container.add(PersonButton);
//
//
//        JButton ClientButton = new JButton("Clients");
//        ClientButton.setBounds(250, 300, 200, 75);
//        ClientButton.setFont(new Font("Arial", Font.BOLD, 22));
//        ClientButton.setCursor(handCursor);
//        container.add(ClientButton);
//
//
//        JButton AccountButton = new JButton("Accounts");
//        AccountButton.setBounds(550, 300, 200, 75);
//        AccountButton.setFont(new Font("Arial", Font.BOLD, 22));
//        AccountButton.setCursor(handCursor);
//        container.add(AccountButton);
//
//
//        JButton ExitButton = new JButton("Exit");
//        ExitButton.setBounds(400, 400, 200, 75);
//        ExitButton.setFont(new Font("Arial", Font.BOLD, 22));
//        ExitButton.setCursor(handCursor);
//        container.add(ExitButton);
//
//        // Move the frame.setVisible(true) here after adding all components
//        frame.setVisible(true);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Bank();
        global_person.GetDataFromFile();
        global_client.GetDataFromFile();
        global_account.GetDataFromFile();
        while (true) {

            Header();            
            int choice = sc.nextInt();

            if(choice == 1){
                while(true){
                    PersonHeader();
                    int choice_person = sc.nextInt();

                    if(choice_person == 1){
                        System.out.println("\n\u001B[1m----------ADD PERSON------------\u001B[0m");
                        System.out.print("Enter the name : ");
                        String name = sc.next();
                        System.out.print("Enter the CNIC : ");
                        String Cnic = sc.next();
                        System.out.print("Enter the Age : ");
                        int age = sc.nextInt();
                        System.out.print("Enter the Gender : ");
                        String gender = sc.next();
                        Person new_person = new Person(name, Cnic, age, gender);
                        global_person.AddPerson(new_person);
                    }
                    else if (choice_person == 2) {
                        System.out.println("\n\u001B[1m----------DELETE PERSON------------\u001B[0m\n");
                        System.out.print("Enter the CNIC : ");
                        String cnic = sc.next();
                        String clientId =global_client.GetClientIdByCnic(cnic);
                        ArrayList<String> acc_Id = global_client.GetAllAccountId(clientId);
                        System.out.println(acc_Id);
                        for (String temp:acc_Id) {
                            global_account.DeleteAccount(temp);
                        }
                        global_client.DeleteClient(clientId);
                        global_person.DeletePerson(cnic);
                    }
                    else if (choice_person == 3) {
                        System.out.println("\n\u001B[1m----------UPDATE PERSON INFORMATION------------\u001B[0m\n");
                        System.out.print("Enter the CNIC : ");
                        String cnic = sc.next();
                        System.out.println("What do you want to update age/name/gender : ");
                        String field = sc.next();
                        System.out.println("Enter the new value : ");
                        String newvalue = sc.next();
                        global_person.updatePerson(cnic,field,newvalue);
                    }
                    else if (choice_person == 4) {
                        System.out.println("\n\u001B[1m----------SHOW ALL PERSONS------------\u001B[0m\n");
                        global_person.ShowAllPerson();
                    }
                    else if (choice_person == 5) {
                        System.out.println("\n\u001B[1m------------Search Person By CNIC---------\u001B[0m\n");
                        System.out.println("Enter CNIC :");
                        String temp = sc.next();
                        System.out.println(global_person.SearchPerson(temp));
                    }
                    else if (choice_person == 6) {
                        System.out.println("\n\u001B[1m-----------View Person details-----------\u001B[0m\n");
                        System.out.println("Enter CNIC :");
                        String temp = sc.next();
                        System.out.println(global_person.SearchPerson(temp));
                    }
                    else if(choice_person == 7) {
                        System.out.println("\n\u001B[1m----------Total Persons in Bank------------\u001B[0m\n");
                        System.out.println("Total persons in Bank is " + global_person.GetTotalPerson());
                    }
                    else if(choice_person == 8) {

                        break;
                    }
                    else {
                        System.out.println("Invalid Input");
                    }
                }
            
            }
            else if(choice == 2){
                while(true){
                    ClientHeader();

                    int choice_person = sc.nextInt();

                    if(choice_person == 1){
                        System.out.println("\n\u001B[1m----------ADD CLIENT------------\n\u001B[0m");
                        System.out.print("If the associated person is already in the list, then person is added as a client.\n Enter the CNIC of the person :");
                        String cnic = sc.next();
                        Person temp = new Person();
                        temp = global_person.SearchPerson(cnic);
                        if(temp == null)
                        {
                            System.out.println("Error: The associated person is not found. Please add the person first.");
                            System.out.println("\n\u001B[1m----------ADD PERSON------------\u001B[0m");
                            System.out.print("Enter the name : ");
                            String name = sc.next();
                            System.out.print("Enter the CNIC : ");
                            String CNIC = sc.next();
                            System.out.print("Enter the Age : ");
                            int age = sc.nextInt();
                            System.out.print("Enter the Gender : ");
                            String gender = sc.next();
                            Person new_person = new Person(name, CNIC, age, gender);
                            global_person.AddPerson(new_person);
                            temp = new_person;
                        }
                        String accountNumber = global_client.generateClientId();
                        Client client = new Client(temp, accountNumber);
                        global_client.AddClient(client);
                    }
                    else if (choice_person == 2) {
                        System.out.println("\n\u001B[1m----------DELETE CLIENT------------\n\u001B[0m");
                        System.out.println("Enter the Client Id :");
                        String clientId = sc.next();
                        ArrayList<String> acc_Id = global_client.GetAllAccountId(clientId);
                        System.out.println(acc_Id);
                        for (String temp:acc_Id) {
                            global_account.DeleteAccount(temp);
                        }
                        global_client.DeleteClient(clientId);

                    }
                    else if (choice_person == 3) {
                        System.out.println("\n\u001B[1m----------UPADTE CLIENT INFORMATION------------\n\u001B[0m");
                        System.out.println("Enter the Client Id :");
                        String clientid = sc.next();
                        System.out.println("What do you want to update age/name/gender : ");
                        String field = sc.next();
                        System.out.println("Enter the new value : ");
                        String newvalue = sc.next();
                        String cnic = global_client.GetCnicByClientId(clientid);
                        global_client.updateClient(clientid,field.toLowerCase(),newvalue);
                        global_person.updatePerson(cnic,field.toLowerCase(),newvalue);
                    }
                    else if (choice_person == 4) {
                        System.out.println("\n\u001B[1m----------SHOW ALL CLIENT INFORMATION------------\n\u001B[0m");
                        global_client.ShowAllClient();
                    }
                    else if (choice_person == 5) {
                        System.out.println("\n\u001B[1m----------VIEW CLIENT ACCOUNT------------\n\u001B[0m");
                        System.out.println("Enter the client Id : ");
                        String clientId = sc.next();
                        global_client.GetAllClientAccount(clientId);
                    }
                    else if (choice_person == 6) {
                        System.out.println("\n\u001B[1m----------TOTAL CLIENTS IN BANK------------\n\u001B[0m");
                        System.out.println(global_client.GetTotalClient());
                    }
                    else if (choice_person == 7) {
                        System.out.println("\n\u001B[1m----------TOTAL BALANCE------------\n\u001B[0m");
                        System.out.println("Enter the client Id : ");
                        String clientId = sc.next();
                        System.out.println("Total balance in all accounts is : "+global_client.GetTotalBalance(clientId));
                    }
                    else if(choice_person == 8){
                        break;
                    }
                    else {
                        System.out.println("INVALID CHOICE");
                    }
                }
            }
            else if(choice == 3){
                while(true){
                    AccountHeader();
                    int choice_person = sc.nextInt();

                    if(choice_person == 1) {
                        System.out.println("\n\u001B[1m----------ADD ACCOUNT------------\n\u001B[0m");
                        System.out.println("Enter the Client Id :");
                        String clientId = sc.next();
                        Client client;
                        client = global_client.SearchClient(clientId);
                        if(client == null)
                        {
                            System.out.println("Client not Found");
                        }
                        else
                        {
                            System.out.println(""" 
                                Select the Account Type
                                1 - \u001B[1mSavings Account\u001B[0m: For saving money with potential interest earnings.
                                2 - \u001B[1mChecking Account\u001B[0m: For day-to-day transactions.
                                3 - \u001B[1mCredit Card Account\u001B[0m: For credit transactions with a predefined credit limit.
                                4 - \u001B[1mInvestment Account\u001B[0m: For managing investments such as stocks, bonds, etc.
                                5 - \u001B[1mLoan Account\u001B[0m: If the client has taken a loan"""
                            );
                            int option = sc.nextInt();
                            String Acc_type = null;
                            if(option == 1){ Acc_type = "Saving";}
                            else if (option == 2) { Acc_type = "checking";}
                            else if (option == 3) { Acc_type = "Credit";}
                            else if (option == 4) { Acc_type = "Investment";}
                            else if (option == 5) { Acc_type = "loan";}
                            else{Acc_type = "General";}
                            String acc_id = global_account.generateAccountId();
                            Account acc = new Account(Acc_type,acc_id,0,clientId);
                            global_account.AddAccount(acc);
                        }
                    }
                    else if (choice_person == 2) {
                        System.out.println("\n\u001B[1m----------DELETE ACCOUNT------------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        global_account.DeleteAccount(accId);
                    }
                    else if (choice_person == 3) {
                        System.out.println("\n\u001B[1m----------UPADTE ACCOUNT INFORMATION------------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        global_account.UpdateAccount(accId);
                    }
                    else if (choice_person == 4) {
                        System.out.println("\n\u001B[1m----------SHOW ALL ACCOUNT------------\n\u001B[0m");
                        global_account.ShowAllAccount();
                    }
                    else if (choice_person == 5) {
                        System.out.println("\n\u001B[1m----------SEARCH ACCOUNT BALANCE------------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        global_account.GetAccountBalance(accId);
                    }
                    else if(choice_person == 6) {
                        System.out.println("\n\u001B[1m----------VIEW ACCOUNT DETAILS------------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        System.out.println(global_account.SearchAccount(accId));
                    }
                    else if(choice_person == 7) {
                        System.out.println("\n\u001B[1m----------VIEW ACCOUNT HOLDERS------------\n\u001B[0m");
                        global_account.ViewAccountHolders();
                    }

                    else if(choice_person == 8) {
                        System.out.println("\n\u001B[1m----------WITHDRAW MONEY-----------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        System.out.println("Enter the Amount :");
                        double money = sc.nextDouble();
                        global_account.withdraw(accId,money);
                    }
                    else if(choice_person == 9) {
                        System.out.println("\n\u001B[1m----------DEPOSIT MONEY-----------\n\u001B[0m");
                        System.out.println("Enter the Account Id :");
                        String accId = sc.next();
                        System.out.println("Enter the Amount :");
                        double money = sc.nextDouble();
                        global_account.deposit(accId,money);
                    }
                    else if(choice_person == 10) {
                      break;
                    }
                    else {
                        System.out.println("\n\u001B[1m----------INVALID CHOICE------------\n\u001B[0m");
                    }
                }
            }
            else if(choice == 4){
                global_person.StoreIntoFile();
                global_client.StoreIntoFile();
                global_account.StoreIntoFile();
                System.out.println("\n\n\n\u001B[1m----------THANK YOU FOR USING MIRZA BANK MANAGEMENT SYSTEM------------\u001B[0m\n\n\n");
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
    }

    static void Header(){

        System.out.println("""
                \u001B[1m------------WELCOME TO MIRZA BANK MANAGEMENT SYSTEM-----------\n \n\u001B[0m 
                1 - Persons
                2 - Clients
                3 - Accounts
                4 - Exit
                Select your option :
                """);
    }

    static void PersonHeader(){
        System.out.println("\u001B[1m----------PERSONS DEPARTMENT------------\u001B[0m");
                    System.out.println("""
                    1 - Add Person
                    2 - Delete Person
                    3 - Update Person Information
                    4 - Show All Person
                    5 - Search Person By CNIC
                    6 - View Person Details
                    7 - Total Persons in Bank
                    8 - Exit
                        """);
    }

    static void ClientHeader(){
        System.out.println("\u001B[1m----------CLIENT DEPARTMENT------------\u001B[0m");
        System.out.println("""
                        1 - Add Client
                        2 - Delete Client
                        3 - Update Client Information
                        4 - Show All Client
                        5 - View Client Accounts
                        6 - Total Clients in Bank 
                        7- Total Balnace in all accounts                 
                        8 - Exit""");
    }

    static void AccountHeader(){
        System.out.println("\u001B[1m----------ACCOUNT DEPARTMENT------------\u001B[0m");
        System.out.println("""
            1 - Add Account
            2 - Delete Account
            3 - Update Account Information
            4 - Show All Account
            5 - Search Account Balance
            6 - View Account Details 
            7 - View Account Holders
            8 - Withdraw Money
            9 - Deposit Money
            10 - Exit"""
        );
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

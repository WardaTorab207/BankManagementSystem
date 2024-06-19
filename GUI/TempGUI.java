package GUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TempGUI {
    protected JLabel lbl_AccountNum,lbl_ClientId,lbl_balance,lbl_Heading,lbl_name,lbl_CNIC;
    protected JTextField  txt_AccountNum,txt_ClientId,txt_Balance,txt_name,txt_CNIC;
    protected JButton AddAccount,DeleteAccount,ShowAccountBalance,WithdrawMoney,ShowAlltransactions,DepositMoney,ViewAccount,BackButton,btn_addAccount,btn_deleteAccount,btn_viewAllDetails,btn_OkAdd,btn_OkDelete,ViewAllAccount,btn_showAccountBalance,btn_withdrawMoney,btn_DepositMoney;

    //Default Fonts
    Font ButtonsFont = new Font("Arial", Font.BOLD, 12);
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Font textFont = new Font("Arial", Font.BOLD, 15);

    protected static String TotalAccount;
    private int accountIdCounter = 0;

    public TempGUI(String logoPath) {
        Container container;
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Mirza Bank System / Account");
        ImageIcon logoIcon = new ImageIcon(logoPath);
        mainFrame.setIconImage(logoIcon.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(150, 50, 1000, 600);
        container = mainFrame.getContentPane();
        Color col = Color.gray;
        container.setBackground(col);
        container.setLayout(null);
        mainFrame.setResizable(false);

        lbl_Heading = new JLabel("<html><u>MIRZA BANK SYSTEM | ACCOUNT SECTION</u></html>");
        lbl_Heading.setBounds(315, 50, 600, 50);
        lbl_Heading.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_Heading.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Heading.setForeground(Color.BLACK);
        container.add(lbl_Heading);

        getTotalAccount();
        JLabel totalPerson = new JLabel("Total Accounts: " + TotalAccount);
        totalPerson.setBounds(30,145,170,30);
        container.add(totalPerson);
        totalPerson.setForeground(Color.BLACK);
        totalPerson.setHorizontalAlignment(SwingConstants.CENTER);
        Font totalPersonFont = new Font("Serif", Font.BOLD, 17);
        totalPerson.setFont(totalPersonFont);

        ImageIcon icon = new ImageIcon(myPath.logo1Path);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lbl_logo = new JLabel(scaledIcon);
        lbl_logo.setBounds(30, -5, 170, 170);
        container.add(lbl_logo);

        int arcSizeOfSideBarBtns = 30;

        AddAccount = createStyledButton("Add Account", 30, 200, 170, 30, arcSizeOfSideBarBtns);
        AddAccount.setFont(ButtonsFont);
        container.add(AddAccount);
        AddAccount.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                lbl_balance.setVisible(false);
                lbl_AccountNum.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_name.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_Balance.setVisible(false);
                txt_ClientId.setVisible(true);
                txt_AccountNum.setVisible(false);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");
                txt_name.setText("");
                txt_CNIC.setText("");

                txt_AccountNum.setEditable(false);
                txt_Balance.setEditable(true);
                txt_name.setEditable(false);
                txt_CNIC.setEditable(false);
                txt_ClientId.setEditable(true);


                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_OkAdd.setVisible(true);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(false);
            }
        });

        DeleteAccount = createStyledButton("Delete Account", 30, 240, 170, 30, arcSizeOfSideBarBtns);
        DeleteAccount.setFont(ButtonsFont);
        container.add(DeleteAccount);
        DeleteAccount.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_balance.setVisible(false);
                lbl_AccountNum.setVisible(true);
                lbl_CNIC.setVisible(false);
                lbl_name.setVisible(false);
                lbl_ClientId.setVisible(false);

                txt_Balance.setVisible(false);
                txt_ClientId.setVisible(false);
                txt_AccountNum.setVisible(true);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(false);
                txt_name.setEditable(false);
                txt_CNIC.setEditable(false);
                txt_ClientId.setEditable(false);

                btn_OkDelete.setVisible(true);
                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(false);
            }
        });

        ViewAccount = createStyledButton("View Account Details", 30, 280, 170, 30, arcSizeOfSideBarBtns);
        ViewAccount.setFont(ButtonsFont);
        container.add(ViewAccount);
        ViewAccount.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_balance.setVisible(false);
                lbl_AccountNum.setVisible(true);
                lbl_CNIC.setVisible(false);
                lbl_name.setVisible(false);
                lbl_ClientId.setVisible(false);

                txt_Balance.setVisible(false);
                txt_ClientId.setVisible(false);
                txt_AccountNum.setVisible(true);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(false);
                txt_name.setEditable(false);
                txt_CNIC.setEditable(false);
                txt_ClientId.setEditable(false);

                btn_viewAllDetails.setVisible(true);
                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(false);
            }
        });

        ViewAllAccount= createStyledButton("View All Accounts", 30, 320, 170, 30, arcSizeOfSideBarBtns);
        ViewAllAccount.setFont(ButtonsFont);
        container.add(ViewAllAccount);
        ViewAllAccount.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                new ShowAllAcountsGUI();
                lbl_balance.setVisible(false);
                lbl_AccountNum.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_Balance.setVisible(false);
                txt_ClientId.setVisible(true);
                txt_AccountNum.setVisible(false);
                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(true);

                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(false);
            }
        });


        ShowAccountBalance = createStyledButton("View Account Balance", 30, 360, 170, 30, arcSizeOfSideBarBtns);
        ShowAccountBalance.setFont(ButtonsFont);
        container.add(ShowAccountBalance);
        ShowAccountBalance.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                System.out.println("uhuhuh");
                lbl_balance.setVisible(true);
                lbl_AccountNum.setVisible(true);
                lbl_ClientId.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);

                txt_Balance.setVisible(true);
                txt_ClientId.setVisible(false);
                txt_AccountNum.setVisible(true);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                System.out.println("hjhuhuh");
                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(false);


                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_showAccountBalance.setVisible(true);
                btn_viewAllDetails.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(false);
            }
        });

        WithdrawMoney = createStyledButton("Withdraw Money", 30, 400, 170, 30, arcSizeOfSideBarBtns);
        WithdrawMoney.setFont(ButtonsFont);
        container.add(WithdrawMoney);
        WithdrawMoney.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_balance.setVisible(true);
                lbl_AccountNum.setVisible(true);
                lbl_ClientId.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);

                txt_Balance.setVisible(true);
                txt_ClientId.setVisible(false);
                txt_AccountNum.setVisible(true);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(true);
                txt_Balance.setToolTipText("Enter the amount you want to deposit.");

                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(true);
                btn_DepositMoney.setVisible(false);
            }
        });

        DepositMoney = createStyledButton("Deposit Money", 30, 440, 170, 30, arcSizeOfSideBarBtns);
        DepositMoney.setFont(ButtonsFont);
        container.add(DepositMoney);
        DepositMoney.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_balance.setVisible(true);
                lbl_AccountNum.setVisible(true);
                lbl_ClientId.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);

                txt_Balance.setVisible(true);
                txt_ClientId.setVisible(false);
                txt_AccountNum.setVisible(true);
                txt_name.setVisible(false);
                txt_CNIC.setVisible(false);

                txt_AccountNum.setText("");
                txt_Balance.setText("");
                txt_ClientId.setText("");

                txt_AccountNum.setEditable(true);
                txt_Balance.setEditable(true);
                txt_Balance.setToolTipText("Enter the amount you want to deposit.");

                btn_addAccount.setVisible(false);
                btn_deleteAccount.setVisible(false);
                btn_showAccountBalance.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_OkAdd.setVisible(false);
                btn_OkDelete.setVisible(false);
                btn_withdrawMoney.setVisible(false);
                btn_DepositMoney.setVisible(true);
            }
        });

        ShowAlltransactions = createStyledButton("Show All Transactions", 30, 480, 170, 30, arcSizeOfSideBarBtns);
        ShowAlltransactions.setFont(ButtonsFont);
        container.add(ShowAlltransactions);
        ShowAlltransactions.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new ShowAllTransactionGUI();
            }
        });

        BackButton = createStyledButton("Back", 30, 520, 170, 30, arcSizeOfSideBarBtns);
        BackButton.setFont(ButtonsFont);
        container.add(BackButton);
        BackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new BankGUI(logoPath);
            }
        });

        // Labels
        Color lbl_color = Color.BLACK;
        lbl_AccountNum = new JLabel("Account Number: ");
        lbl_AccountNum.setBounds(395, 200, 150, 30);
        container.add(lbl_AccountNum);
        lbl_AccountNum.setVisible(false);
        lbl_AccountNum.setForeground(lbl_color);
        lbl_AccountNum.setFont(labelFont);

        lbl_ClientId = new JLabel("Client ID : ");
        lbl_ClientId.setBounds(395, 250, 150, 30);
        container.add(lbl_ClientId);
        lbl_ClientId.setVisible(true);
        lbl_ClientId.setForeground(lbl_color);
        lbl_ClientId.setFont(labelFont);

        lbl_balance = new JLabel("Balance : ");
        lbl_balance.setBounds(395, 300, 150, 30);
        container.add(lbl_balance);
        lbl_balance.setVisible(false);
        lbl_balance.setForeground(lbl_color);
        lbl_balance.setFont(labelFont);

        lbl_name = new JLabel("Client Name: ");
        lbl_name.setBounds(395, 350, 150, 30);
        container.add(lbl_name);
        lbl_name.setVisible(false);
        lbl_name.setForeground(lbl_color);
        lbl_name.setFont(labelFont);

        lbl_CNIC = new JLabel("Client CNIC : ");
        lbl_CNIC.setBounds(395, 400, 150, 30);
        container.add(lbl_CNIC);
        lbl_CNIC.setVisible(false);
        lbl_CNIC.setForeground(lbl_color);
        lbl_CNIC.setFont(labelFont);


        // TextBoxex
        Color txtBackground = Color.decode("#e2dace");
        txt_AccountNum = new JTextField();
        txt_AccountNum.setBounds(535, 200, 300, 30);
        container.add(txt_AccountNum);
        txt_AccountNum.setVisible(false);
        txt_AccountNum.setMargin(new Insets(5, 5, 5, 5));
        txt_AccountNum.setBackground(txtBackground);
        txt_AccountNum.setFont(textFont);

        txt_ClientId = new JTextField();
        txt_ClientId.setBounds(535, 250, 300, 30);
        container.add(txt_ClientId);
        txt_ClientId.setVisible(true);
        txt_ClientId.setMargin(new Insets(5, 5, 5, 5));
        txt_ClientId.setBackground(txtBackground);
        txt_ClientId.setFont(textFont);

        txt_Balance = new JTextField();
        txt_Balance.setBounds(535, 300, 300, 30);
        container.add(txt_Balance);
        txt_Balance.setVisible(false);
        txt_Balance.setMargin(new Insets(5, 5, 5, 5));
        txt_Balance.setBackground(txtBackground);
        txt_Balance.setFont(textFont);

        txt_name = new JTextField();
        txt_name.setBounds(535, 350, 300, 30);
        container.add(txt_name);
        txt_name.setVisible(false);
        txt_name.setMargin(new Insets(5, 5, 5, 5));
        txt_name.setBackground(txtBackground);
        txt_name.setFont(textFont);

        txt_CNIC = new JTextField();
        txt_CNIC.setBounds(535, 400, 300, 30);
        container.add(txt_CNIC);
        txt_CNIC.setVisible(false);
        txt_CNIC.setBackground(txtBackground);
        txt_CNIC.setMargin(new Insets(5, 5, 5, 5));
        txt_CNIC.setFont(textFont);


        // Bottoms Buttons
        btn_addAccount = createStyledButton("Add Account", 640, 470, 200, 45, 30);
        btn_addAccount.setFont(new Font("Arial", Font.BOLD, 15));
        btn_addAccount.setVisible(false);
        container.add(btn_addAccount);
        btn_addAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String clientId = txt_ClientId.getText().trim();
                String accountId = txt_AccountNum.getText().trim();
                String balance = txt_Balance.getText().trim();
                String name = txt_name.getText().trim();
                String Cnic = txt_CNIC.getText().trim();

                if (!clientId.isEmpty() && !accountId.isEmpty() && !balance.isEmpty()) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(myPath.accountFilePath, true))) {
                        // Append the new account data to the file
                        String newAccountData = accountId + "," + clientId + "," + name + ","+ Cnic +","+ balance;
                        bw.write(newAccountData);
                        bw.newLine();

                        JOptionPane.showMessageDialog(container, "Account added successfully. AccountID: " + accountId);

                        txt_ClientId.setText("");
                        txt_AccountNum.setText("");
                        txt_Balance.setText("");
                        txt_name.setText("");
                        txt_CNIC.setText("");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please fill in all fields to add an account.");
                }
            }
        });

        btn_deleteAccount = createStyledButton("Delete Account", 640, 470, 200, 45, 30);
        btn_deleteAccount.setFont(new Font("Arial", Font.BOLD, 15));
        btn_deleteAccount.setVisible(false);
        container.add(btn_deleteAccount);
        btn_deleteAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the AccountID to delete
                String accountIdToDelete = txt_AccountNum.getText().trim();

                if (!accountIdToDelete.isEmpty()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                        // Create a temporary file to write the updated data
                        File tempFile = new File(myPath.accountFileTempPath);
                        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

                        String line;
                        boolean accountFound = false;

                        // Read each line from the original file
                        while ((line = br.readLine()) != null) {
                            // Split the line to extract the account ID
                            String[] parts = line.split(",");
                            if (parts.length > 0) {
                                String existingAccountId = parts[0].trim();

                                // Check if the current line contains the account to delete
                                if (existingAccountId.equals(accountIdToDelete)) {
                                    accountFound = true;
                                } else {
                                    // Write the line to the temporary file
                                    bw.write(line);
                                    bw.newLine();
                                }
                            }
                        }

                        br.close();
                        bw.close();

                        // Delete the original file
                        File originalFile = new File(myPath.accountFilePath);
                        if (originalFile.delete()) {
                            // Rename the temporary file to the original file name
                            if (!tempFile.renameTo(originalFile)) {
                                System.out.println("Error renaming the temporary file.");
                            }
                        } else {
                            System.out.println("Error deleting the original file.");
                        }


                        // Display appropriate message based on whether the account was found and deleted
                        if (accountFound) {
                            txt_ClientId.setText("");
                            txt_AccountNum.setText("");
                            txt_name.setText("");
                            txt_Balance.setText("");
                            txt_CNIC.setText("");
                            JOptionPane.showMessageDialog(container, "Account with AccountID " + accountIdToDelete + " deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(container, "Account with AccountID " + accountIdToDelete + " not found.");
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please select an AccountID to delete.");
                }

                // Update the total account count
                getTotalAccount();
                totalPerson.setText("Total Accounts: " + TotalAccount);
            }
        });

        btn_showAccountBalance = createStyledButton("Show Account Balance", 640, 470, 200, 45, 30);
        btn_showAccountBalance.setFont(new Font("Arial", Font.BOLD, 15));
        btn_showAccountBalance.setVisible(false);
        container.add(btn_showAccountBalance);
        btn_showAccountBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the AccountID to fetch balance
                String accountId = txt_AccountNum.getText().trim();

                if (!accountId.isEmpty()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                        String line;

                        // Read each line from the original file
                        while ((line = br.readLine()) != null) {
                            // Split the line to extract the account ID and balance
                            String[] parts = line.split(",");
                            if (parts.length > 0) {
                                String existingAccountId = parts[0].trim();

                                // Check if the current line contains the account ID to fetch balance
                                if (existingAccountId.equals(accountId)) {
                                    txt_Balance.setText(parts[4].trim());
                                    txt_AccountNum.setText(parts[0].trim());
                                    return; // Exit the loop after finding the matching account ID
                                }
                            }
                        }

                        // Display a message if the account ID is not found
                        JOptionPane.showMessageDialog(container, "Account with AccountID " + accountId + " not found.");
                    } catch (IOException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    } catch (NumberFormatException ex) {
                        // Handle the case where balance is not a valid number in the file
                        JOptionPane.showMessageDialog(container, "Error: Invalid balance format for AccountID " + accountId);
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please enter an AccountID to fetch balance.");
                }
            }
        });


        btn_viewAllDetails = createStyledButton("View Account Details", 640, 470, 200, 45, 30);
        btn_viewAllDetails.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_viewAllDetails);
        btn_viewAllDetails.setVisible(false);
        btn_viewAllDetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredAccountId = txt_AccountNum.getText().trim();
                    Boolean IsFound = false;
                    // Check if CNIC is not empty
                    if (!enteredAccountId.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String accountId = data[0].trim();

                                if (enteredAccountId.equals(accountId)) {
                                    IsFound = true;
                                    txt_name.setText(data[2].trim()); // Name
                                    txt_CNIC.setText(data[3].trim());
                                    txt_AccountNum.setText(accountId);
                                    txt_ClientId.setText(data[1].trim());
                                    txt_Balance.setText(data[4].trim());

                                    txt_Balance.setVisible(true);
                                    txt_CNIC.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_ClientId.setVisible(true);

                                    lbl_balance.setVisible(true);
                                    lbl_name.setVisible(true);
                                    lbl_ClientId.setVisible(true);
                                    lbl_CNIC.setVisible(true);


                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                            if (!IsFound)
                            {
                                JOptionPane.showMessageDialog(container, "Account Id don't exist");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when CNIC is empty
                        JOptionPane.showMessageDialog(container, "Please enter a Account ID to view details.");
                    }
                }
                getTotalAccount();
                totalPerson.setText("Total Accounts: " + TotalAccount);
            }

        });

        btn_withdrawMoney = createStyledButton("Withdraw Money", 640, 470, 200, 45, 30);
        btn_withdrawMoney.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_withdrawMoney);
        btn_withdrawMoney.setVisible(false);
        btn_withdrawMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get Account ID and Withdraw Amount from the user input
                String enteredAccountId = txt_AccountNum.getText().trim();
                String withdrawAmountStr = txt_Balance.getText().trim();

                if (!enteredAccountId.isEmpty() && !withdrawAmountStr.isEmpty()) {
                    double withdrawAmount = Double.parseDouble(withdrawAmountStr);
                    double currentBalance = 0; // Initialize currentBalance

                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                        String line;
                        boolean isFound = false;
                        List<String> updatedLines = new ArrayList<>();

                        // Read each line from the original file
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(",");
                            String accountId = data[0].trim();

                            if (enteredAccountId.equals(accountId)) {
                                isFound = true;

                                // Extract current balance
                                String balanceString = data[4].trim();
                                balanceString = balanceString.replace("Rs. ", "").trim();
                                currentBalance = Double.parseDouble(balanceString); // Update currentBalance

                                // Check if there is enough balance for withdrawal
                                if (withdrawAmount <= currentBalance) {
                                    // Perform withdrawal
                                    double newBalance = currentBalance - withdrawAmount;

                                    // Update the balance in the UI
                                    txt_Balance.setText(String.valueOf(newBalance));

                                    // Update the balance in the data array
                                    data[4] = "Rs. " + String.valueOf(newBalance);

                                    // Display a success message
                                    JOptionPane.showMessageDialog(container, "Withdrawal successful. New balance: Rs. " + newBalance);
                                } else {
                                    // Display an error message if there is not enough balance for withdrawal
                                    JOptionPane.showMessageDialog(container, "Insufficient balance for withdrawal.");
                                }
                            }

                            // Add the line (whether modified or not) to the list
                            updatedLines.add(String.join(",", data));
                        }

                        if (!isFound) {
                            JOptionPane.showMessageDialog(container, "Account ID does not exist.");
                        }

                        // Write the updated lines back to the original file
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(myPath.accountFilePath))) {
                            for (String updatedLine : updatedLines) {
                                bw.write(updatedLine);
                                bw.newLine();
                            }
                        }

                        // Save transaction details to TRANSACTIONFILE
                        saveTransactionDetails(enteredAccountId, String.valueOf(currentBalance), "Withdraw", String.valueOf(withdrawAmount), String.valueOf(currentBalance - withdrawAmount));

                    } catch (IOException | NumberFormatException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please enter both Account ID and Withdraw Amount.");
                }
            }
        });


        btn_DepositMoney = createStyledButton("Deposit Money", 640, 470, 200, 45, 30);
        btn_DepositMoney.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_DepositMoney);
        btn_DepositMoney.setVisible(false);
        btn_DepositMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get Account ID and Deposit Amount from the user input
                String enteredAccountId = txt_AccountNum.getText().trim();
                String depositAmountStr = txt_Balance.getText().trim();

                if (!enteredAccountId.isEmpty() && !depositAmountStr.isEmpty()) {
                    double depositAmount = Double.parseDouble(depositAmountStr);
                    double currentBalance = 0; // Initialize currentBalance

                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                        String line;
                        boolean isFound = false;
                        List<String> updatedLines = new ArrayList<>();

                        // Read each line from the original file
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(",");
                            String accountId = data[0].trim();

                            if (enteredAccountId.equals(accountId)) {
                                isFound = true;

                                // Extract current balance
                                String balanceString = data[4].trim();
                                balanceString = balanceString.replace("Rs. ", "").trim();
                                currentBalance = Double.parseDouble(balanceString); // Update currentBalance

                                // Perform deposit
                                double newBalance = currentBalance + depositAmount;

                                // Update the balance in the UI
                                txt_Balance.setText(String.valueOf(newBalance));

                                // Update the balance in the data array
                                data[4] = "Rs. " + String.valueOf(newBalance);

                                // Display a success message
                                JOptionPane.showMessageDialog(container, "Deposit successful. New balance: Rs. " + newBalance);
                            }

                            // Add the line (whether modified or not) to the list
                            updatedLines.add(String.join(",", data));
                        }

                        if (!isFound) {
                            JOptionPane.showMessageDialog(container, "Account ID does not exist.");
                        }

                        // Write the updated lines back to the original file
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(myPath.accountFilePath))) {
                            for (String updatedLine : updatedLines) {
                                bw.write(updatedLine);
                                bw.newLine();
                            }
                        }

                        // Save transaction details to TRANSACTIONFILE
                        saveTransactionDetails(enteredAccountId, String.valueOf(currentBalance), "Deposit", String.valueOf(depositAmount), String.valueOf(currentBalance + depositAmount));

                    } catch (IOException | NumberFormatException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please enter both Account ID and Deposit Amount.");
                }
            }
        });

        btn_OkAdd = createStyledButton("OK", 640, 470, 200, 45, 30);
        btn_OkAdd.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_OkAdd);
        btn_OkAdd.setVisible(true);
        btn_OkAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredClientId = txt_ClientId.getText().trim();
                    Boolean IsFound = false;
                    // Check if CNIC is not empty
                    if (!enteredClientId.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String ClientIdFromFile = data[0].trim();

                                if (enteredClientId.equals(ClientIdFromFile)) {
                                    IsFound = true;
                                    String accountId = initializeAccountIdCounter();
                                    txt_name.setText(data[1].trim()); // Name
                                    txt_CNIC.setText(data[2].trim());
                                    txt_AccountNum.setText(accountId);
                                    txt_Balance.setText("Rs. 0.0");

                                    txt_Balance.setVisible(true);
                                    txt_CNIC.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_AccountNum.setVisible(true);

                                    lbl_balance.setVisible(true);
                                    lbl_name.setVisible(true);
                                    lbl_AccountNum.setVisible(true);
                                    lbl_CNIC.setVisible(true);

                                    btn_OkAdd.setVisible(false);
                                    btn_addAccount.setVisible(true);

                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                            if(!IsFound)
                            {
                                JOptionPane.showMessageDialog(container, "Account Id don't exist");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when CNIC is empty
                        JOptionPane.showMessageDialog(container, "Please enter a Account ID to view details.");
                    }
                }
                getTotalAccount();
                totalPerson.setText("Total Accounts: " + TotalAccount);
            }

        });

        btn_OkDelete = createStyledButton("OK", 640, 470, 200, 45, 30);
        btn_OkDelete.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_OkDelete);
        btn_OkDelete.setVisible(false);
        btn_OkDelete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredAccountId = txt_AccountNum.getText().trim();
                    Boolean IsFound = false;
                    // Check if CNIC is not empty
                    if (!enteredAccountId.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String accountId = data[0].trim();

                                if (enteredAccountId.equals(accountId)) {
                                    IsFound = true;
                                    txt_name.setText(data[2].trim()); // Name
                                    txt_CNIC.setText(data[3].trim());
                                    txt_AccountNum.setText(accountId);
                                    txt_ClientId.setText(data[1].trim());
                                    txt_Balance.setText(data[4].trim());

                                    txt_Balance.setVisible(true);
                                    txt_CNIC.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_ClientId.setVisible(true);

                                    lbl_balance.setVisible(true);
                                    lbl_name.setVisible(true);
                                    lbl_ClientId.setVisible(true);
                                    lbl_CNIC.setVisible(true);

                                    btn_OkDelete.setVisible(false);
                                    btn_deleteAccount.setVisible(true);

                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                            if(!IsFound)
                            {
                                JOptionPane.showMessageDialog(container, "Account Id don't exist");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when CNIC is empty
                        JOptionPane.showMessageDialog(container, "Please enter a Account ID to view details.");
                    }
                }
                getTotalAccount();
                totalPerson.setText("Total Accounts: " + TotalAccount);
            }

        });

        // Signature Label
        JLabel lbl = new JLabel("Developed By Computer Engineer Warda Mirza 👩🏼‍💻👍🏼✨😎🥱");
        lbl.setBounds(550, 540, 500, 20);
        lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
        lbl.setForeground(Color.BLACK);
        container.add(lbl);

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(myPath.accountBackground);
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        backgroundLabel.transferFocusBackward();
        container.add(backgroundLabel);

        mainFrame.setVisible(true);

    }

    private void saveTransactionDetails(String accountId, String previousAmount, String transactionType, String transactionAmount, String newBalance) {
        String transactionDate = getCurrentDate();
        String transactionDay = getCurrentDay();
        String transactionTime = getCurrentTime();

        String transactionDetails = String.format("%s,%s,%s,%s,%s,%s,%s", transactionDate, transactionDay, transactionTime, accountId, previousAmount, transactionType, transactionAmount, newBalance);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(myPath.transactionFilePath, true))) {
            bw.write(transactionDetails);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public static String getCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

        return dayOfWeek.toString();
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    public static String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return currentTime.format(formatter);
    }
    
    public static void getTotalAccount() {
        int totalPersons = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
            // Read each line from the file
            while (br.readLine() != null) {
                totalPersons++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        // Convert the totalPersons to a string and return
        TotalAccount = Integer.toString(totalPersons);
        System.out.println(totalPersons);
    }
    
    private String initializeAccountIdCounter() {
        try (Scanner scanner = new Scanner(new File(myPath.accountFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String accountIdPart = parts[0];
                    if (accountIdPart.matches("AC\\d+")) {
                        int accountId = Integer.parseInt(accountIdPart.substring(2));
                        accountIdCounter = Math.max(accountIdCounter, accountId);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            // Ignore if the file doesn't exist
        }
        accountIdCounter++;
        System.out.println("AC" + String.format("%03d", accountIdCounter));
        return "AC" + String.format("%03d", accountIdCounter);
    }

    private static JButton createStyledButton(String text, int x, int y, int width, int height, int arcSize) {
        GradientButton button = new GradientButton(text, arcSize);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new HoverMouseListener(button));

        return button;
    }

    private static class HoverMouseListener extends MouseAdapter {
        private final GradientButton button;
        private final Color defaultStartColor;
        private final Color defaultEndColor;
        private final Color defaultTextColor;

        HoverMouseListener(GradientButton button) {
            this.button = button;
            this.defaultStartColor = button.getStartColor();
            this.defaultEndColor = button.getEndColor();
            this.defaultTextColor = button.getTextColor();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Reverse the gradient colors and change text color on hover
            button.setStartColor(defaultEndColor);
            button.setEndColor(defaultStartColor);
            button.setTextColor(defaultStartColor);
            button.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Restore the default colors on exit
            button.setStartColor(defaultStartColor);
            button.setEndColor(defaultEndColor);
            button.setTextColor(defaultTextColor);
            button.repaint();
        }
    }

    private static class GradientButton extends JButton {
        private int arcSize;
        private Color startColor;
        private Color endColor;
        private Color textColor;

        public GradientButton(String text, int arcSize) {
            super(text);
            this.arcSize = arcSize;
            this.startColor = Color.decode("#fced8b");
            this.endColor = Color.decode("#7e5111");
            this.textColor = Color.decode("#1E1D1C");
            setContentAreaFilled(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            // Create a gradient paint
            GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, 0, height, endColor);

            // Apply the gradient paint to the button's background
            g2d.setPaint(gradientPaint);

            // Draw the rounded rectangle (you can customize the corner radius)
            g2d.fill(new RoundRectangle2D.Double(0, 0, width, height, arcSize, arcSize));

            // Draw the button's text with the specified color
            g2d.setColor(textColor);
            g2d.drawString(getText(), (width - g2d.getFontMetrics().stringWidth(getText())) / 2,
                    (height - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent());

            g2d.dispose();
        }

        public Color getStartColor() {
            return startColor;
        }

        public void setStartColor(Color startColor) {
            this.startColor = startColor;
        }

        public Color getEndColor() {
            return endColor;
        }

        public void setEndColor(Color endColor) {
            this.endColor = endColor;
        }

        public Color getTextColor() {
            return textColor;
        }

        public void setTextColor(Color textColor) {
            this.textColor = textColor;
        }
    }
}

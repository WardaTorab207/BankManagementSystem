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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientGUI{

    protected JButton AddClient,DeleteClient,ViewClientAccounts,UpdateClient,ViewClientDetails,ShowAllClient,btn_okUpdate,SearchClient,TotalBalance,BackButton,btn_addClient,btn_deleteClient,btn_viewClientdetail,btn_searchClient,btn_updateClient,btn_Ok,btn_totalBalance;
    protected JLabel lbl_name,lbl_CNIC,lbl_age,lbl_gender,lbl_Heading,lbl_ClientId;
    protected JTextField  txt_name,txt_CNIC,txt_age,txt_gender,txt_Client;

    private static int clientIdCounter = 0;

    protected static String TotalClients;
    Font ButtonsFont = new Font("Arial", Font.BOLD, 12);
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Font textFont = new Font("Arial", Font.BOLD, 15);

    public ClientGUI(String logoPath){
        Container container;
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Mirza Bank System / Client");
        ImageIcon logoIcon = new ImageIcon(logoPath);
        mainFrame.setIconImage(logoIcon.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(150, 50, 1000, 600);
        container = mainFrame.getContentPane();
        Color col = Color.gray;
        container.setBackground(col);
        container.setLayout(null);
        mainFrame.setResizable(false);

        lbl_Heading = new JLabel("<html><u>MIRZA BANK SYSTEM | CLIENT SECTION</u></html>");
        lbl_Heading.setBounds(315, 50, 600, 50);
        lbl_Heading.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_Heading.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Heading.setForeground(Color.WHITE);
        container.add(lbl_Heading);

        getTotalClients();
        JLabel totalPerson = new JLabel("Total Client : " + TotalClients);
        totalPerson.setBounds(30,145,170,30);
        container.add(totalPerson);
        totalPerson.setForeground(Color.WHITE);
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

        AddClient = createStyledButton("Add Client", 30, 200, 170, 30, arcSizeOfSideBarBtns);
        container.add(AddClient);
        AddClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(true);
                lbl_ClientId.setVisible(false);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(false);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");


                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);
                txt_Client.setEditable(false);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(true);
                btn_totalBalance.setVisible(false);
            }
        });

        DeleteClient = createStyledButton("Delete Client", 30, 240, 170, 30, arcSizeOfSideBarBtns);
        container.add(DeleteClient);
        DeleteClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(true);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(false);
                btn_totalBalance.setVisible(false);
            }
        });

        UpdateClient = createStyledButton("Update Client", 30, 280, 170, 30, arcSizeOfSideBarBtns);
        container.add(UpdateClient);
        UpdateClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(false);
                btn_okUpdate.setVisible(true);
                btn_totalBalance.setVisible(false);
            }
        });

        ViewClientDetails = createStyledButton("View Client Detail", 30, 320, 170, 30, arcSizeOfSideBarBtns);
        ViewClientDetails.setVisible(true);
        container.add(ViewClientDetails);
        ViewClientDetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(true);
                btn_Ok.setVisible(false);
                btn_okUpdate.setVisible(true);
                btn_totalBalance.setVisible(false);
            }
        });

        ShowAllClient = createStyledButton("Show All Client", 30, 360, 170, 30, arcSizeOfSideBarBtns);
        container.add(ShowAllClient);
        ShowAllClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(false);
                new ShowAllClientGUI();
                btn_totalBalance.setVisible(false);
            }
        });


        SearchClient = createStyledButton("Search Client", 30, 400, 170, 30, arcSizeOfSideBarBtns);
        container.add(SearchClient);
        SearchClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(true);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(false);
                btn_totalBalance.setVisible(false);
            }
        });

        ViewClientAccounts = createStyledButton("View Client Accounts", 30, 440, 170, 30, arcSizeOfSideBarBtns);
        container.add(ViewClientAccounts);
        ViewClientAccounts.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new ShowAllAcountsGUI();
            }
        });


        TotalBalance = createStyledButton("Total Balance in all Account", 30, 480, 170, 30, arcSizeOfSideBarBtns);
        container.add(TotalBalance);
        TotalBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(false);
                lbl_ClientId.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(false);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_Client.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addClient.setVisible(false);
                btn_deleteClient.setVisible(false);
                btn_searchClient.setVisible(false);
                btn_updateClient.setVisible(false);
                btn_viewClientdetail.setVisible(false);
                btn_Ok.setVisible(false);
                btn_totalBalance.setVisible(true);
//                // Get the Client ID to calculate total balance
//                String clientId = txt_CNIC.getText().trim();
//
//                if (!clientId.isEmpty()) {
//                    // Calculate the total balance for the given Client ID
//                    double totalBalance = calculateTotalBalance(clientId);
//
//                    // Display a pop-up message with the total balance
//                    JOptionPane.showMessageDialog(container, "Total Balance for Client ID " + clientId + ": Rs. " + totalBalance);
//                } else {
//                    // Display an error message if Client ID is empty
//                    JOptionPane.showMessageDialog(container, "Please enter a Client ID to calculate the total balance.");
//                }
            }
        });


        BackButton = createStyledButton("Back", 30, 520, 170, 30, arcSizeOfSideBarBtns);
        container.add(BackButton);
        BackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new BankGUI(logoPath);
            }
        });

        // Labels
        Color lbl_color = Color.WHITE;
        lbl_name = new JLabel("Enter Name: ");
        lbl_name.setBounds(395, 300, 150, 30);
        container.add(lbl_name);
        lbl_name.setVisible(false);
        lbl_name.setForeground(lbl_color);
        lbl_name.setFont(labelFont);

        lbl_CNIC = new JLabel("Enter CNIC: ");
        lbl_CNIC.setBounds(395, 200, 150, 30);
        container.add(lbl_CNIC);
        lbl_CNIC.setForeground(lbl_color);
        lbl_CNIC.setFont(labelFont);

        lbl_ClientId = new JLabel("Client ID: ");
        lbl_ClientId.setBounds(395, 250, 150, 30);
        container.add(lbl_ClientId);
        lbl_ClientId.setForeground(lbl_color);
        lbl_ClientId.setVisible(false);
        lbl_ClientId.setFont(labelFont);

        lbl_age = new JLabel("Enter Age: ");
        lbl_age.setBounds(395, 350, 150, 30);
        container.add(lbl_age);
        lbl_age.setVisible(false);
        lbl_age.setForeground(lbl_color);
        lbl_age.setFont(labelFont);

        lbl_gender = new JLabel("Enter Gender: ");
        lbl_gender.setBounds(395, 400, 150, 30);
        container.add(lbl_gender);
        lbl_gender.setForeground(lbl_color);
        lbl_gender.setVisible(false);
        lbl_gender.setFont(labelFont);

        // TextBoxex
        Color txtBackground = Color.decode("#ffffff");
        txt_name = new JTextField();
        txt_name.setBounds(535, 300, 300, 30);
        container.add(txt_name);
        txt_name.setVisible(false);
        txt_name.setMargin(new Insets(5, 5, 5, 5));
        txt_name.setBackground(txtBackground);
        txt_name.setFont(textFont);

        txt_CNIC = new JTextField();
        txt_CNIC.setBounds(535, 200, 300, 30);
        txt_CNIC.setBackground(txtBackground);
        container.add(txt_CNIC);
        txt_CNIC.setMargin(new Insets(5, 5, 5, 5));
        txt_CNIC.setFont(textFont);

        txt_Client = new JTextField();
        txt_Client.setBounds(535, 250, 300, 30);
        container.add(txt_Client);
        txt_Client.setVisible(false);
        txt_Client.setMargin(new Insets(5, 5, 5, 5));
        txt_Client.setBackground(txtBackground);
        txt_Client.setFont(textFont);

        txt_age = new JTextField();
        txt_age.setBounds(535, 350, 300, 30);
        container.add(txt_age);
        txt_age.setVisible(false);
        txt_age.setMargin(new Insets(5, 5, 5, 5));
        txt_age.setBackground(txtBackground);
        txt_age.setFont(textFont);

        txt_gender = new JTextField();
        txt_gender.setBounds(535, 400, 300, 30);
        container.add(txt_gender);
        txt_gender.setVisible(false);
        txt_gender.setMargin(new Insets(5, 5, 5, 5));
        txt_gender.setBackground(txtBackground);
        txt_gender.setFont(textFont);


        // Bottoms Buttons
        btn_addClient = createStyledButton("Add Client", 640, 470, 200, 45, 30);
        btn_addClient.setFont(new Font("Arial", Font.BOLD, 15));
        btn_addClient.setVisible(false);
        container.add(btn_addClient);
        btn_addClient.addActionListener(new ActionListener()
        {
                public void actionPerformed(ActionEvent e) {

                    String name = txt_name.getText().trim();
                    String cnic = txt_CNIC.getText().trim();
                    String age = txt_age.getText().trim();
                    String gender = txt_gender.getText().trim();
                    String clientId = txt_Client.getText().trim();
                    // Validate that all fields are filled
                    if (!name.isEmpty() && !cnic.isEmpty() && !age.isEmpty() && !gender.isEmpty()) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(myPath.clientFilePath, true))) {

                            // Append the new client data to the file
                            String newClientData = clientId + "," + name + "," + cnic + "," + age + "," + gender;
                            bw.write(newClientData);
                            bw.newLine();

                            // Display a success message or take appropriate action
                            JOptionPane.showMessageDialog(container, "Client added successfully. ClientID: " + clientId);

                            // Clear text fields after adding the client
                            txt_name.setText("");
                            txt_CNIC.setText("");
                            txt_age.setText("");
                            txt_gender.setText("");
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when any field is empty
                        JOptionPane.showMessageDialog(container, "Please fill in all fields to add a client.");
                    }
                    getTotalClients();
                    totalPerson.setText("Total Client : " + TotalClients);
                }
        });

        btn_deleteClient = createStyledButton("Delete Client", 640, 470, 200, 45, 30);
        btn_deleteClient.setFont(new Font("Arial", Font.BOLD, 15));
        btn_deleteClient.setVisible(false);
        container.add(btn_deleteClient);
        btn_deleteClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // Get the ClientID to delete
                String clientIdToDelete = txt_Client.getText();

                if (clientIdToDelete != null && !clientIdToDelete.isEmpty()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
                        // Create a temporary file to write the updated data
                        File tempFile = new File(myPath.clientFileTempPath);
                        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

                        String line;
                        boolean clientFound = false;

                        // Read each line from the original file
                        while ((line = br.readLine()) != null) {
                            // Split the line to extract the client ID
                            String[] parts = line.split(",");
                            if (parts.length > 0) {
                                String existingClientId = parts[0].trim();

                                // Check if the current line contains the client to delete
                                if (existingClientId.equals(clientIdToDelete)) {
                                    clientFound = true;
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
                        File originalFile = new File(myPath.clientFilePath);
                        if (originalFile.delete()) {
                            // Rename the temporary file to the original file name
                            if (!tempFile.renameTo(originalFile)) {
                                System.out.println("Error renaming the temporary file.");
                            }
                        } else {
                            System.out.println("Error deleting the original file.");
                        }

                        // Display appropriate message based on whether the client was found and deleted
                        if (clientFound) {
                            JOptionPane.showMessageDialog(container, "Client with ClientID " + clientIdToDelete + " deleted successfully.");
                            txt_Client.setText("");
                        } else {
                            JOptionPane.showMessageDialog(container, "Client with ClientID " + clientIdToDelete + " not found.");
                        }

                        // Update the total clients count
                        getTotalClients();
                        totalPerson.setText("Total Client : " + TotalClients);

                    } catch (IOException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    JOptionPane.showMessageDialog(container, "Please enter a valid ClientID.");
                }
            }
        });

        btn_searchClient = createStyledButton("Search Client", 640, 470, 200, 45, 30);
        btn_searchClient.setFont(new Font("Arial", Font.BOLD, 15));
        btn_searchClient.setVisible(false);
        container.add(btn_searchClient);
        btn_searchClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                String enteredClientId = txt_Client.getText().trim();

                if (!enteredClientId.isEmpty()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
                        String clientDetails = getClientDetails(enteredClientId, br);

                        if (clientDetails != null) {
                            String message = "Client Found:\n" + clientDetails;
                            JOptionPane.showMessageDialog(container, message, "Client Found", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(container, "Client with ClientID " + enteredClientId + " does not exist.", "Client Not Found", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    // Display a message or take appropriate action when ClientID is empty
                    JOptionPane.showMessageDialog(container, "Please enter a ClientID to search for a client.");
                }
                getTotalClients();
                totalPerson.setText("Total Client : " + TotalClients);
            }
        });

        btn_viewClientdetail = createStyledButton("View Client Details", 640, 470, 200, 45, 30);
        btn_viewClientdetail.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_viewClientdetail);
        btn_viewClientdetail.setVisible(false);
        btn_viewClientdetail.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                {
                    String enteredClientId = txt_Client.getText().trim();

                    // Check if ClientID is not empty
                    if (!enteredClientId.isEmpty()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String clientIdFromFile = data[0].trim(); // assuming ClientID is at index 0

                                if (enteredClientId.equals(clientIdFromFile)) {
                                    // Match found, populate text fields and make them non-editable
                                    txt_name.setText(data[1].trim()); // Name
                                    txt_CNIC.setText(data[2].trim()); // CNIC
                                    txt_age.setText(data[3].trim()); // Age
                                    txt_gender.setText(data[4].trim()); // Gender

                                    // Show labels and text fields for name, CNIC, age, and gender
                                    lbl_name.setVisible(true);
                                    lbl_CNIC.setVisible(true);
                                    lbl_age.setVisible(true);
                                    lbl_gender.setVisible(true);

                                    txt_name.setVisible(true);
                                    txt_CNIC.setVisible(true);
                                    txt_age.setVisible(true);
                                    txt_gender.setVisible(true);


                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when ClientID is empty
                        JOptionPane.showMessageDialog(container, "Please enter a ClientID to view details.");
                    }
                }
                getTotalClients();
                totalPerson.setText("Total Client : " + TotalClients);
            }

        });

        btn_Ok = createStyledButton("OK", 640, 470, 200, 45, 30);
        btn_Ok.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_Ok);
        btn_Ok.setVisible(true);
        btn_Ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredCNIC = txt_CNIC.getText().trim();
                    String clientId = initializeClientIdCounter();
                    // Check if CNIC is not empty
                    if (!enteredCNIC.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.personFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String cnicFromFile = data[1].trim(); // assuming CNIC is at index 1

                                if (enteredCNIC.equals(cnicFromFile)) {
                                    txt_name.setText(data[0].trim()); // Name
                                    txt_age.setText(data[2].trim()); // Age
                                    txt_gender.setText(data[3].trim()); // Gender
                                    txt_Client.setText(clientId.trim());

                                        lbl_name.setVisible(true);
                                        lbl_age.setVisible(true);
                                        lbl_gender.setVisible(true);
                                        lbl_ClientId.setVisible(true);

                                    txt_name.setVisible(true);
                                    txt_age.setVisible(true);
                                    txt_gender.setVisible(true);
                                    txt_Client.setVisible(true);

                                    btn_Ok.setVisible(false);
                                    btn_addClient.setVisible(true);

                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when CNIC is empty
                        JOptionPane.showMessageDialog(container, "Please enter a CNIC to view details.");
                    }
                }
                getTotalClients();
                totalPerson.setText("Total Client : " + TotalClients);
            }

        });

        btn_totalBalance = createStyledButton("Show Balance", 640, 470, 200, 45, 30);
        btn_totalBalance.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_totalBalance);
        btn_totalBalance.setVisible(true);
        btn_totalBalance.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    //Get the Client ID to calculate total balance
                    String clientId = txt_Client.getText().trim();
                    System.out.println(clientId);
                    if (!clientId.isEmpty()) {
                        // Calculate the total balance for the given Client ID
                        double totalBalance = calculateTotalBalance(clientId);
                        System.out.println(totalBalance);
                        // Display a pop-up message with the total balance
                        JOptionPane.showMessageDialog(container, "Total Balance for Client ID " + clientId + ": Rs. " + totalBalance);
                    } else {
                        // Display an error message if Client ID is empty
                        JOptionPane.showMessageDialog(container, "Please enter a Client ID to calculate the total balance.");
                    }
                }
            }
        });

        btn_okUpdate = createStyledButton("Countinue", 640, 470, 200, 45, 30);
        btn_okUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_okUpdate);
        btn_okUpdate.setVisible(false);
        btn_okUpdate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    // Get the ClientID to update
                    String enteredClientId = txt_Client.getText().trim();

                    // Check if ClientID is not empty
                    if (!enteredClientId.isEmpty()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String clientIdFromFile = data[0].trim(); // assuming ClientID is at index 0

                                if (enteredClientId.equals(clientIdFromFile)) {
                                    // Match found, populate text fields and make them editable
                                    txt_name.setText(data[1].trim()); // Name
                                    txt_CNIC.setText(data[2].trim()); // CNIC
                                    txt_age.setText(data[3].trim()); // Age
                                    txt_gender.setText(data[4].trim()); // Gender

                                    // Show labels and text fields for name, CNIC, age, and gender
                                    lbl_name.setVisible(true);
                                    lbl_CNIC.setVisible(true);
                                    lbl_age.setVisible(true);
                                    lbl_gender.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_CNIC.setVisible(true);
                                    txt_age.setVisible(true);
                                    txt_gender.setVisible(true);

                                    // Disable the OK button and enable the Update button
                                    btn_okUpdate.setVisible(false);
                                    btn_updateClient.setVisible(true);
                                    btn_updateClient.setEnabled(true);
                                    // Break the loop since we found a match
                                    break;
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        // Display a message or take appropriate action when ClientID is empty
                        JOptionPane.showMessageDialog(container, "Please enter a ClientID to update details.");
                    }
                getTotalClients();
                totalPerson.setText("Total Client : " + TotalClients);
            }
            }

        });

        btn_updateClient = createStyledButton("Update Client", 640, 470, 200, 45, 30);
        btn_updateClient.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_updateClient);
        btn_updateClient.setVisible(false);
        btn_updateClient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // Get information from text fields
                String updatedName = txt_name.getText();
                String updatedCNIC = txt_CNIC.getText();
                String updatedAge = txt_age.getText();
                String updatedGender = txt_gender.getText();
                String enterdClientId = txt_Client.getText();

                if (!updatedName.isEmpty() && !updatedAge.isEmpty() && !updatedGender.isEmpty()) {
                    try {
                        // Read all lines from the original file
                        List<String> lines = Files.readAllLines(Paths.get(myPath.clientFilePath));

                        // Iterate through the lines to find the matching CNIC
                        for (int i = 0; i < lines.size(); i++) {
                            String line = lines.get(i);
                            String[] data = line.split(",");
                            String clientId = data[0].trim(); // assuming CNIC is at index 1

                            // Check if the CNIC matches
                            if (enterdClientId.equals(clientId)) {
                                // Update the information in the line
                                lines.set(i, clientId + ","+ updatedName + "," + updatedCNIC + "," + updatedAge + "," + updatedGender);

                                Files.write(Paths.get(myPath.clientFilePath), lines);

                                JOptionPane.showMessageDialog(container, "Client information updated successfully.");

                                

                                break; 
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(); 
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(container, "Please enter all information to update.");
                }
                getTotalClients();
                totalPerson.setText("Total Client : " + TotalClients);
            }
        });
        
        // Signature Label
        JLabel lbl = new JLabel("Developed By Computer Engineer Warda Mirza 👩🏼‍💻👍🏼✨😎🥱");
        lbl.setBounds(235, 540, 500, 20);
        lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
        lbl.setForeground(Color.WHITE);
        container.add(lbl);

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(myPath.clientBackground);
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        backgroundLabel.transferFocusBackward();
        container.add(backgroundLabel);

        mainFrame.setVisible(true);
    }

    public static void getTotalClients() {
        int totalClient = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(myPath.clientFilePath))) {
            // Read each line from the file
            while (br.readLine() != null) {
                totalClient++;
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        TotalClients = Integer.toString(totalClient);
    }

    private String initializeClientIdCounter() {
        try (Scanner scanner = new Scanner(new File(myPath.clientFilePath))) {
            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line to extract the client ID
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String clientIdPart = parts[0];
                    // Check if the ID is in the expected format (e.g., CL001, CL002, etc.)
                    if (clientIdPart.matches("CL\\d+")) {
                        // Extract the numeric part and update the counter
                        int clientId = Integer.parseInt(clientIdPart.substring(2));
                        clientIdCounter = Math.max(clientIdCounter, clientId);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            // Ignore if the file doesn't exist
        }
        // Increment the counter to get the next available ID
         clientIdCounter++;
        System.out.println(clientIdCounter);
        // Format the new ClientID with leading zeros and return as String
        System.out.println("CL" + String.format("%03d", clientIdCounter));
        return "CL" + String.format("%03d", clientIdCounter);

    }
    
    private String getClientDetails(String clientId, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String clientIdFromFile = data[0].trim(); // Assuming ClientID is at index 0

            if (clientId.equals(clientIdFromFile)) {
                // Match found, return client details
                return "Name: " + data[1].trim() + "\nCNIC: " + data[2].trim() + "\nAge: " + data[3].trim() + "\nGender: " + data[4].trim();
            }
        }

        // Client not found
        return null;
    }
    
    private double calculateTotalBalance(String clientId) {
        double totalBalance = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(myPath.accountFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                //String accountId = data[0].trim();
                String accountClientId = data[1].trim();
                String balanceString = data[4].trim().replace("Rs. ", "");
                double balance = Double.parseDouble(balanceString);

                // Check if the account belongs to the specified Client ID
                if (accountClientId.equals(clientId)) {
                    totalBalance += balance;
                }
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace(); // Handle the exception according to your needs
        }

        return totalBalance;
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
            this.startColor = Color.decode("#929da3");
            this.endColor = Color.decode("#ffffff");
            this.textColor = Color.decode("#121b23");
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



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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PersonGUI{

    protected JButton AddPerson,DeletePerson,UpdatePerson,ShowAllPerson,SearchPerson,ViewPerson,BackButton,btn_addPerson,btn_deletePerson,btn_viewAllDetails,btn_searchPerson,btn_updatePerson,btn_Ok;
    protected JLabel lbl_name,lbl_CNIC,lbl_age,lbl_gender,lbl_Heading;
    protected JTextField  txt_name,txt_CNIC,txt_age,txt_gender;

    protected static String TotalPersons;

    // Default Fonts
    Font ButtonsFont = new Font("Arial", Font.BOLD, 12);
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Font textFont = new Font("Arial", Font.PLAIN, 15);
    public PersonGUI(String logoPath){
        Container container;
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Mirza Bank System / Person");
        ImageIcon logoIcon = new ImageIcon(logoPath);
        mainFrame.setIconImage(logoIcon.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(150, 50, 1000, 600);
        container = mainFrame.getContentPane();
        Color col = Color.gray;
        container.setBackground(col);
        container.setLayout(null);
        mainFrame.setResizable(false);

        lbl_Heading = new JLabel("<html><u>MIRZA BANK SYSTEM | PERSON SECTION</u></html>");
        lbl_Heading.setBounds(315, 50, 600, 50);
        lbl_Heading.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_Heading.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Heading.setForeground(Color.BLACK);
        container.add(lbl_Heading);

        getTotalPersons();
        JLabel totalPerson = new JLabel("Total Person: " + TotalPersons);
        totalPerson.setBounds(30,145,170,30);
        container.add(totalPerson);
        totalPerson.setForeground(Color.BLACK);
        totalPerson.setHorizontalAlignment(SwingConstants.CENTER);
        Font totalPersonFont = new Font("Serif", Font.BOLD, 17);
        totalPerson.setFont(totalPersonFont);

        ImageIcon icon = new ImageIcon(logoPath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lbl_logo = new JLabel(scaledIcon);
        lbl_logo.setBounds(30, -5, 170, 170);
        container.add(lbl_logo);

        int arcSizeOfSideBarBtns = 30;

        AddPerson = createStyledButton("Add Person", 30, 200, 170, 30, arcSizeOfSideBarBtns);
        AddPerson.setFont(ButtonsFont);
        container.add(AddPerson);
        AddPerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                btn_addPerson.setVisible(true);
                lbl_gender.setVisible(true);
                lbl_age.setVisible(true);
                lbl_name.setVisible(true);
                lbl_CNIC.setVisible(true);

                txt_age.setVisible(true);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(true);
                txt_gender.setVisible(true);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_deletePerson.setVisible(false);
                btn_searchPerson.setVisible(false);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_Ok.setVisible(false);
            }
        });

        DeletePerson = createStyledButton("Delete Person", 30, 240, 170, 30, arcSizeOfSideBarBtns);
        DeletePerson.setFont(ButtonsFont);
        container.add(DeletePerson);
        DeletePerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addPerson.setVisible(false);
                btn_deletePerson.setVisible(true);
                btn_searchPerson.setVisible(false);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_Ok.setVisible(false);
            }
        });

        UpdatePerson = createStyledButton("Update Person", 30, 280, 170, 30, arcSizeOfSideBarBtns);
        UpdatePerson.setFont(ButtonsFont);
        container.add(UpdatePerson);
        UpdatePerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addPerson.setVisible(false);
                btn_deletePerson.setVisible(false);
                btn_searchPerson.setVisible(false);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_Ok.setVisible(true);
            }
        });

        ShowAllPerson = createStyledButton("Show All Person", 30, 320, 170, 30, arcSizeOfSideBarBtns);
        ShowAllPerson.setFont(ButtonsFont);
        container.add(ShowAllPerson);
        ShowAllPerson.addActionListener(new ActionListener()
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

                btn_addPerson.setVisible(false);
                btn_deletePerson.setVisible(false);
                btn_searchPerson.setVisible(false);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_Ok.setVisible(false);
                new ShowAllPersonGUI();

            }
        });


        SearchPerson = createStyledButton("Search Person", 30, 360, 170, 30, arcSizeOfSideBarBtns);
        SearchPerson.setFont(ButtonsFont);
        container.add(SearchPerson);
        SearchPerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);
                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addPerson.setVisible(false);
                btn_deletePerson.setVisible(false);
                btn_searchPerson.setVisible(true);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(false);
                btn_Ok.setVisible(false);
            }
        });


        ViewPerson = createStyledButton("View Person Details", 30, 400, 170, 30, arcSizeOfSideBarBtns);
        ViewPerson.setFont(ButtonsFont);
        container.add(ViewPerson);
        ViewPerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                lbl_gender.setVisible(false);
                lbl_age.setVisible(false);
                lbl_name.setVisible(false);
                lbl_CNIC.setVisible(true);

                txt_age.setVisible(false);
                txt_CNIC.setVisible(true);
                txt_name.setVisible(false);
                txt_gender.setVisible(false);

                txt_name.setText("");
                txt_age.setText("");
                txt_CNIC.setText("");
                txt_gender.setText("");

                txt_name.setEditable(true);
                txt_age.setEditable(true);
                txt_gender.setEditable(true);

                btn_addPerson.setVisible(false);
                btn_deletePerson.setVisible(false);
                btn_searchPerson.setVisible(false);
                btn_updatePerson.setVisible(false);
                btn_viewAllDetails.setVisible(true);
                btn_Ok.setVisible(false);
            }
        });


        BackButton = createStyledButton("Back", 30, 440, 170, 30, arcSizeOfSideBarBtns);
        BackButton.setFont(ButtonsFont);
        container.add(BackButton);
        BackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new BankGUI(logoPath);
            }
        });

        Color lbl_color = Color.BLACK;
        lbl_name = new JLabel("Enter Name: ");
        lbl_name.setBounds(395, 250, 150, 30);
        container.add(lbl_name);
        lbl_name.setForeground(lbl_color);
        lbl_name.setFont(labelFont);

        lbl_CNIC = new JLabel("Enter CNIC: ");
        lbl_CNIC.setBounds(395, 200, 150, 30);
        container.add(lbl_CNIC);
        lbl_CNIC.setForeground(lbl_color);
        lbl_CNIC.setFont(labelFont);

        lbl_age = new JLabel("Enter Age: ");
        lbl_age.setBounds(395, 300, 150, 30);
        container.add(lbl_age);
        lbl_age.setForeground(lbl_color);
        lbl_age.setFont(labelFont);

        lbl_gender = new JLabel("Enter Gender: ");
        lbl_gender.setBounds(395, 350, 150, 30);
        container.add(lbl_gender);
        lbl_gender.setForeground(lbl_color);
        lbl_gender.setFont(labelFont);


        // TextBoxex
        Color txtBackground = Color.decode("#dedeee");
        txt_name = new JTextField();
        txt_name.setBounds(535, 250, 300, 30);
        container.add(txt_name);
        txt_name.setMargin(new Insets(5, 5, 5, 5));
        txt_name.setBackground(txtBackground);
        txt_name.setFont(textFont);

        txt_CNIC = new JTextField();
        txt_CNIC.setBounds(535, 200, 300, 30);
        txt_CNIC.setBackground(txtBackground);
        container.add(txt_CNIC);
        txt_CNIC.setMargin(new Insets(5, 5, 5, 5));
        txt_CNIC.setFont(textFont);

        txt_age = new JTextField();
        txt_age.setBounds(535, 300, 300, 30);
        container.add(txt_age);
        txt_age.setMargin(new Insets(5, 5, 5, 5));
        txt_age.setBackground(txtBackground);
        txt_age.setFont(textFont);

        txt_gender = new JTextField();
        txt_gender.setBounds(535, 350, 300, 30);
        container.add(txt_gender);
        txt_gender.setMargin(new Insets(5, 5, 5, 5));
        txt_gender.setBackground(txtBackground);
        txt_gender.setFont(textFont);


        // Bottoms Buttons
        btn_addPerson = createStyledButton("Add Person", 640, 410, 200, 45, 30);
        btn_addPerson.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_addPerson);
        btn_addPerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                // Get information from text fields
                String name = txt_name.getText();
                String cnic = txt_CNIC.getText();
                String age = txt_age.getText();
                String gender = txt_gender.getText();

                // Validate input (you can add more validation logic as needed)
                if (name.isEmpty() || cnic.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                    // Show an error message or handle invalid input
                    JOptionPane.showMessageDialog(mainFrame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Create a string with person's details
                String personDetails = name + "," + cnic + "," + age + "," + gender;

                // Append person details to the file
                try (PrintWriter writer = new PrintWriter(new FileWriter(myPath.personFilePath, true))) {
                    writer.println(personDetails);
                    JOptionPane.showMessageDialog(mainFrame, "Person added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    txt_name.setText("");
                    txt_age.setText("");
                    txt_CNIC.setText("");
                    txt_gender.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainFrame, "Error adding person", "Error", JOptionPane.ERROR_MESSAGE);
                }
                getTotalPersons();
                totalPerson.setText("Total Person: " + TotalPersons);
            }
        });

        btn_deletePerson = createStyledButton("Delete Person", 640, 410, 200, 45, 30);
        btn_deletePerson.setFont(new Font("Arial", Font.BOLD, 15));
        btn_deletePerson.setVisible(false);
        container.add(btn_deletePerson);
        btn_deletePerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                    // Get the ClientID to delete
                    String clientIdToDelete = JOptionPane.showInputDialog(container, "Enter ClientID to delete:");

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
                            } else {
                                JOptionPane.showMessageDialog(container, "Client with ClientID " + clientIdToDelete + " not found.");
                            }


                        } catch (IOException ex) {
                            ex.printStackTrace(); // Handle the exception according to your needs
                        }
                    } else {
                        JOptionPane.showMessageDialog(container, "Please enter a valid ClientID.");
                    }

                    getTotalPersons();
                    totalPerson.setText("Total Person: " + TotalPersons);

            }
        });

        btn_searchPerson = createStyledButton("Search Person", 640, 410, 200, 45, 30);
        btn_searchPerson.setFont(new Font("Arial", Font.BOLD, 15));
        btn_searchPerson.setVisible(false);
        container.add(btn_searchPerson);
        btn_searchPerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                String enteredCNIC = txt_CNIC.getText().trim();

                // Check if CNIC is not empty
                if (!enteredCNIC.isEmpty()) {
                    // Logic to check if the person with the given CNIC exists
                    String personDetails = getPersonDetails(enteredCNIC);

                    if (personDetails != null) {
                        String message = "Person Found:\n" + personDetails;
                        JOptionPane.showMessageDialog(container, message, "Person Found", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(container, "Person with CNIC " + enteredCNIC + " does not exist.", "Person Not Found", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Display a message or take appropriate action when CNIC is empty
                    JOptionPane.showMessageDialog(container, "Please enter a CNIC to search for a person.");
                }
                getTotalPersons();
                totalPerson.setText("Total Person: " + TotalPersons);
            }
        });
        
        btn_viewAllDetails = createStyledButton("View Person Details", 640, 410, 200, 45, 30);
        btn_viewAllDetails.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_viewAllDetails);
        btn_viewAllDetails.setVisible(false);
        btn_viewAllDetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredCNIC = txt_CNIC.getText().trim();

                    // Check if CNIC is not empty
                    if (!enteredCNIC.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.personFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String cnicFromFile = data[1].trim(); // assuming CNIC is at index 1

                                if (enteredCNIC.equals(cnicFromFile)) {
                                    // Match found, populate text fields and make them non-editable
                                    txt_name.setText(data[0].trim()); // Name
                                    txt_age.setText(data[2].trim()); // Age
                                    txt_gender.setText(data[3].trim()); // Gender

                                    // Show labels and text fields for name, age, and gender
                                    lbl_name.setVisible(true);
                                    lbl_age.setVisible(true);
                                    lbl_gender.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_age.setVisible(true);
                                    txt_gender.setVisible(true);

                                    // Make text fields non-editable
                                    txt_name.setEditable(false);
                                    txt_age.setEditable(false);
                                    txt_gender.setEditable(false);


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
                getTotalPersons();
                totalPerson.setText("Total Person: " + TotalPersons);
            }

        });

        btn_Ok = createStyledButton("OK", 640, 410, 200, 45, 30);
        btn_Ok.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_Ok);
        btn_Ok.setVisible(false);
        btn_Ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                {
                    String enteredCNIC = txt_CNIC.getText().trim();

                    // Check if CNIC is not empty
                    if (!enteredCNIC.isEmpty()) {
                        // Logic to read data from person.txt and populate the text fields
                        try (BufferedReader br = new BufferedReader(new FileReader(myPath.personFilePath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                String cnicFromFile = data[1].trim(); // assuming CNIC is at index 1

                                if (enteredCNIC.equals(cnicFromFile)) {
                                    // Match found, populate text fields and make them non-editable
                                    txt_name.setText(data[0].trim()); // Name
                                    txt_age.setText(data[2].trim()); // Age
                                    txt_gender.setText(data[3].trim()); // Gender

                                    // Show labels and text fields for name, age, and gender
                                    lbl_name.setVisible(true);
                                    lbl_age.setVisible(true);
                                    lbl_gender.setVisible(true);
                                    txt_name.setVisible(true);
                                    txt_age.setVisible(true);
                                    txt_gender.setVisible(true);
                                    btn_Ok.setVisible(false);
                                    btn_updatePerson.setVisible(true);

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
                getTotalPersons();
                totalPerson.setText("Total Person: " + TotalPersons);
            }

        });

        btn_updatePerson = createStyledButton("Update Person", 640, 410, 200, 45, 30);
        btn_updatePerson.setFont(new Font("Arial", Font.BOLD, 15));
        container.add(btn_updatePerson);
        btn_updatePerson.setVisible(false);
        btn_updatePerson.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // Get information from text fields
                String updatedName = txt_name.getText();
                String enteredCNIC = txt_CNIC.getText();
                String updatedAge = txt_age.getText();
                String updatedGender = txt_gender.getText();
                if (!updatedName.isEmpty() && !updatedAge.isEmpty() && !updatedGender.isEmpty()) {
                    try {
                        // Read all lines from the original file
                        List<String> lines = Files.readAllLines(Paths.get(myPath.personFilePath));

                        // Iterate through the lines to find the matching CNIC
                        for (int i = 0; i < lines.size(); i++) {
                            String line = lines.get(i);
                            String[] data = line.split(",");
                            String cnicFromFile = data[1].trim(); // assuming CNIC is at index 1

                            // Check if the CNIC matches
                            if (enteredCNIC.equals(cnicFromFile)) {
                                // Update the information in the line
                                lines.set(i, updatedName + "," + enteredCNIC + "," + updatedAge + "," + updatedGender);

                                // Write the updated lines back to the file
                                Files.write(Paths.get(myPath.personFilePath), lines);

                                // Display a message or take appropriate action
                                JOptionPane.showMessageDialog(container, "Person information updated successfully.");

                                // Additional actions if needed

                                break; // Break the loop since we found a match
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(); // Handle the exception according to your needs
                    }
                } else {
                    // Display a message or take appropriate action when any field is empty
                    JOptionPane.showMessageDialog(container, "Please enter all information to update.");
                }
                getTotalPersons();
                totalPerson.setText("Total Person: " + TotalPersons);
            }
        });
        
        // Signature Label
        JLabel lbl = new JLabel("Developed By Computer Engineer Warda Mirza 👩🏼‍💻👍🏼✨😎🥱");
        lbl.setBounds(550, 540, 500, 20);
        lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
        lbl.setForeground(Color.BLACK);
        container.add(lbl);
        ImageIcon backgroundImageIcon = new ImageIcon(myPath.personBackground);
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        backgroundLabel.transferFocusBackward();
        container.add(backgroundLabel);

        // Background Image


        mainFrame.setVisible(true);
    }

    private String getPersonDetails(String cnic) {
        try (BufferedReader br = new BufferedReader(new FileReader(myPath.personFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String cnicFromFile = data[1].trim(); // assuming CNIC is at index 1

                if (cnic.equals(cnicFromFile)) {
                    // Person with the given CNIC found, return the details
                    return "Name: " + data[0].trim() +
                            "\nAge: " + data[2].trim() +
                            "\nGender: " + data[3].trim() +
                            "\nCNIC: " + cnic;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }

        return null;
    }
    
    public static void getTotalPersons() {
        int totalPersons = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(myPath.personFilePath))) {
            // Read each line from the file
            while (br.readLine() != null) {
                totalPersons++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        // Convert the totalPersons to a string and return
        TotalPersons = Integer.toString(totalPersons);
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
            this.startColor = Color.decode("#967bb9");
            this.endColor = Color.decode("#1e1b48");
            this.textColor = Color.decode("#ede1ff");
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
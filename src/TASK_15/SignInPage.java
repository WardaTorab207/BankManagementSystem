package TASK_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SignInPage implements ActionListener {
    JFrame signIn_frame;
    JLabel usernameLabel, passwordLabel, cnicLabel, phoneLabel;
    JTextField usernameField, cnicField, phoneField;
    JPasswordField passwordField;
    JButton signInButton, cancelButton;
    JPanel panel;
    File userDataFile = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\TASK_15\\userData.txt"); // File to store user data

    public SignInPage() {
        signIn_frame = new JFrame();
        signIn_frame.setTitle("Sign In Form");
        signIn_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signIn_frame.setSize(400, 400);
        signIn_frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel with a nice layout
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(44, 100, 90));

        // Create and add components to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cnicLabel = new JLabel("CNIC:");
        cnicLabel.setForeground(Color.WHITE);
        panel.add(cnicLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        cnicField = new JTextField(15);
        panel.add(cnicField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setForeground(Color.WHITE);
        panel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        phoneField = new JTextField(15);
        panel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        signInButton = new JButton("Sign In");
        signInButton.addActionListener(this);
        panel.add(signInButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        panel.add(cancelButton, gbc);

        // Add the panel to the content pane
        signIn_frame.getContentPane().add(BorderLayout.CENTER, panel);

        // Set frame properties
        signIn_frame.setResizable(false);
        signIn_frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signInButton) {
            // Sign In button action
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String cnic = cnicField.getText();
            String phoneNumber = phoneField.getText();

            // Check if all fields are filled
            if (username.isEmpty() || password.isEmpty() || cnic.isEmpty() || phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(signIn_frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Save user data to the file
                saveUserData(username, password, cnic, phoneNumber);

                // Display success message
                JOptionPane.showMessageDialog(signIn_frame, "Sign In Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the current SignInPage
                signIn_frame.dispose();

                // Exit the program
                System.exit(0);
            }
        } else if (e.getSource() == cancelButton) {
            // Cancel button action
            System.out.println("Sign In canceled");
            signIn_frame.dispose(); // Close the current SignInPage
        }
    }

    private void saveUserData(String username, String password, String cnic, String phoneNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile, true))) {
            writer.write(username + "|" + password + "|" + cnic + "|" + phoneNumber);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignInPage());
    }
}
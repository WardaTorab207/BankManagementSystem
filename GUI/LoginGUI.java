package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginGUI {
    private Color foregroundColor = Color.decode("#060201");
    private Color backgroundColor = Color.decode("#F1EEE7");

    public LoginGUI(String logoPath) {
        Container container;

        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Mirza Bank System");
        ImageIcon logoIcon = new ImageIcon(logoPath);
        mainFrame.setIconImage(logoIcon.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(150, 50, 1000, 600);
        mainFrame.setLocationRelativeTo(null);
        container = mainFrame.getContentPane();
        Color col = Color.gray;
        container.setBackground(col);
        container.setLayout(null);
        mainFrame.setResizable(false);

        ImageIcon logoImageIcon = new ImageIcon(myPath.logo1Path);
        Image logoImage = logoImageIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoImageIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoImageIcon);
        logoLabel.setBounds(400, -5, 200, 200);
        logoLabel.transferFocusBackward();
        container.add(logoLabel);

        JLabel lblHeading = new JLabel("WELCOME TO MIRZA BANK MANAGEMENT SYSTEM");
        lblHeading.setBounds(300, 190, 400, 20);//378
        lblHeading.setFont(new Font("Arial", Font.BOLD, 15));
        lblHeading.setForeground(backgroundColor);
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(lblHeading);

        JLabel lblUsername = new JLabel("Enter Email:");
        lblUsername.setBounds(310, 240, 380, 10);
        lblUsername.setForeground(backgroundColor);
        container.add(lblUsername);
        RoundedTextField txtUsername = new RoundedTextField();
        txtUsername.setBounds(310, 260, 380, 40);
        txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
        txtUsername.setMargin(new Insets(5, 5, 5, 5));
        container.add(txtUsername);

        JLabel lblPasword = new JLabel("Enter Password:");
        lblPasword.setBounds(310, 320, 380, 10);
        lblPasword.setForeground(backgroundColor);
        container.add(lblPasword);
        RoundedPasswordField txtPassword = new RoundedPasswordField();
        txtPassword.setBounds(310, 340, 380, 40);
        txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
        txtPassword.setMargin(new Insets(5, 5, 5, 5));
        container.add(txtPassword);

        JLabel cautionLabel = new JLabel("");
        cautionLabel.setBounds(310, 385, 200, 20);
        container.add(cautionLabel);

        JButton btnLogin = createStyledButton("Login", 540, 420, 150, 40, 15, foregroundColor, backgroundColor); // Adjust the coordinates as needed
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if(Login(email, password)) {
                    mainFrame.dispose();
                    new BankGUI(logoPath);
                }
                else{
                    cautionLabel.setForeground(Color.RED);
                    cautionLabel.setText("Inavlid Username or Password");
                }
                cautionLabel.setVisible(!cautionLabel.getText().isEmpty());
            }
        });
        container.add(btnLogin);

        JButton btnSignup = createStyledButton("Signup", 310, 420, 150, 40, 15, foregroundColor, backgroundColor); // Adjust the coordinates as needed
        btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if(SignUp(email, password)) {
                    cautionLabel.setForeground(Color.green);
                    cautionLabel.setText("Signup Sucessfully");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
                else{
                    cautionLabel.setForeground(Color.RED);
                    cautionLabel.setText("Something went wrong...");
                }
                cautionLabel.setVisible(!cautionLabel.getText().isEmpty());
            }
        });
        container.add(btnSignup);

        JLabel lbl = new JLabel("Developed By Computer Engineer Warda Mirza 👩🏼‍💻👍🏼✨😎🥱");
        lbl.setBounds(2, 540, 500, 20);
        lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
        lbl.setForeground(Color.WHITE);
        container.add(lbl);

        ImageIcon backgroundImageIcon = new ImageIcon(myPath.darkBackground);
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        backgroundLabel.transferFocusBackward();
        container.add(backgroundLabel);

        mainFrame.setVisible(true);
    }

    

    private RoundButton createStyledButton(String text, int x, int y, int width, int height, int arcSize, Color foreground, Color background) {
        RoundButton button = new RoundButton(text, arcSize, foreground, background);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new HoverMouseListener(button));

        return button;
    }

    private static class HoverMouseListener extends MouseAdapter {
        private final JComponent component;
        private final Color defaultColor;

        HoverMouseListener(JComponent component) {
            this.component = component;
            this.defaultColor = component.getForeground();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            component.setForeground(Color.decode("#0b416e")); // Change to the desired hover color
        }

        @Override
        public void mouseExited(MouseEvent e) {
            component.setForeground(defaultColor);
        }
    }

    private static class RoundButton extends JButton {
        private final int arcSize;
        private final Color foregroundColor;
        private final Color backgroundColor;

        public RoundButton(String text, int arcSize, Color foreground, Color background) {
            super(text);
            this.arcSize = arcSize;
            this.foregroundColor = foreground;
            this.backgroundColor = background;
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.decode("#ECE3CB")); // Change to the desired color when pressed
            } else {
                g.setColor(backgroundColor);
            }
            g.fillRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(foregroundColor); // Change to the desired border color
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
        }
    }

    private class RoundedTextField extends JTextField {
        private static final long serialVersionUID = 1L;
        private final int arcSize = 15;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);

            super.paintComponent(g2d);

            g2d.dispose();
        }
    }

    private class RoundedPasswordField extends JPasswordField {
        private static final long serialVersionUID = 1L;
        private final int arcSize = 15;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);

            super.paintComponent(g2d);

            g2d.dispose();
        }
    }

    private boolean Login(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(myPath.muserFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2 && userData[0].equals(email) && userData[1].equals(password)) {
                    return true;
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean SignUp(String email, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myPath.muserFilePath, true))) {
            writer.write(email + "," + password);
            writer.newLine();
            return true;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

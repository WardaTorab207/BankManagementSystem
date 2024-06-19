package GUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BankGUI {
    public BankGUI(String logoPath) {
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


        JLabel lbl_Heading = createStyledLabel("WELCOME TO MIRZA BANK MANAGEMENT SYSTEM", 50, 50, 900, 50);
        container.add(lbl_Heading);

        RoundButton personButton = createStyledButton("Persons", 400, 200);
        container.add(personButton);
        personButton.addActionListener(e -> {
            mainFrame.dispose();
            new PersonGUI(logoPath);
        });

        RoundButton clientButton = createStyledButton("Clients", 250, 300);
        container.add(clientButton);
        clientButton.addActionListener(e -> {
            mainFrame.dispose();
            new ClientGUI(logoPath);
        });

        RoundButton accountButton = createStyledButton("Accounts", 550, 300);
        container.add(accountButton);
        accountButton.addActionListener(e -> {
            mainFrame.dispose();
            new TempGUI(logoPath);
        });

        RoundButton exitButton = createStyledButton("Logout", 400, 400);
        container.add(exitButton);
        exitButton.addActionListener(e -> {
            mainFrame.dispose();
            new LoginGUI(logoPath);
        });

        JLabel lbl = new JLabel("Developed By Computer Engineer Warda Mirza 👩🏼‍💻👍🏼✨😎🥱");
        lbl.setBounds(2, 540, 500, 20);
        lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
        lbl.setForeground(Color.WHITE);
        container.add(lbl);

        ImageIcon backgroundImageIcon = new ImageIcon(myPath.background);
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledBackgroundImage = backgroundImage.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(scaledBackgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        backgroundLabel.transferFocusBackward();
        container.add(backgroundLabel);

        mainFrame.setVisible(true);
    }

    private RoundButton createStyledButton(String text, int x, int y) {
        RoundButton button = new RoundButton(text);
        button.setBounds(x, y, 200, 75);
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.setForeground(Color.decode("#060201"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(Color.decode("#F1EEE7"));

        button.addMouseListener(new HoverMouseListener(button));

        return button;
    }

    private JLabel createStyledLabel(String text, int x, int y, int width, int height) {
        JLabel label = new RoundLabel(text);
        label.setBounds(x, y, width, height);
    
        // Set the background color to a new color (e.g., light blue)
        label.setBackground(Color.decode("#F1EEE7"));
    
        label.setForeground(Color.decode("#060201"));
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    
        return label;
    }

    private static class RoundLabel extends JLabel {
        public RoundLabel(String text) {
            super(text);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 32));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the rounded background
            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);

            // Draw the text
            super.paintComponent(g2d);

            g2d.dispose();
        }
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
        public RoundButton(String text) {
            super(text);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.decode("#ECE3CB")); // Change to the desired color when pressed
            } else {
                g.setColor(getBackground());
            }
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground()); // Change to the desired border color
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);
        }
    }
}

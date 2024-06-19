package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ShowAllAcountsGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchTextField;
    
    String accountFilePath = "D:\\Books\\New\\files\\AccountFile.txt";
    
    public ShowAllAcountsGUI() {
        initialize();
    }

    public void refreshTable() {
        loadAccounts();
    }

    private void loadAccounts() {
        List<String[]> accountData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(accountFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] account = line.split(",");
                accountData.add(account);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Clear existing rows
        tableModel.setRowCount(0);

        // Add new rows
        for (String[] account : accountData) {
            tableModel.addRow(account);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Show All Accounts");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(150, 50, 1000, 500);

        // Heading
        JLabel lbl_heading = new JLabel("Show All Account Details");
        lbl_heading.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_heading.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lbl_heading, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        JLabel lbl_search = new JLabel("Search by Client ID: ");
        searchTextField = new JTextField(15);
        JButton btn_search = new JButton("Search");
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAccounts();
            }
        });
        searchPanel.add(lbl_search);
        searchPanel.add(searchTextField);
        searchPanel.add(btn_search);

        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Account Number");
        tableModel.addColumn("Client ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("CNIC");
        tableModel.addColumn("Balance");

        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Bold and larger font for column headers
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));

        // Set row height
        table.setRowHeight(25);

        // Set alternate row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(Color.LIGHT_GRAY);
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton btn_refresh = new JButton("Refresh Table");
        btn_refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadAccounts();
            }
        });
        frame.getContentPane().add(btn_refresh, BorderLayout.SOUTH);

        loadAccounts();

        frame.getContentPane().setBackground(new Color(240, 240, 240));

        frame.setVisible(true);
    }

    private void searchAccounts() {
        String searchQuery = searchTextField.getText().trim();

        // Read all accounts from the file
        List<String[]> allAccounts = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(accountFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] account = line.split(",");
                allAccounts.add(account);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Filter accounts based on search query
        List<String[]> filteredAccounts = new ArrayList<>();
        for (String[] account : allAccounts) {
            if (account[1].contains(searchQuery)) {
                filteredAccounts.add(account);
            }
        }

        // Clear existing rows
        tableModel.setRowCount(0);

        // Add new rows for filtered accounts
        for (String[] account : filteredAccounts) {
            tableModel.addRow(account);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShowAllAcountsGUI();
            }
        });
    }
}

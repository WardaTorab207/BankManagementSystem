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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ShowAllTransactionGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchTextField;

    String transactionFilePath = "D:\\Books\\New\\files\\TransactionFile.txt";

    public ShowAllTransactionGUI() {
        initialize();
    }

    public void refreshTable() {
        loadTransactions();
    }

    private void loadTransactions() {
        // Read the transactions from the file and populate the table
        List<String[]> transactionData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(transactionFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] transaction = line.split(",");
                transactionData.add(transaction);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Clear existing rows
        tableModel.setRowCount(0);

        // Add new rows
        for (String[] transaction : transactionData) {
            tableModel.addRow(transaction);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Show All Transactions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(150, 50, 1000, 500);

        // Heading
        JLabel lbl_heading = new JLabel("Show All Transaction Details");
        lbl_heading.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_heading.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lbl_heading, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        JLabel lbl_search = new JLabel("Search by AccountID or ClientID: ");
        searchTextField = new JTextField(15);
        JButton btn_search = new JButton("Search");
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTransactions();
            }
        });
        searchPanel.add(lbl_search);
        searchPanel.add(searchTextField);
        searchPanel.add(btn_search);

        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Transaction Date");
        tableModel.addColumn("Transaction Day");
        tableModel.addColumn("Transaction Time");
        tableModel.addColumn("Account Number");
        tableModel.addColumn("Previous Amount");
        tableModel.addColumn("Transaction Type");
        tableModel.addColumn("Transaction Amount");

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
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add margin
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Refresh Button
        JButton btn_refresh = new JButton("Refresh Table");
        btn_refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTransactions();
            }
        });
        frame.getContentPane().add(btn_refresh, BorderLayout.SOUTH);

        // Load initial data
        loadTransactions();

        // Set background color
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        frame.setVisible(true);
    }

    private void searchTransactions() {
        // Read the search query from the text field
        String searchQuery = searchTextField.getText().trim();

        // Read all transactions from the file
        List<String[]> allTransactions = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(transactionFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] transaction = line.split(",");
                allTransactions.add(transaction);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Filter transactions based on search query
        List<String[]> filteredTransactions = new ArrayList<>();
        for (String[] transaction : allTransactions) {
            for (String data : transaction) {
                if (data.contains(searchQuery)) {
                    filteredTransactions.add(transaction);
                    break;
                }
            }
        }

        // Clear existing rows
        tableModel.setRowCount(0);

        // Add new rows for filtered transactions
        for (String[] transaction : filteredTransactions) {
            tableModel.addRow(transaction);
        }
    }
}

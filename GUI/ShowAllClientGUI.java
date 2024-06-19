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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ShowAllClientGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    String clientFilePath = "D:\\Books\\New\\files\\ClientFile.txt";
    

    public ShowAllClientGUI() {
        initialize();
    }

    public void refreshTable() {
        // Reload data into the table
        loadClients();
    }

    private void loadClients() {
        List<String[]> clientsData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(clientFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                clientsData.add(parts);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        tableModel.setRowCount(0);

        for (String[] client : clientsData) {
            tableModel.addRow(client);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Show All Clients");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(150, 50, 800, 400);

        // Heading
        JLabel lbl_heading = new JLabel("Show All Client Details");
        lbl_heading.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_heading.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lbl_heading, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Client ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("CNIC"); // Added CNIC column

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
        JButton btn_back = new JButton("Back");
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame when Back is clicked
            }
        });

        frame.getContentPane().add(btn_back, BorderLayout.SOUTH);

        // Load initial data
        loadClients();

        // Set background color
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        frame.setVisible(true);
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckUpdatePembayaranPage extends JFrame {
    private JTextField idField;
    private JComboBox<String> statusComboBox;
    private DefaultTableModel tableModel;
    private JTable table;

    public CheckUpdatePembayaranPage() {
        setTitle("Cek/Update Status Pembayaran");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel idLabel = new JLabel("ID Siswa:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);

        idField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(idField, gbc);

        JButton checkButton = new JButton("Cek Status");
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(checkButton, gbc);

        JLabel statusLabel = new JLabel("Status Pembayaran:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(statusLabel, gbc);

        statusComboBox = new JComboBox<>(new String[]{"Belom Lunas", "Lunas"});
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(statusComboBox, gbc);

        JButton updateButton = new JButton("Update Status");
        gbc.gridx = 2;
        gbc.gridy = 1;
        inputPanel.add(updateButton, gbc);

        add(inputPanel, BorderLayout.NORTH);

        // Column Names
        String[] columnNames = {"ID Siswa", "Total Bayar", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Load data into table
        loadPembayaranData();

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkStatusPembayaran();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStatusPembayaran();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkStatusPembayaran() {
        int idSiswa = Integer.parseInt(idField.getText());
        Connection conn = DatabaseConnection.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT id_siswa, totalbayar, status FROM pembayaran WHERE id_siswa = " + idSiswa;
            ResultSet rs = stmt.executeQuery(query);

            tableModel.setRowCount(0); // Clear existing data

            if (rs.next()) {
                int id = rs.getInt("id_siswa");
                int totalBayar = rs.getInt("totalbayar");
                String status = rs.getString("status");
                tableModel.addRow(new Object[]{id, totalBayar, status});

                // Set the status combo box to the current status
                statusComboBox.setSelectedItem(status);
            } else {
                JOptionPane.showMessageDialog(null, "ID Siswa tidak ditemukan!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void updateStatusPembayaran() {
        int idSiswa = Integer.parseInt(idField.getText());
        String status = (String) statusComboBox.getSelectedItem();
        Connection conn = DatabaseConnection.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "UPDATE pembayaran SET status = '" + status + "' WHERE id_siswa = " + idSiswa;
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Status pembayaran berhasil diperbarui!");

            // Refresh table
            loadPembayaranData();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void loadPembayaranData() {
        Connection conn = DatabaseConnection.getConnection();
        try {
            tableModel.setRowCount(0);  // Clear existing data
            Statement stmt = conn.createStatement();
            String query = "SELECT id_siswa, totalbayar, status FROM pembayaran";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int idSiswa = rs.getInt("id_siswa");
                int totalBayar = rs.getInt("totalbayar");
                String status = rs.getString("status");
                tableModel.addRow(new Object[]{idSiswa, totalBayar, status});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new CheckUpdatePembayaranPage();
    }
}

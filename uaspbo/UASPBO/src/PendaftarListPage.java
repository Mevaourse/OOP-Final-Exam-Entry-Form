import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PendaftarListPage extends JFrame {
    private DefaultTableModel tableModel;

    public PendaftarListPage() {
        setTitle("Daftar Pendaftar");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Nama", "Alamat", "No Telepon", "Jurusan", "Rata-Rata Nilai", "Asal Sekolah", "Nama Wali", "No HP Wali", "Status Kelulusan"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("Cari berdasarkan ID: ");
        JTextField searchField = new JTextField(10);
        JButton searchButton = new JButton("Cari");
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchId = searchField.getText();
                if (!searchId.isEmpty()) {
                    searchPendaftarById(searchId);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan ID untuk mencari");
                }
            }
        });

        loadAllPendaftar();

        setVisible(true);
    }

    private void loadAllPendaftar() {
        tableModel.setRowCount(0);
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM pendaftar";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String noTelepon = resultSet.getString("no_telepon");
                String jurusan = resultSet.getString("jurusan");
                double rataRataNilai = resultSet.getDouble("rata_rata_nilai");
                String asalSekolah = resultSet.getString("asal_sekolah");
                String namaWali = resultSet.getString("nama_wali");
                String noHpWali = resultSet.getString("no_hp_wali");
                boolean statusKelulusan = resultSet.getBoolean("status_kelulusan");

                Object[] rowData = {id, nama, alamat, noTelepon, jurusan, rataRataNilai, asalSekolah, namaWali, noHpWali, statusKelulusan ? "Lulus" : "Tidak Lulus"};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchPendaftarById(String id) {
        tableModel.setRowCount(0);
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM pendaftar WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int pendaftarId = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String noTelepon = resultSet.getString("no_telepon");
                String jurusan = resultSet.getString("jurusan");
                double rataRataNilai = resultSet.getDouble("rata_rata_nilai");
                String asalSekolah = resultSet.getString("asal_sekolah");
                String namaWali = resultSet.getString("nama_wali");
                String noHpWali = resultSet.getString("no_hp_wali");
                boolean statusKelulusan = resultSet.getBoolean("status_kelulusan");

                Object[] rowData = {pendaftarId, nama, alamat, noTelepon, jurusan, rataRataNilai, asalSekolah, namaWali, noHpWali, statusKelulusan ? "Lulus" : "Tidak Lulus"};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

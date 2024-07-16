package PendaftaranMahasiswa;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MataKuliahListPage extends JFrame {
    public MataKuliahListPage() {
        setTitle("List Mata Kuliah");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        // Column Names
        String[] columnNames = {"ID", "Nama Mata Kuliah", "Jumlah SKS"};
        
        // Create Table Model
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM mata_kuliah";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaMk = resultSet.getString("nama_mk");
                String deskripsi = resultSet.getString("deskripsi");
                tableModel.addRow(new Object[]{id, namaMk, deskripsi});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // Create Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, java.awt.BorderLayout.CENTER);

        setVisible(true);
    }
}
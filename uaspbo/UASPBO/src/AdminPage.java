import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminPage extends JFrame {
    public AdminPage() {
        setTitle("Admin Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton viewListButton = new JButton("Lihat List Pendaftar");
        viewListButton.setBounds(10, 20, 160, 25);
        add(viewListButton);

        JButton editMataKuliahButton = new JButton("Edit Mata Kuliah");
        editMataKuliahButton.setBounds(10, 50, 160, 25);
        add(editMataKuliahButton);

        viewListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM pendaftar";
                    ResultSet resultSet = statement.executeQuery(sql);

                    StringBuilder pendaftarList = new StringBuilder();
                    while (resultSet.next()) {
                        pendaftarList.append("ID: ").append(resultSet.getInt("id"))
                                .append(", Nama: ").append(resultSet.getString("nama"))
                                .append(", Status: ").append(resultSet.getBoolean("status_kelulusan") ? "Lulus" : "Belum Lulus")
                                .append("\n");
                    }

                    JOptionPane.showMessageDialog(null, pendaftarList.toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        editMataKuliahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementasi edit mata kuliah
            }
        });

        setVisible(true);
    }
}

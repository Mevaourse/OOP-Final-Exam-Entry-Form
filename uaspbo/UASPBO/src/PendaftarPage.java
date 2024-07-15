import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PendaftarPage extends JFrame {
    private String username;

    public PendaftarPage(String username) {
        this.username = username;
        setTitle("Pendaftar Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton registerButton = new JButton("Mendaftar");
        registerButton.setBounds(10, 20, 160, 25);
        add(registerButton);

        JButton checkStatusButton = new JButton("Cek Status Kelulusan");
        checkStatusButton.setBounds(10, 50, 160, 25);
        add(checkStatusButton);

        JButton listMataKuliahButton = new JButton("Lihat Mata Kuliah");
        listMataKuliahButton.setBounds(10, 80, 160, 25);
        add(listMataKuliahButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPage();
            }
        });

        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();
                    String sql = "SELECT id, nama, status_kelulusan FROM pendaftar";
                    ResultSet resultSet = statement.executeQuery(sql);

                    StringBuilder statusList = new StringBuilder();
                    while (resultSet.next()) {
                        statusList.append("ID: ").append(resultSet.getInt("id"))
                                .append(", Nama: ").append(resultSet.getString("nama"))
                                .append(", Status: ").append(resultSet.getBoolean("status_kelulusan") ? "Lulus" : "Tidak Lulus")
                                .append("\n");
                    }

                    JOptionPane.showMessageDialog(null, statusList.toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        listMataKuliahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MataKuliahListPage();
            }
        });

        setVisible(true);
    }
}

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

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 110, 160, 25);
        add(logoutButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPage();
            }
        });

        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PendaftarListPage();
            }
        });
        listMataKuliahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MataKuliahListPage();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main();
            }
        });

        setVisible(true);
    }
}

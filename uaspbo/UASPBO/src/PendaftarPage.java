import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendaftarPage extends JFrame {
    private String username;

    public PendaftarPage(String username) {
        this.username = username;
        setTitle("Pendaftar Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama dengan BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        // Panel untuk tombol-tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue()); // Spasi di atas tombol

        JButton registerButton = new JButton("Mendaftar");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setMaximumSize(new Dimension(160, 25));
        buttonPanel.add(registerButton);

        JButton checkStatusButton = new JButton("Cek Status Kelulusan");
        checkStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkStatusButton.setMaximumSize(new Dimension(160, 25));
        buttonPanel.add(checkStatusButton);

        JButton listMataKuliahButton = new JButton("Lihat Mata Kuliah");
        listMataKuliahButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listMataKuliahButton.setMaximumSize(new Dimension(160, 25));
        buttonPanel.add(listMataKuliahButton);

        JButton cekPembayaranButton = new JButton("Cek Status Pembayaran");
        cekPembayaranButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cekPembayaranButton.setMaximumSize(new Dimension(160, 25));
        buttonPanel.add(cekPembayaranButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setMaximumSize(new Dimension(160, 25));
        buttonPanel.add(logoutButton);

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue()); // Spasi di bawah tombol

        // Action Listeners
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

        cekPembayaranButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CekPembayaranPage(username);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main();
            }
        });

        // Menengahkan frame di tengah layar
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PendaftarPage("username");
    }
}

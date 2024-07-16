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

        // Main panel with BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue()); // Space above buttons

        // Create buttons
        JButton registerButton = new JButton("Mendaftar");
        JButton checkStatusButton = new JButton("Cek Status Kelulusan");
        JButton listMataKuliahButton = new JButton("Lihat Mata Kuliah");
        JButton cekPembayaranButton = new JButton("Cek Status Pembayaran");
        JButton logoutButton = new JButton("Logout");

        // Center align buttons
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listMataKuliahButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cekPembayaranButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set button maximum sizes
        Dimension buttonSize = new Dimension(200, 30);
        registerButton.setMaximumSize(buttonSize);
        checkStatusButton.setMaximumSize(buttonSize);
        listMataKuliahButton.setMaximumSize(buttonSize);
        cekPembayaranButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);

        // Add buttons to panel with spacing
        buttonPanel.add(registerButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(checkStatusButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(listMataKuliahButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(cekPembayaranButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(logoutButton);

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue()); // Space below buttons

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

        // Center frame on screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PendaftarPage("username");
    }
}

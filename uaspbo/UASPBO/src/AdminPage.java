import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    public AdminPage() {
        setTitle("Admin Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        add(mainPanel);

        // Create buttons
        JButton listPendaftarButton = new JButton("List Pendaftar");
        JButton updateMataKuliahButton = new JButton("Update Mata Kuliah");
        JButton checkUpdatePembayaranButton = new JButton("Cek/Update Pembayaran");
        JButton logoutButton = new JButton("Logout");

        // Center align buttons
        listPendaftarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateMataKuliahButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkUpdatePembayaranButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set button maximum sizes
        Dimension buttonSize = new Dimension(200, 30);
        listPendaftarButton.setMaximumSize(buttonSize);
        updateMataKuliahButton.setMaximumSize(buttonSize);
        checkUpdatePembayaranButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);

        // Add buttons to panel with spacing
        mainPanel.add(listPendaftarButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(updateMataKuliahButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(checkUpdatePembayaranButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(logoutButton);

        // Action listeners
        listPendaftarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PendaftarListPage();
            }
        });

        updateMataKuliahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateMataKuliahPage();
            }
        });

        checkUpdatePembayaranButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckUpdatePembayaranPage();
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
        new AdminPage();
    }
}

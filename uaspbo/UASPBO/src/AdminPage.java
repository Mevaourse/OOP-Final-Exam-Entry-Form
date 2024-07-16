package PendaftaranMahasiswa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    public AdminPage() {
        setTitle("Admin Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

  
        mainPanel.setBackground(Color.decode("#1153a0"));

    
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.decode("#1153a0"));

    
        ImageIcon originalImageIcon = new ImageIcon("C:/Users/LENOVO/Downloads/Udinus.png");
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedImageIcon);
        topPanel.add(imageLabel);

        mainPanel.add(topPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBackground(Color.decode("#1153a0"));

        JButton listPendaftarButton = new JButton("List Pendaftar");
        JButton updateMataKuliahButton = new JButton("Update Mata Kuliah");
        JButton checkUpdatePembayaranButton = new JButton("Cek/Update Pembayaran");
        JButton logoutButton = new JButton("Logout");

        Dimension buttonSize = new Dimension(200, 30);
        listPendaftarButton.setMaximumSize(buttonSize);
        updateMataKuliahButton.setMaximumSize(buttonSize);
        checkUpdatePembayaranButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);

        listPendaftarButton.setBackground(Color.WHITE);
        updateMataKuliahButton.setBackground(Color.WHITE);
        checkUpdatePembayaranButton.setBackground(Color.WHITE);
        logoutButton.setBackground(Color.WHITE);

        listPendaftarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateMataKuliahButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkUpdatePembayaranButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottomPanel.add(listPendaftarButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(updateMataKuliahButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(checkUpdatePembayaranButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(logoutButton);

        mainPanel.add(bottomPanel);
        mainPanel.add(Box.createVerticalGlue());


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

      
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminPage();
            }
        });
    }
}

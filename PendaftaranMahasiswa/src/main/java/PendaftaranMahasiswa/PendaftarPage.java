package PendaftaranMahasiswa;

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

       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        
        mainPanel.setBackground(Color.decode("#1153a0"));

      
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.decode("#1153a0"));

       
        ImageIcon originalImageIcon = new ImageIcon("C:/Users/LENOVO/Downloads/Udinus.png"); // Adjust path as necessary
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, -1, Image.SCALE_SMOOTH); // Width 150, maintain aspect ratio
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedImageIcon);
        topPanel.add(imageLabel);

        mainPanel.add(topPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); 

      
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBackground(Color.decode("#1153a0"));

        JButton registerButton = new JButton("Mendaftar");
        JButton checkStatusButton = new JButton("Cek Status Kelulusan");
        JButton listMataKuliahButton = new JButton("Lihat Mata Kuliah");
        JButton cekPembayaranButton = new JButton("Cek Status Pembayaran");
        JButton logoutButton = new JButton("Logout");

     
        Dimension buttonSize = new Dimension(200, 30);
        registerButton.setMaximumSize(buttonSize);
        checkStatusButton.setMaximumSize(buttonSize);
        listMataKuliahButton.setMaximumSize(buttonSize);
        cekPembayaranButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);


        registerButton.setBackground(Color.WHITE);
        checkStatusButton.setBackground(Color.WHITE);
        listMataKuliahButton.setBackground(Color.WHITE);
        cekPembayaranButton.setBackground(Color.WHITE);
        logoutButton.setBackground(Color.WHITE);

       
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listMataKuliahButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cekPembayaranButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        bottomPanel.add(registerButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(checkStatusButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(listMataKuliahButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(cekPembayaranButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(logoutButton);

        mainPanel.add(bottomPanel);
        mainPanel.add(Box.createVerticalGlue()); 

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

       
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PendaftarPage("username");
            }
        });
    }
}

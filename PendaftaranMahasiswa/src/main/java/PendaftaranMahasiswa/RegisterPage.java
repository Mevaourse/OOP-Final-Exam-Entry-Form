/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendaftaranMahasiswa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterPage extends JFrame {
    public RegisterPage() {
        setTitle("Form Pendaftaran");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(mainPanel);

     
        JLabel labelNama = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(labelNama, gbc);

        JTextField textNama = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textNama, gbc);

        JLabel labelAlamat = new JLabel("Alamat:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(labelAlamat, gbc);

        JTextField textAlamat = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textAlamat, gbc);

        JLabel labelNoTelepon = new JLabel("No Telepon:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(labelNoTelepon, gbc);

        JTextField textNoTelepon = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textNoTelepon, gbc);

        JLabel labelJurusan = new JLabel("Jurusan:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(labelJurusan, gbc);

        String[] jurusanOptions = {"Teknik Informatika", "Sistem Informasi", "DKV", "Teknik Informatika D3", "Broadcasting D3", "Magister Teknik Informatika", "FTV, Animasi", "Ilmu Komunikasi", "Doktor Ilmu Komputer", "Teknik Informatika PJJ"};
        JComboBox<String> comboBoxJurusan = new JComboBox<>(jurusanOptions);
        gbc.gridx = 1;
        mainPanel.add(comboBoxJurusan, gbc);

        JLabel labelRataRataNilai = new JLabel("Rata-Rata Nilai:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(labelRataRataNilai, gbc);

        JTextField textRataRataNilai = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textRataRataNilai, gbc);

        JLabel labelAsalSekolah = new JLabel("Asal Sekolah:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(labelAsalSekolah, gbc);

        JTextField textAsalSekolah = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textAsalSekolah, gbc);

        JLabel labelNamaWali = new JLabel("Nama Wali:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(labelNamaWali, gbc);

        JTextField textNamaWali = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textNamaWali, gbc);

        JLabel labelNoHpWali = new JLabel("No HP Wali:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(labelNoHpWali, gbc);

        JTextField textNoHpWali = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(textNoHpWali, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(submitButton, gbc);

        JLabel labelIdPendaftar = new JLabel("ID Pendaftar:");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(labelIdPendaftar, gbc);

        JTextField textIdPendaftar = new JTextField(20);
        textIdPendaftar.setEditable(false);
        gbc.gridx = 1;
        mainPanel.add(textIdPendaftar, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = textNama.getText();
                    String alamat = textAlamat.getText();
                    String noTelepon = textNoTelepon.getText();
                    String jurusan = (String) comboBoxJurusan.getSelectedItem();
                    double rataRataNilai = Double.parseDouble(textRataRataNilai.getText());
                    String asalSekolah = textAsalSekolah.getText();
                    String namaWali = textNamaWali.getText();
                    String noHpWali = textNoHpWali.getText();
                    boolean statusKelulusan = rataRataNilai >= 50;

                    Connection connection = DatabaseConnection.getConnection();
                    String sql = "INSERT INTO pendaftar (nama, alamat, no_telepon, jurusan, rata_rata_nilai, asal_sekolah, nama_wali, no_hp_wali, status_kelulusan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, alamat);
                    preparedStatement.setString(3, noTelepon);
                    preparedStatement.setString(4, jurusan);
                    preparedStatement.setDouble(5, rataRataNilai);
                    preparedStatement.setString(6, asalSekolah);
                    preparedStatement.setString(7, namaWali);
                    preparedStatement.setString(8, noHpWali);
                    preparedStatement.setBoolean(9, statusKelulusan);
                    preparedStatement.executeUpdate();

                    
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int idPendaftar = generatedKeys.getInt(1);
                        textIdPendaftar.setText(String.valueOf(idPendaftar));
                    }

                    JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

  
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterPage();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendaftaranMahasiswa;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CekPembayaranPage extends JFrame {
    private String username;

    public CekPembayaranPage(String username) {
        this.username = username;
        setTitle("Cek Status Pembayaran");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

     
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

      
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pendaftaranmahasiswa", "root", "KaiZenin2003");
            Statement stmt = conn.createStatement();
            String query = "SELECT p.nama, b.totalbayar, b.status " +
                    "FROM pembayaran b " +
                    "JOIN pendaftar p ON b.id_siswa = p.id " +
                    "WHERE p.nama = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String nama = rs.getString("nama");
                int totalBayar = rs.getInt("totalbayar");
                String status = rs.getString("status");

                textArea.setText("Nama: " + nama + "\n" +
                        "Total Bayar: " + totalBayar + "\n" +
                        "Status: " + status);
            } else {
                textArea.setText("Data pembayaran tidak ditemukan untuk " + username);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengambil data pembayaran: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            textArea.setText("Gagal mengambil data pembayaran.");
        }

   
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CekPembayaranPage("Daniel"));
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendaftaranMahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateMataKuliahPage extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public UpdateMataKuliahPage() {
        setTitle("Update Mata Kuliah");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        String[] columnNames = {"ID", "Nama Mata Kuliah", "Deskripsi"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM mata_kuliah";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaMk = resultSet.getString("nama_mk");
                String deskripsi = resultSet.getString("deskripsi");
                tableModel.addRow(new Object[]{id, namaMk, deskripsi});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 760, 200);
        add(scrollPane);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(10, 230, 120, 25);
        add(labelId);

        JTextField textId = new JTextField(20);
        textId.setBounds(140, 230, 200, 25);
        add(textId);

        JLabel labelNamaMk = new JLabel("Nama Mata Kuliah:");
        labelNamaMk.setBounds(10, 260, 120, 25);
        add(labelNamaMk);

        JTextField textNamaMk = new JTextField(20);
        textNamaMk.setBounds(140, 260, 200, 25);
        add(textNamaMk);

        JLabel labelDeskripsi = new JLabel("Deskripsi:");
        labelDeskripsi.setBounds(10, 290, 120, 25);
        add(labelDeskripsi);

        JTextField textDeskripsi = new JTextField(20);
        textDeskripsi.setBounds(140, 290, 200, 25);
        add(textDeskripsi);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(140, 330, 100, 25);
        add(updateButton);

        JButton addButton = new JButton("Add");
        addButton.setBounds(250, 330, 100, 25);
        add(addButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textId.getText());
                    String namaMk = textNamaMk.getText();
                    String deskripsi = textDeskripsi.getText();

                    Connection connection = DatabaseConnection.getConnection();
                    String sql = "UPDATE mata_kuliah SET nama_mk = ?, deskripsi = ? WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, namaMk);
                    preparedStatement.setString(2, deskripsi);
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();

              
                    tableModel.setRowCount(0);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM mata_kuliah");
                    while (resultSet.next()) {
                        int newId = resultSet.getInt("id");
                        String newNamaMk = resultSet.getString("nama_mk");
                        String newDeskripsi = resultSet.getString("deskripsi");
                        tableModel.addRow(new Object[]{newId, newNamaMk, newDeskripsi});
                    }

                    JOptionPane.showMessageDialog(null, "Mata kuliah berhasil diupdate!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaMk = textNamaMk.getText();
                    String deskripsi = textDeskripsi.getText();

                    Connection connection = DatabaseConnection.getConnection();
                    String sql = "INSERT INTO mata_kuliah (nama_mk, deskripsi) VALUES (?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, namaMk);
                    preparedStatement.setString(2, deskripsi);
                    preparedStatement.executeUpdate();

                    // Refresh table
                    tableModel.setRowCount(0);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM mata_kuliah");
                    while (resultSet.next()) {
                        int newId = resultSet.getInt("id");
                        String newNamaMk = resultSet.getString("nama_mk");
                        String newDeskripsi = resultSet.getString("deskripsi");
                        tableModel.addRow(new Object[]{newId, newNamaMk, newDeskripsi});
                    }

                    JOptionPane.showMessageDialog(null, "Mata kuliah berhasil ditambahkan!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
}
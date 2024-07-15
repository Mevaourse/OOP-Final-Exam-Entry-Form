import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterPage extends JFrame {
    public RegisterPage() {
        setTitle("Form Pendaftaran");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(10, 20, 120, 25);
        add(labelNama);

        JTextField textNama = new JTextField(20);
        textNama.setBounds(150, 20, 200, 25);
        add(textNama);

        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(10, 60, 120, 25);
        add(labelAlamat);

        JTextField textAlamat = new JTextField(20);
        textAlamat.setBounds(150, 60, 200, 25);
        add(textAlamat);

        JLabel labelNoTelepon = new JLabel("No Telepon:");
        labelNoTelepon.setBounds(10, 100, 120, 25);
        add(labelNoTelepon);

        JTextField textNoTelepon = new JTextField(20);
        textNoTelepon.setBounds(150, 100, 200, 25);
        add(textNoTelepon);

        JLabel labelJurusan = new JLabel("Jurusan:");
        labelJurusan.setBounds(10, 140, 120, 25);
        add(labelJurusan);

        String[] jurusanOptions = {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Manajemen", "Akuntansi"};
        JComboBox<String> comboBoxJurusan = new JComboBox<>(jurusanOptions);
        comboBoxJurusan.setBounds(150, 140, 200, 25);
        add(comboBoxJurusan);

        JLabel labelRataRataNilai = new JLabel("Rata-Rata Nilai:");
        labelRataRataNilai.setBounds(10, 180, 120, 25);
        add(labelRataRataNilai);

        JTextField textRataRataNilai = new JTextField(20);
        textRataRataNilai.setBounds(150, 180, 200, 25);
        add(textRataRataNilai);

        JLabel labelAsalSekolah = new JLabel("Asal Sekolah:");
        labelAsalSekolah.setBounds(10, 220, 120, 25);
        add(labelAsalSekolah);

        JTextField textAsalSekolah = new JTextField(20);
        textAsalSekolah.setBounds(150, 220, 200, 25);
        add(textAsalSekolah);

        JLabel labelNamaWali = new JLabel("Nama Wali:");
        labelNamaWali.setBounds(10, 260, 120, 25);
        add(labelNamaWali);

        JTextField textNamaWali = new JTextField(20);
        textNamaWali.setBounds(150, 260, 200, 25);
        add(textNamaWali);

        JLabel labelNoHpWali = new JLabel("No HP Wali:");
        labelNoHpWali.setBounds(10, 300, 120, 25);
        add(labelNoHpWali);

        JTextField textNoHpWali = new JTextField(20);
        textNoHpWali.setBounds(150, 300, 200, 25);
        add(textNoHpWali);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 340, 100, 25);
        add(submitButton);

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
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

                    JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
}

package PendaftaranMahasiswa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(mainPanel);

        
        JLabel labelUsername = new JLabel("Username:");
        JTextField textUsername = new JTextField(20);
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField textPassword = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

     
        labelUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        textUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension fieldSize = new Dimension(200, 25);
        textUsername.setMaximumSize(fieldSize);
        textPassword.setMaximumSize(fieldSize);
        loginButton.setMaximumSize(new Dimension(100, 30));


        mainPanel.add(labelUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(textUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(labelPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(textPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(loginButton);

      
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText();
                String password = new String(textPassword.getPassword());

                if (validateLogin(username, password)) {
                    if (username.equals("admin")) {
                       
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new AdminPage();
                            }
                        });
                    } else {
                   
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new PendaftarPage(username);
                            }
                        });
                    }
                    frame.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static boolean validateLogin(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/pendaftaranmahasiswa";
        String dbUser = "root";
        String dbPassword = "KaiZenin2003";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);

            String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            return resultSet.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

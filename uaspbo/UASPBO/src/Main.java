import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(mainPanel);

        // Create components
        JLabel labelUsername = new JLabel("Username:");
        JTextField textUsername = new JTextField(20);
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField textPassword = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        // Center align components
        labelUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        textUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set component maximum sizes
        Dimension fieldSize = new Dimension(200, 25);
        textUsername.setMaximumSize(fieldSize);
        textPassword.setMaximumSize(fieldSize);
        loginButton.setMaximumSize(new Dimension(100, 30));

        // Add components to panel with spacing
        mainPanel.add(labelUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(textUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(labelPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(textPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(loginButton);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText();
                String password = new String(textPassword.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    new AdminPage();
                    frame.dispose();
                } else {
                    new PendaftarPage(username);
                    frame.dispose();
                }
            }
        });

        // Center frame on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 20, 80, 25);
        frame.add(labelUsername);

        JTextField textUsername = new JTextField(20);
        textUsername.setBounds(100, 20, 165, 25);
        frame.add(textUsername);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 50, 80, 25);
        frame.add(labelPassword);

        JPasswordField textPassword = new JPasswordField(20);
        textPassword.setBounds(100, 50, 165, 25);
        frame.add(textPassword);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        frame.add(loginButton);

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

        frame.setVisible(true);
    }
}

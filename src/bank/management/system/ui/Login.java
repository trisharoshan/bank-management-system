package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ATM Login");

        JLabel accLabel = new JLabel("Account No");
        accLabel.setBounds(50,50,100,30);

        JTextField accField = new JTextField();
        accField.setBounds(150,50,150,30);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setBounds(50,100,100,30);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(150,100,150,30);

        JButton login = new JButton("Login");
        login.setBounds(120,150,120,30);

        frame.add(accLabel);
        frame.add(accField);
        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(login);

        frame.setSize(350,250);
        frame.setLayout(null);
        frame.setVisible(true);

        login.addActionListener(e -> {

            try {

                Connection conn = Conn.getConnection();

                String sql = "SELECT * FROM customer WHERE account_no=? AND pin=?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1,accField.getText());
                ps.setString(2, new String(pinField.getPassword()));

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {

                    JOptionPane.showMessageDialog(frame,"Login Success");

                    new ATMMenu(Integer.parseInt(accField.getText()));

                }

                else {

                    JOptionPane.showMessageDialog(frame,"Invalid Login");

                }

            }

            catch(Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}
package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateAccount {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Create Account");

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,50,100,30);

        JTextField nameField = new JTextField();
        nameField.setBounds(150,50,150,30);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setBounds(50,100,100,30);

        JTextField pinField = new JTextField();
        pinField.setBounds(150,100,150,30);

        JButton create = new JButton("Create Account");
        create.setBounds(100,150,150,30);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(create);

        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

        create.addActionListener(e -> {

            try {

                Connection conn = Conn.getConnection();

                String sql = "INSERT INTO customer(name,pin,balance) VALUES(?,?,?)";

                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1,nameField.getText());
                ps.setString(2,pinField.getText());
                ps.setDouble(3,0);

                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()) {

                    int accNo = rs.getInt(1);

                    JOptionPane.showMessageDialog(frame,
                            "Account Created!\nYour Account Number: " + accNo);

                }

            }

            catch(Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}
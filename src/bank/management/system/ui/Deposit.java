package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Deposit {

    Deposit(int account){

        JFrame frame = new JFrame("Deposit Money");

        JLabel label = new JLabel("Enter Amount");
        label.setBounds(50,50,120,30);

        JTextField amountField = new JTextField();
        amountField.setBounds(150,50,150,30);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(120,120,120,30);

        frame.add(label);
        frame.add(amountField);
        frame.add(depositBtn);

        frame.setSize(350,250);
        frame.setLayout(null);
        frame.setVisible(true);

        depositBtn.addActionListener(e -> {

            try {

                double amount = Double.parseDouble(amountField.getText());

                Connection conn = Conn.getConnection();

                String updateBalance = "UPDATE customer SET balance = balance + ? WHERE account_no=?";

                PreparedStatement ps = conn.prepareStatement(updateBalance);

                ps.setDouble(1,amount);
                ps.setInt(2,account);

                ps.executeUpdate();

                String transaction = "INSERT INTO transactions(account_no,type,amount) VALUES(?,?,?)";

                PreparedStatement ps2 = conn.prepareStatement(transaction);

                ps2.setInt(1,account);
                ps2.setString(2,"Deposit");
                ps2.setDouble(3,amount);

                ps2.executeUpdate();

                JOptionPane.showMessageDialog(frame,"Money Deposited!");

            }

            catch(Exception ex){
                ex.printStackTrace();
            }

        });

    }
}
package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Withdraw {

    Withdraw(int account){

        JFrame frame = new JFrame("Withdraw Money");

        JLabel label = new JLabel("Enter Amount");
        label.setBounds(50,50,120,30);

        JTextField amountField = new JTextField();
        amountField.setBounds(150,50,150,30);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(120,120,120,30);

        frame.add(label);
        frame.add(amountField);
        frame.add(withdrawBtn);

        frame.setSize(350,250);
        frame.setLayout(null);
        frame.setVisible(true);

        withdrawBtn.addActionListener(e -> {

            try{

                double amount = Double.parseDouble(amountField.getText());

                Connection conn = Conn.getConnection();

                String checkBalance = "SELECT balance FROM customer WHERE account_no=?";

                PreparedStatement ps1 = conn.prepareStatement(checkBalance);
                ps1.setInt(1, account);

                ResultSet rs = ps1.executeQuery();

                if(rs.next()) {

                    double balance = rs.getDouble("balance");

                    if(balance >= amount) {

                        String update = "UPDATE customer SET balance = balance - ? WHERE account_no=?";

                        PreparedStatement ps2 = conn.prepareStatement(update);
                        ps2.setDouble(1, amount);
                        ps2.setInt(2, account);
                        ps2.executeUpdate();

                        JOptionPane.showMessageDialog(frame,"Withdrawal Successful");

                    } else {

                        JOptionPane.showMessageDialog(frame,"Insufficient Balance");

                    }
                }

            }

            catch(Exception ex){
                ex.printStackTrace();
            }

        });

    }

}
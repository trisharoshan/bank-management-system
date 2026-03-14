package bank.management.system.ui;

import javax.swing.*;

public class ATMMenu {

    int account;

    ATMMenu(int acc){

        account = acc;

        JFrame frame = new JFrame("ATM Menu");

        JButton deposit = new JButton("Deposit");
        deposit.setBounds(100,50,150,30);
        deposit.addActionListener(e -> {

            new Deposit(account);

        });

        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(100,100,150,30);
        withdraw.addActionListener(e -> {

            new Withdraw(account);

        });

        JButton balance = new JButton("Check Balance");
        balance.setBounds(100,150,150,30);
        balance.addActionListener(e -> {

            new BalanceEnquiry(account);

        });
        JButton statement = new JButton("Mini Statement");
        statement.setBounds(100,200,150,30);

        statement.addActionListener(e -> {

            new MiniStatement(account);

        });

        frame.add(deposit);
        frame.add(withdraw);
        frame.add(balance);
        frame.add(statement);

        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
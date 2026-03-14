package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceEnquiry {

    BalanceEnquiry(int account){

        try{

            Connection conn = Conn.getConnection();

            String sql = "SELECT balance FROM customer WHERE account_no=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,account);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                JOptionPane.showMessageDialog(null,
                        "Current Balance: " + rs.getDouble("balance"));

            }

        }

        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
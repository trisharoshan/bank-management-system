package bank.management.system.ui;

import bank.management.system.database.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MiniStatement {

    MiniStatement(int account){

        try{

            Connection conn = Conn.getConnection();

            String sql = "SELECT * FROM transactions WHERE account_no=? ORDER BY date DESC";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,account);

            ResultSet rs = ps.executeQuery();

            StringBuilder statement = new StringBuilder();

            while(rs.next()){

                statement.append(rs.getString("type"))
                        .append("  ")
                        .append(rs.getDouble("amount"))
                        .append("  ")
                        .append(rs.getTimestamp("date"))
                        .append("\n");

            }

            JTextArea area = new JTextArea(statement.toString());

            JOptionPane.showMessageDialog(null,new JScrollPane(area),"Mini Statement",JOptionPane.INFORMATION_MESSAGE);

        }

        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}

package hostel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;

public class Hostel {
    
    JFrame f;
    JButton bAdmin, bst, bback;
    ImageIcon i;
    JLabel l;
    
    void startPage(Connection con, Statement st)
    {
        f = new JFrame("Hostel");
        
        i = new ImageIcon(this.getClass().getResource("Start.jpg"));
        l = new JLabel(i);
        l.setSize(500,400);
        f.add(l);
        
        bAdmin = new JButton("Admin");
        bAdmin.setBounds(180, 120, 140, 45);
        bAdmin.setBackground(Color.decode("#87CEEB"));
        bAdmin.setForeground(Color.white);
        bAdmin.setFont(bAdmin.getFont().deriveFont(22f));
        f.add(bAdmin);
        bAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().adminLogin(con, st);
                f.dispose();
                
            }
        });
        
        
        bst = new JButton("Student");
        bst.setBounds(180, 180, 140, 45);
        bst.setBackground(Color.decode("#87CEEB"));
        bst.setForeground(Color.white);
        bst.setFont(bst.getFont().deriveFont(22f));
        f.add(bst);
        bst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().bLogAndRegister(con, st);
                f.dispose();
            }
        });
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        //f.getContentPane().setBackground(Color.WHITE);
    }
    
    void bLogAndRegister(Connection con, Statement st)
    {
        f = new JFrame("Hostel");
        
        
        i = new ImageIcon(this.getClass().getResource("slogin.jpg"));
        l = new JLabel(i);
        l.setSize(500,400);
        f.add(l);
        
        bAdmin = new JButton("Log In");
        bAdmin.setBounds(180, 120, 140, 45);
        bAdmin.setBackground(Color.decode("#87CEEB"));
        bAdmin.setFont(bAdmin.getFont().deriveFont(22f));
        f.add(bAdmin);
        bAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Login(con, st);
                f.dispose();
                
            }
        });
        
        
        bst = new JButton("Register");
        bst.setBounds(180, 180, 140, 45);
        bst.setBackground(Color.decode("#87CEEB"));
        bst.setFont(bst.getFont().deriveFont(22f));
        f.add(bst);
        
        bst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Register().registration(con, st);
                f.dispose();
            }
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 290, 70, 30);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(bback.getFont().deriveFont(15f));
        f.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().startPage(con, st);
                f.dispose();
            }
            
        });
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        //f.getContentPane().setBackground(Color.WHITE);
    }
    
    
    
    
    public static void main(String[] args) throws Exception {
        Connection con;
        Statement st;
        Class.forName("com.mysql.cj.jdbc.Driver");
                
        String url = "jdbc:mysql://localhost:3306/hostel";
        con = DriverManager.getConnection(url, "root", "");
        st = con.createStatement();
        new Hostel().startPage(con, st);
        //new Login(con, st);
        //new Register().registration(con, st);

    }

    
}

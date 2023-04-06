
package hostel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class Register {
    
    JFrame r;
    JPanel pr; JButton br,bback;
    JLabel l,lr,ln,lp,lm,le,la, lun;
    JTextField tn,tm,te,ta, tun; 
    String name,username,password,mobile,email,address;
    JPasswordField tp;ImageIcon i;
    
    ResultSet rs;
    
    
    public void registration(Connection con, Statement st)
    {
        r = new JFrame("Registration");
        
        i = new ImageIcon(this.getClass().getResource("register.jpg"));
        l = new JLabel(i);
        l.setSize(700,580);
        r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Registration Form");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.white);
        //lr.setFont(font);
        pr.add(lr);
        
        
        
        lun = new JLabel("User name");
        lun.setBounds(45, 150, 150, 50);
        lun.setFont(lun.getFont().deriveFont(20f));
        lun.setForeground(Color.white);
        //ln.setFont(font);
        l.add(lun);
        
        tun = new JTextField();
        tun.setBounds(200, 150, 447, 40);
        tun.setFont(font);
        r.add(tun);
        
        ln = new JLabel("Name");
        ln.setBounds(45, 200, 80, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.white);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 200, 447, 40);
        tn.setFont(font);
        r.add(tn);

        lp = new JLabel("Password");
        lp.setBounds(45, 250, 120, 50);
        lp.setFont(lp.getFont().deriveFont(20f));
        lp.setForeground(Color.white);
        l.add(lp);
        
        tp = new JPasswordField();
        tp.setBounds(200, 250, 446, 40);
        tp.setFont(font);
        r.add(tp);
        
        
        lm = new JLabel("Mobile");
        lm.setBounds(45, 300, 120, 50);
        lm.setFont(lm.getFont().deriveFont(20f));
        lm.setForeground(Color.white);
        l.add(lm);
        
        tm = new JTextField();
        tm.setBounds(200, 300, 446, 40);
        tm.setFont(font);
        r.add(tm);
        
        le = new JLabel("E-mail");
        le.setBounds(45, 350, 120, 50);
        le.setFont(le.getFont().deriveFont(20f));
        le.setForeground(Color.white);
        l.add(le);
        
        te = new JTextField();
        te.setBounds(200, 350, 446, 40);
        te.setFont(font);
        r.add(te);
        
        la = new JLabel("Address");
        la.setBounds(45, 400, 120, 50);
        la.setFont(la.getFont().deriveFont(20f));
        la.setForeground(Color.white);
        l.add(la);
        
        ta = new JTextField();
        ta.setBounds(200, 400, 446, 40);
        ta.setFont(font);
        r.add(ta);
        
               
        br = new JButton("Submit");
        br.setBounds(547, 480, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setFont(br.getFont().deriveFont(18f));
        br.setForeground(Color.white);
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tun.getText();
               name = tn.getText(); 
               password = new String(tp.getPassword());
               mobile = tm.getText();
               email = te.getText();
               address = ta.getText();
               
        	String nameRegex = "^[a-z A-Z]+$";	
                String mobileRegex = "^(\\+88)?01[3-9]\\d{8}";
                String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
                 
                String passRegex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&*]).{6,20}";
                
                if(name.isEmpty() || username.isEmpty() || password.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                    if(!Pattern.matches(nameRegex, name))
                    {
                        JOptionPane.showMessageDialog(null,"Only char is allowed");
                    }
                    else if(!Pattern.matches(emailRegex, email))
                {
                    JOptionPane.showMessageDialog(null,"in valid email");
                }
                else if(!Pattern.matches(mobileRegex, mobile))
                {
                    JOptionPane.showMessageDialog(null,"in valid mobile number");                
                }
                else if(!Pattern.matches(passRegex, password))
                {
               	 JOptionPane.showMessageDialog(null,"1 digit,1 lower,1 upper,1 special char and length 6-20");
                }
                else if(address.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"In-Valid address");                
                }
                
                else {

                   String rQuery = "Select username from register where username = '"+username+"'";
                   try {
    
                       rs = st.executeQuery(rQuery);
                       if(rs.next()){
                           JOptionPane.showMessageDialog(null,"Username must be unique");
                       }else{
                           
                           String Query = "Insert into register (username,name,password,mobile,email,address) values ('"+username+"','"+name+"','"+password+"','"+mobile+"','"+email+"','"+address+"')";
                           
                            st.executeUpdate(Query);
                            st.close();
                            con.close();
                            
                            JOptionPane.showMessageDialog(null,"Registration Successfuly");
                            r.dispose();
                       }
                       
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null,"Registration not Successfuly");
                   }
                 }

                }
                 
                
            		
            }
                 
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 480, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(bback.getFont().deriveFont(18f));
        bback.setForeground(Color.white);
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().bLogAndRegister(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,580);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    
}
